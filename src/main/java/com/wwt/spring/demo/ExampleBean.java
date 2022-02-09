package com.wwt.spring.demo;

public class ExampleBean {
    private String propertyNull;

    private String propertyEmpty;

    private String propertyLiteral1;

    ////包含特殊符号的字面量
    private String propertyLiteral2;

    //依赖的 Bean(对象属性)
    private DependBean dependBean;

    public void setPropertyNull(String propertyNull) {
        this.propertyNull = propertyNull;
    }

    public void setPropertyEmpty(String propertyEmpty) {
        this.propertyEmpty = propertyEmpty;
    }

    public void setPropertyLiteral1(String propertyLiteral1) {
        this.propertyLiteral1 = propertyLiteral1;
    }

    public void setPropertyLiteral2(String propertyLiteral2) {
        this.propertyLiteral2 = propertyLiteral2;
    }

    public void setDependBean(DependBean dependBean) {
        this.dependBean = dependBean;
    }

    //使用级联属性赋值时，需提供一个依赖对象的 getXxx() 方法
    public DependBean getDependBean() {
        return dependBean;
    }

    @Override
    public String toString() {
        return "ExampleBean{" +
                "propertyNull='" + propertyNull + '\'' +
                ", propertyEmpty='" + propertyEmpty + '\'' +
                ", propertyLiteral1='" + propertyLiteral1 + '\'' +
                ", propertyLiteral2='" + propertyLiteral2 + '\'' +
                ", dependBean=" + dependBean +
                '}';
    }
}
