package com.pazz.java.images;

import com.baidu.aip.ocr.AipOcr;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: 彭坚
 * @create: 2019/3/29 16:33
 * @description:
 */
public final class ImageUtils {

    private static final Log logger = LogFactory.getLog(ImageUtils.class);

    //设置APPID/AK/SK
    public static final String APP_ID = "15877758";
    public static final String API_KEY = "cwpUYgjYlGTzqsVlF0nEnc6E";
    public static final String SECRET_KEY = "WaWQe9TZnitCcY7ayenjKxVTXzOsGOEo";

    public static final String ID_CARD_SIDE_FRONT = "front"; //front：身份证含照片的一面; back：身份证带国徽的一面
    public static final String ID_CARD_SIDE_BACK = "back"; //front：身份证含照片的一面; back：身份证带国徽的一面

    // 传入可选参数调用接口
    public static final HashMap<String, String> OPTIONS = new HashMap<String, String>();

    private static AipOcr client;

    static {
        OPTIONS.put("detect_direction", "false"); //是否检测图像朝向，默认不检测
        OPTIONS.put("detect_risk", "false");      //是否开启身份证风险类型
    }

    public static AipOcr getAipOcr() {
        if (client == null) {
            client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);
        }
        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);
        return client;
    }

    public static JSONObject idCard(byte[] image, String side) {
        // 初始化一个AipOcr
        AipOcr client = getAipOcr();
        // 参数为本地路径
        return client.idcard(image, side, OPTIONS);
    }

    public static JSONObject businessLicense(String image){
        // 初始化一个AipOcr
        AipOcr client = getAipOcr();
        // 参数为本地路径
        return client.businessLicense(image, OPTIONS);
    }

    /**
     * @param stream 图片返回对象
     * @param type   获取类型 ： 姓名、身份证号、地址
     * @return
     */
    public static String getDataByCardStream(JSONObject stream, String type) {
        Object obj = getCardEntity(stream);  // ResultCache 结果集封装对象
        if(obj instanceof String){
            return (String) obj;  //返回错误信息
        }
        return build(obj, type);
    }

    public static String build(Object obj, String type){
        if (obj instanceof ResultCache) {
            ResultCache cardEntity = (ResultCache) obj;
            cardEntity.build(type);
            String value = cardEntity.get(type);
            if(null != value || !"".equals(value)){
                return value;
            }
        }
        return null;
    }

    /**
     * 识别成功才返回结果, 则返回null
     */
    public static Object getCardEntity(JSONObject res) {
        String status = res.getString("image_status");
        if ("normal".equals(status)) {
            JSONObject result = res.getJSONObject("words_result");
            ResultCache cardEntity = new ResultCache(result);
            return cardEntity;
        }
        return status;
    }

    public static Object getDrivingEntity(JSONObject res) {
        Object result = res.get("words_result");
        if (result instanceof JSONObject) {
            ResultCache cardEntity = new ResultCache((JSONObject) result);
            return cardEntity;
        }
        return "error";
    }

    public static String getDataByDrivingStream(JSONObject stream, String type) {
        Object obj = getDrivingEntity(stream);
        if (obj instanceof ResultCache) {
            ResultCache drivingEntity = (ResultCache) obj;
            drivingEntity.build(type);
            return drivingEntity.get(type);
        }
        return (String) obj;
    }

    public static JSONObject drivingLicense(byte[] image) {
        // 初始化一个AipOcr
        AipOcr client = getAipOcr();
        // 参数为本地路径
        return client.drivingLicense(image, OPTIONS);
    }


    static class ResultCache {
        private Map<String, PropertyWrap> wrapMap = new HashMap<>();
        private JSONObject result;

        public ResultCache(JSONObject result) {
            if (result == null) {
                throw new NullPointerException("JSON Object is not null!");
            }
            this.result = result;
        }

        public void build(String type) {
            PropertyWrap wrap = new PropertyWrap(type, result.getJSONObject(type));
            wrapMap.put(type, wrap);
        }

        public String get(String key) {
            PropertyWrap wrap = wrapMap.get(key);
            if (wrap != null) {
                return wrap.getValue();
            }
            return null;
        }

        public JSONObject getResult() {
            return result;
        }

        public void setResult(JSONObject result) {
            this.result = result;
        }
    }

    static class PropertyWrap {

        private String name;
        private String value;
        private JSONObject jsonObject;

        public PropertyWrap(String name, JSONObject jsonObject) {
            this.name = name;
            if (jsonObject != null) {
                this.jsonObject = jsonObject;
                this.value = jsonObject.getString("words");
            }
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public JSONObject getJsonObject() {
            return jsonObject;
        }

        public void setJsonObject(JSONObject jsonObject) {
            this.jsonObject = jsonObject;
        }
    }

    public enum PropertyType {
        NAME_TYPE("NAME", "姓名"),
        SEX_TYPE("SEX", "性别"),
        ADDRESS_TYPE("ADDRESS", "住址"),
        NUMBER_TYPE("NUMBER", "公民身份号码"),
        NATION_TYPE("NATION", "民族"),
        SIGN_DATE_TYPE("SIGN_DATE_TYPE", "签发日期"),
        EXPIRY_DATE_TYPE("EXPIRY_DATE_TYPE", "失效日期"),
        START_TIME_TYPE("START_TIME_TYPE", "有效起始日期"),
        START_TYPE("START_TYPE", "有效期限");

        private String code;
        private String name;

        PropertyType(String code, String name) {
            this.code = code;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public String getCode() {
            return code;
        }
    }

    public static class ResultType {
        private static final Map<String, String> map = new HashMap<>();
        static {
            map.put("normal", "识别正常");
            map.put("reversed_side", "未摆正身份证");
            map.put("non_idcard", "上传的图片中不包含身份证");
            map.put("blurred", "身份证模糊");
            map.put("over_exposure", "身份证关键字段反光或过曝");
            map.put("unknown", "未知状态");
            map.put("识别", "识别失败!");
        }

        private ResultType() {
        }

        public static Map<String, String> getMap() {
            return map;
        }
    }

}
