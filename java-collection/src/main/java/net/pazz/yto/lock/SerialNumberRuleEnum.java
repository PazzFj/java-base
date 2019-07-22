package net.pazz.yto.lock;

/**
 * @author: Peng Jian
 * @date: 2018/6/15 9:42
 * @description: generatedNumber 生成单号
 */
public enum SerialNumberRuleEnum {

    // 1、中文名称 2、 编码 3、是否需要输入参数 4、是否需要日期prefix   5、日期prefix
    // 6、是否需要分隔符  7、分隔符 8、是否需要字母前缀 9、字母prefix 10、是否需要数字累加,
    // 11、是否固定位数FIXED 12、数字位数 13、是否需要后缀suffix 14、后缀值
    STL_STOCK_IN_ORDER("账单编号", "ZDBH", false, false, "日期prefix", false, "分隔符", true, "ZDBH", true, true, 10, false, "后缀值");
    private String name;              //中文名称
    private String code;              //编码
    private boolean needParams;          //是否需要输入参数
    private boolean needTime;          //是否需要日期prefix
    private String timeFormat;          //日期prefix
    private boolean needDelimiter;      //是否需要分隔符
    private String delimiter;          //分隔符
    private boolean needLetterPrefix; //是否需要字母前缀
    private String letterPrefix;      //字母prefix
    private boolean needNumber;          //是否需要数字累加
    private boolean fixedNumLen;      //是否固定位数FIXED
    private int numLen;                  //数字位数
    private boolean needLetterSuffix; //是否需要后缀suffix
    private String letterSuffix;      //后缀值

    private SerialNumberRuleEnum(String name, String code, boolean needParams,
                                 boolean needTime, String timeFormat, boolean needDelimiter, String delimiter,
                                 boolean needLetterPrefix, String letterPrefix, boolean needNumber,
                                 boolean fixedNumLen, int numLen, boolean needLetterSuffix, String letterSuffix) {
        this.name = name;
        this.code = code;
        this.needParams = needParams;
        this.needTime = needTime;
        this.timeFormat = timeFormat;
        this.needDelimiter = needDelimiter;
        this.delimiter = delimiter;
        this.needLetterPrefix = needLetterPrefix;
        this.letterPrefix = letterPrefix;
        this.needNumber = needNumber;
        this.fixedNumLen = fixedNumLen;
        this.numLen = numLen;
        this.needLetterSuffix = needLetterSuffix;
        this.letterSuffix = letterSuffix;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isNeedParams() {
        return needParams;
    }

    public void setNeedParams(boolean needParams) {
        this.needParams = needParams;
    }

    public boolean isNeedTime() {
        return needTime;
    }

    public void setNeedTime(boolean needTime) {
        this.needTime = needTime;
    }

    public String getTimeFormat() {
        return timeFormat;
    }

    public void setTimeFormat(String timeFormat) {
        this.timeFormat = timeFormat;
    }

    public boolean isNeedDelimiter() {
        return needDelimiter;
    }

    public void setNeedDelimiter(boolean needDelimiter) {
        this.needDelimiter = needDelimiter;
    }

    public String getDelimiter() {
        return delimiter;
    }

    public void setDelimiter(String delimiter) {
        this.delimiter = delimiter;
    }

    public boolean isNeedNumber() {
        return needNumber;
    }

    public void setNeedNumber(boolean needNumber) {
        this.needNumber = needNumber;
    }

    public boolean isFixedNumLen() {
        return fixedNumLen;
    }

    public void setFixedNumLen(boolean fixedNumLen) {
        this.fixedNumLen = fixedNumLen;
    }

    public int getNumLen() {
        return numLen;
    }

    public void setNumLen(int numLen) {
        this.numLen = numLen;
    }

    public boolean isNeedLetterSuffix() {
        return needLetterSuffix;
    }

    public void setNeedLetterSuffix(boolean needLetterSuffix) {
        this.needLetterSuffix = needLetterSuffix;
    }

    public String getLetterSuffix() {
        return letterSuffix;
    }

    public void setLetterSuffix(String letterSuffix) {
        this.letterSuffix = letterSuffix;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLetterPrefix() {
        return letterPrefix;
    }

    public void setLetterPrefix(String letterPrefix) {
        this.letterPrefix = letterPrefix;
    }

    public boolean isNeedLetterPrefix() {
        return needLetterPrefix;
    }

    public void setNeedLetterPrefix(boolean needLetterPrefix) {
        this.needLetterPrefix = needLetterPrefix;
    }

//    STL_MATERIAL_PURCHASE_STOCK_IN_ORDER("账单编号", "ZDBH", false, false, "日期prefix", false, "分隔符", true, "ZDBH", true, true, 10, false, "后缀值");
//    STL_MATERIAL_PURCHASE_ORDER("物料申购通知单", "WLSGTZD", false, false, "日期prefix", false, "分隔符", true, "SG", true, true, 10, false, "后缀值"),
//    STL_MATERIAL_PURCHASE_STOCK_ORDER("物料采购通知单", "CGTZD", false, false, "", false, "", true, "CG", true, true, 10, false, ""),
//    STL_MATERIAL_ALLOCATION_ORDER("物料调拨通知单", "WLDBTZD", false, false, "", false, "", true, "DB", true, true, 10, false, ""),
//    STL_MATERIAL_STOCK_OUT_ORDER("物料出库通知单", "WLCKTZD", false, false, "", false, "", true, "CKT", true, true, 10, false, ""),
//    STL_MATERIAL_STOCK_IN_ORDER("物料入库通知单", "WLRKTZD", false, false, "", false, "", true, "RKT", true, true, 10, false, ""),
//    STL_MATERIAL_ISSUING_ORDER("发放单", "FFD", false, false, "", false, "", true, "MA", true, true, 10, false, ""),
//    STL_MATERIAL_STOCK("仓库","WLCK",false,false,"",false,"",true,"CK",true,true,8,false,""),
//    STL_MATERIAL_ISSUING_REVOKE_ORDER("撤销发放单","CXFFD",false,false,"",false,"",true,"CX",true,true,10,false,""),
//    STL_DEPOSIT_MASTER_ACCOUNT("组织主账户","ZZMZH",false,false,"",false,"",false,"",true,true,8,false,""),
//    STL_DEPOSIT_RECHARGE("实收单号","SHDH",false,false,"",false,"",true,"RFD",true,true,8,false,""),
//    STL_DEPOSIT_SUB_ACCOUNT("组织子账户","ZZSZH",false,false,"",false,"",false,"",true,true,8,false,""),
//    STL_DEPOSIT_WITHDRAW_APPLY_ORDER("提现申请单","TXSQD",false,false,"",false,"",true,"TX",true,true,10,false,""),
//    STL_DEPOSIT_SUB_ACCOUNT_DEAL_CODE("组织子账户交易流水号","ZZZZHJYLSH",false,false,"",false,"",false,"",true,true,16,false,""),
//    STL_DEPOSIT_TRANSFER_CODE("转账编号","ZZBH",false,false,"",false,"",true,"ZZ",true,true,10,false,""),
//    STL_DEPOSIT_FEE_APPLY_CODE("运单号","YDH",false,false,"",false,"",true,"Y",true,true,12,false,""),
//    STL_DEPOSIT_FEE_ADJUST_CODE("调整单号","TZDH",false,true,"yyyyMM",false,"",false,"",true,true,5,false,""),
//    BSE_CUSTOMER_CODE("客户号","KHH",false,false,"",false,"",true,"C",true,true,10,false,""),
//    QAS_HEADLESS_CODE("无头件编号","WTJ",false,true,"yyMMdd",false,"",true,"QAW",true,true,6,false,""),
//    QAS_ARBITRATION_CODE("仲裁编号","ZCBH",false,true,"yyMMdd",false,"",true,"QAZ",true,true,6,false,""),
//    QAS_COMPLAINT_CODE("申诉编号","SSBH",false,true,"yyMMdd",false,"",true,"QAS",true,true,6,false,""),
//    QAS_ERRORINFO_CODE("差错编号","CCBH",false,true,"yyMMdd",false,"",true,"QAC",true,true,6,false,""),
//    QAS_PROBLEM_CODE("问题件编号","WTJBH",false,true,"yyMMdd",false,"",true,"QAP",true,true,6,false,""),
//    CMS_STOCK_TAKE_CODE("PDA盘库编号","PDAPKBH",false,true,"yyMMdd",false,"",true,"PK",true,true,6,false,"")

}
