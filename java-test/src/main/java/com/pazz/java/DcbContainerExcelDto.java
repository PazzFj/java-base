package com.pazz.java;

import lombok.Data;

/**
 * @author: 彭坚
 * @create: 2019/2/19 14:17
 * @description:
 */
@Data
public class DcbContainerExcelDto {

    // 订舱号
    private String blNo;
    //港区代码
    private String attribute1;
    //提还柜
    private String attribute2;
    // 箱型
    private String containerSizeType;
    // 长度
    private String containerLength;
    // 高度
    private String containerHeight;
    // 空重类型
    private String attribute3;
    // 箱主
    private String carrierName;
    // 有效期
    private String indateTime;
    // 备注
    private String remark;
    // 总数
    private Integer allCount;
    // 已提数
    private Integer expendCount;
    // PoolName
    private String poolName;
    //是否成功
    private Boolean isSuccess = true;

    public String getBlNo() {
        return blNo;
    }

    public void setBlNo(String blNo) {
        this.blNo = blNo;
    }

    public String getAttribute1() {
        return attribute1;
    }

    public void setAttribute1(String attribute1) {
        this.attribute1 = attribute1;
    }

    public String getAttribute2() {
        return attribute2;
    }

    public void setAttribute2(String attribute2) {
        this.attribute2 = attribute2;
    }

    public String getContainerSizeType() {
        return containerSizeType;
    }

    public void setContainerSizeType(String containerSizeType) {
        this.containerSizeType = containerSizeType;
    }

    public String getContainerLength() {
        return containerLength;
    }

    public void setContainerLength(String containerLength) {
        this.containerLength = containerLength;
    }

    public String getContainerHeight() {
        return containerHeight;
    }

    public void setContainerHeight(String containerHeight) {
        this.containerHeight = containerHeight;
    }

    public String getAttribute3() {
        return attribute3;
    }

    public void setAttribute3(String attribute3) {
        this.attribute3 = attribute3;
    }

    public String getCarrierName() {
        return carrierName;
    }

    public void setCarrierName(String carrierName) {
        this.carrierName = carrierName;
    }

    public String getIndateTime() {
        return indateTime;
    }

    public void setIndateTime(String indateTime) {
        this.indateTime = indateTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getAllCount() {
        return allCount;
    }

    public void setAllCount(Integer allCount) {
        this.allCount = allCount;
    }

    public Integer getExpendCount() {
        return expendCount;
    }

    public void setExpendCount(Integer expendCount) {
        this.expendCount = expendCount;
    }

    public String getPoolName() {
        return poolName;
    }

    public void setPoolName(String poolName) {
        this.poolName = poolName;
    }

    public Boolean getSuccess() {
        return isSuccess;
    }

    public void setSuccess(Boolean success) {
        isSuccess = success;
    }
}
