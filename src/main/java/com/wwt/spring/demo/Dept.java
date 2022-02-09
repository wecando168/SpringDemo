package com.wwt.spring.demo;

public class Dept {
    //部门编号
    private String deptNo;
    //部门名称
    private String deptName;

    //无参构造方法，在没有其他带参构造方法的情况下，可以省略
    public Dept(){
        System.out.println("正在执行 Dept 的无参构造方法>>>>");
    }

    public Dept(String deptNo, String deptName) {
        System.out.println("正在执行 Dept 的有参构造方法>>>>");
        this.deptNo = deptNo;
        this.deptName = deptName;
    }

    public void setDeptNo(String deptNo) {
        System.out.println("正在执行 Dept 的 setDeptNo 方法>>>>");
        this.deptNo = deptNo;
    }

    public void setDeptName(String deptName) {
        System.out.println("正在执行 Dept 的 setDeptName 方法>>>>");
        this.deptName = deptName;
    }

    public String getDeptNo() {
        System.out.println("正在执行 Dept 的 getDeptNo 方法>>>>");
        return deptNo;
    }

    public String getDeptName() {
        System.out.println("正在执行 Dept 的 getDeptName 方法>>>>");
        return deptName;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptNo='" + deptNo + '\'' +
                ", deptName='" + deptName + '\'' +
                '}';
    }
}
