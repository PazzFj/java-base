package com.pazz.java.design.builder;

/**
 * @author: 彭坚
 * @create: 2018/12/25 22:19
 * @description: 自行车生产线接口
 */
public interface BikeBuilder {

    // 组装轮胎
    void buildTyres();

    // 组装车架
    void buildFrame();

    // 组装GPS定位装置
    void buildGPS();

    // 获取自行车
    Bike getBike();

}
