package com.pazz.java.web.controller;

import com.pazz.java.web.annotation.MyController;
import com.pazz.java.web.annotation.MyRequestMapping;
import com.pazz.java.web.annotation.MyRequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@MyController
@MyRequestMapping("/test")
public class TestController {

    @MyRequestMapping("/doTest")
    public String doTest(HttpServletRequest request, HttpServletResponse response, @MyRequestParam("name") String name) throws IOException {
        return name;
    }

    public String doTestB(HttpServletRequest request, HttpServletResponse response){
        return "doTestB";
    }

}
