package com.pazz.java.image;

import com.baidu.aip.ocr.AipOcr;
import org.json.JSONObject;

/**
 * @author: 彭坚
 * @create: 2019/3/28 15:50
 * @description:
 */
public class Simple {

    public static void main(String[] args) {
        String image = "D:\\repository\\pazzfj\\java\\java-test\\src\\main\\java\\com\\pazz\\java\\image\\123.jpg";
        AipOcr aipOcr = ImageUtils.getAipOcr();
        JSONObject jsonObject = aipOcr.idcard(image, "back", ImageUtils.OPTIONS);
        System.out.println(jsonObject.getJSONObject("words_result").toString());
        System.out.println(jsonObject.toString());
    }

//    //设置APPID/AK/SK
//    public static final String APP_ID = "15877758";
//    public static final String API_KEY = "cwpUYgjYlGTzqsVlF0nEnc6E";
//    public static final String SECRET_KEY = "WaWQe9TZnitCcY7ayenjKxVTXzOsGOEo";
//
//    public static void main(String[] args) {
//        // 初始化一个AipOcr
//        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);
//        // 可选：设置网络连接参数
////        client.setConnectionTimeoutInMillis(2000);
////        client.setSocketTimeoutInMillis(60000);
//        // 传入可选参数调用接口
//        HashMap<String, String> options = new HashMap<String, String>();
//        options.put("detect_direction", "false"); //是否检测图像朝向，默认不检测
//        options.put("detect_risk", "false");      //是否开启身份证风险类型
//
//        String idCardSide = "front"; //front：身份证含照片的一面；back：身份证带国徽的一面
//
//        // 参数为本地路径
//        String image = "D:\\repository\\pazzfj\\java\\java-test\\src\\main\\java\\com\\pazz\\java\\image\\sfx.jpg";
//        JSONObject res = client.idcard(image, idCardSide, options);
//        if("normal".equals(res.getString("image_status"))){
//            JSONObject result = res.getJSONObject("words_result");
//            CardEntity cardEntity = new CardEntity(result);
//            cardEntity.build();
//            String str = cardEntity.getNumberJson().getValue();
//            System.out.println(str);
//        }
//    }

//    @Data
//    static class CardEntity {
//        private ValueEntity nameJson; //姓名
//        private ValueEntity sexJson;  //性别
//        private ValueEntity addressJson; //住址
//        private ValueEntity numberJson;  //公民身份号码
//        private ValueEntity nationJson;  //民族
//        private JSONObject result;
//
//        private CardEntity(JSONObject result) {
//            this.result = result;
//        }
//
//        public void build() {
//            this.nameJson = new ValueEntity(result.getJSONObject("姓名"));
//            this.sexJson = new ValueEntity(result.getJSONObject("性别"));
//            this.addressJson = new ValueEntity(result.getJSONObject("住址"));
//            this.numberJson = new ValueEntity(result.getJSONObject("公民身份号码"));
//            this.nationJson = new ValueEntity(result.getJSONObject("民族"));
//        }
//    }
//
//    @Data
//    static class ValueEntity{
//        private String value;
//        private JSONObject jsonObject;
//
//        public ValueEntity(JSONObject jsonObject) {
//            if(jsonObject != null) {
//                this.jsonObject = jsonObject;
//                this.value = jsonObject.getString("words");
//            }
//        }
//    }
//
//    @Data
//    static class InfoEntity {
//        private String image_status;//识别状态  normal-识别正常  blurred-身份证模糊  non_idcard-上传的图片中不包含身份证  reversed_side-身份证正反面颠倒  unknown-未知状态
////        private int direction;  //图像方向  -1:未定义， 0:正向， 1: 逆时针90度，2:逆时针180度，3:逆时针270度
////        private int words_result_num;  //识别结果数，表示words_result的元素个数
//        /**
//         * {"姓名":
//         *      {
//         *       "words":"彭坚",
//         *       "location": {"top":185,"left":390,"width":82,"height":32}
//         *      },
//         * "民族":
//         *      {
//         *       "words":"汉",
//         *       "location": {"top":252,"left":546,"width":22,"height":24}
//         *      }
//         * }
//         */
//        private Object words_result;  //定位和识别结果数组
//
//        public InfoEntity(JSONObject jsonObject) {
//            this.image_status = jsonObject.getString("image_status");
////            this.direction = (int) jsonObject.get("direction");
////            this.words_result_num = (int) jsonObject.get("words_result_num");
//            this.words_result = jsonObject.get("words_result");
//        }
//    }

}
