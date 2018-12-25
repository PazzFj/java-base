package com.pazz.java.design.builder;

/**
 * @author: 彭坚
 * @create: 2018/12/25 22:23
 * @description: 工程部门作为指挥者，可以指导生产部门作业
 */
public class EngineeringDepartment {

    private BikeBuilder bikeBuilder;

    //用户告知指挥者想要什么样的单车
    public EngineeringDepartment(BikeBuilder bikeBuilder) {
        this.bikeBuilder = bikeBuilder;
    }

    // 指导组装单车
    public void construct() {
        bikeBuilder.buildFrame();
        bikeBuilder.buildTyres();
        bikeBuilder.buildGPS();
    }

}
