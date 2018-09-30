package com.pazz.java;

import com.pazz.java.delegate.Delegate;
import com.pazz.java.delegate.ExectorA;
import com.pazz.java.delegate.ExectorManager;
import com.pazz.java.prototype.Shape;
import com.pazz.java.prototype.ShapeCache;

/**
 * delegate 委派模式
 * factory 工厂模式
 * prototype 原型模式
 * proxy 代理模式
 * singleton 单例模式
 * strategy 策略模式
 * template 模板模式
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
        //delegate
        Delegate delegate = new ExectorA();
        ExectorManager exectorManager = new ExectorManager(delegate) ;
        exectorManager.doWork();

        //prototype  -------->> Object.clone();
        ShapeCache.loadCache();
        Shape shape = ShapeCache.getShape("2");
        System.out.println(shape);


    }
}
