package com.pazz.java.design.builder;

/**
 * 建造者模式
 *
 * @Auther peng jian
 * @Date 2020/1/2 15:38
 */
public class $_Main {
    public static void main(String[] args) {
        System.out.println("****************建造者模式***************");
        BikeBuilder moBike = new MoBikeBuilder();
        EngineeringDepartment department = new EngineeringDepartment(moBike);
        department.construct();
        System.out.println(moBike.getBike());


        BikeBuilder ofoBike = new OfoBikeBuilder();
        EngineeringDepartment ofoBikeDepartment = new EngineeringDepartment(ofoBike);
        ofoBikeDepartment.construct();
        System.out.println(ofoBike.getBike());
    }
}
