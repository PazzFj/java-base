package com.pazz.java.image;

import com.baidu.aip.ocr.AipOcr;
import lombok.Data;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

/**
 * @author: 彭坚
 * @create: 2019/3/29 16:33
 * @description:
 */
public final class ImageUtils2 {

    private static final Logger logger = LoggerFactory.getLogger(ImageUtils2.class);

    //设置APPID/AK/SK
    public static final String APP_ID = "15877758";
    public static final String API_KEY = "cwpUYgjYlGTzqsVlF0nEnc6E";
    public static final String SECRET_KEY = "WaWQe9TZnitCcY7ayenjKxVTXzOsGOEo";

    public static final String ID_CARD_SIDE_FRONT = "front"; //front：身份证含照片的一面
    public static final String ID_CARD_SIDE_BACK = "back"; //back：身份证带国徽的一面

    // 传入可选参数调用接口
    public static final HashMap<String, String> OPTIONS = new HashMap<String, String>();

    private static AipOcr client;

    static {
        OPTIONS.put("detect_direction", "false"); //是否检测图像朝向，默认不检测
        OPTIONS.put("detect_risk", "false");      //是否开启身份证风险类型
    }

    /**
     * 识别成功才返回结果, 则返回null
     */
    public static CardEntity getCardEntity(JSONObject res) {
        System.out.println(res.toString());
        if ("normal".equals(res.getString("image_status"))) {
            JSONObject result = res.getJSONObject("words_result");
            CardEntity cardEntity = new CardEntity(result);
            return cardEntity;
        }
        return null;
    }

    public static CardEntity getDrivingEntity(JSONObject res) {
        System.out.println(res.toString());
        if (res.get("words_result") != null) {
            JSONObject result = res.getJSONObject("words_result");
            CardEntity cardEntity = new CardEntity(result);
            return cardEntity;
        }
        return null;
    }

    /**
     * @param imageUrl 图片地址
     * @param type     获取类型 ： 姓名、身份证号、地址
     * @return
     */
    public static String getWordsResultByCard(String imageUrl, String type, String side) {
        JSONObject res = idCard(imageUrl, side);
        CardEntity cardEntity = getCardEntity(res).build(type);
        return cardEntity == null ? null : cardEntity.get(type);
    }

    public static String getWordsResultByDriving(String imageUrl, String type, String side) {
        JSONObject res = drivingLicense(imageUrl, side);
        CardEntity cardEntity = getDrivingEntity(res).build(type);
        return cardEntity == null ? null : cardEntity.get(type);
    }

    public static String getWordsResultByCard(byte[] image, String type, String side) {
        JSONObject res = idCard(image, side);
        logger.info("==>> JSONObject2: " + res.toString());
        CardEntity cardEntity = getCardEntity(res).build(type);
        return cardEntity == null ? null : cardEntity.get(type);
    }

    public static JSONObject idCard(String image, String side) {
        // 初始化一个AipOcr
        AipOcr client = getAipOcr();
        // 参数为本地路径
        return client.idcard(image, side, OPTIONS);
    }

    public static JSONObject drivingLicense(String image, String side) {
        // 初始化一个AipOcr
        AipOcr client = getAipOcr();
        // 参数为本地路径
        return client.drivingLicense(image, OPTIONS);
    }

    public static JSONObject idCard(byte[] image, String side) {
        // 初始化一个AipOcr
        AipOcr client = getAipOcr();
        // 参数为本地路径
        return client.idcard(image, side, OPTIONS);
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

    public static JSONObject drivingLicense(String image) {
        // 初始化一个AipOcr
        AipOcr client = getAipOcr();
        // 参数为本地路径
        return client.drivingLicense(image, OPTIONS);
    }


    @Data
    static class CardEntity {

        private ValueEntity valueEntity;
        private JSONObject result;

        public CardEntity(JSONObject result) {
            if (result == null) {
                throw new NullPointerException("JSON Object is not null!");
            }
            this.result = result;
        }

        public CardEntity build(String type) {
            this.valueEntity = new ValueEntity(type, result.getJSONObject(type));
            return this;
        }

        public String get(String key) {
            if (valueEntity != null && valueEntity.getName().equals(key)) {
                return valueEntity.getValue();
            }
            return null;
        }
    }

    @Data
    static class ValueEntity {

        private String name;
        private String value;
        private JSONObject jsonObject;

        public ValueEntity(String name, JSONObject jsonObject) {
            this.name = name;
            if (jsonObject != null) {
                this.jsonObject = jsonObject;
                this.value = jsonObject.getString("words");
            }
        }

    }

    public enum JsonObjectType {

        NAME_TYPE("NAME", "姓名"),
        SEX_TYPE("SEX", "性别"),
        ADDRESS_TYPE("ADDRESS", "住址"),
        NUMBER_TYPE("NUMBER", "公民身份号码"),
        NATION_TYPE("NATION", "民族"),
        START_TIME_TYPE("START_TIME_TYPE", "有效起始日期"),
        START_TYPE("START_TYPE", "有效期限"),
        EXPIRY_DATE_TYPE("EXPIRY_DATE_TYPE", "失效日期"),
        SIGN_DATE_TYPE("SIGN_DATE_TYPE", "签发日期"),
        INDATE_TYPE("INDATE", "身份证有效期");

        private String code;
        private String name;

        JsonObjectType(String code, String name) {
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

}
