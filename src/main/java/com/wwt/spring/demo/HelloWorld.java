package com.wwt.spring.demo;

public class HelloWorld {
    private String message;

    public HelloWorld() {

    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void getMessage() {
        System.out.println("message:" + message);
    }

    public void init() {
        System.out.println("Bean 正在初始化");
    }

    public void destroy() {
        System.out.println("Bean 将要被销毁");
    }
}
