package com.wwt.spring.demo;

public class DependBean {
    private String dependProperty;

    public void setDependProperty(String dependProperty) {
        this.dependProperty = dependProperty;
    }

    @Override
    public String toString() {
        return "DependBean{" +
                "dependProperty='" + dependProperty + '\'' +
                '}';
    }
}
