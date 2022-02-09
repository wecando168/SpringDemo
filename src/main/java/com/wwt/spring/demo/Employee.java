package com.wwt.spring.demo;

public class Employee {
    //员工编号
    private String empNo;
    //员工姓名
    private String empName;
    //部门信息
    private Dept dept;

    //无参构造方法，在没有其他带参构造方法的情况下，可以省略
    public Employee() {
        System.out.println("正在执行 Employee 的无参构造方法>>>>");
    }

    public Employee(String empNo, String empName, Dept dept) {
        System.out.println("正在执行 Employee 的有参构造方法>>>>");
        this.empNo = empNo;
        this.empName = empName;
        this.dept = dept;
    }

    public void setEmpNo(String empNo) {
        System.out.println("正在执行 Employee 的 setEmpNo 方法>>>>");
        this.empNo = empNo;
    }

    public void setEmpName(String empName) {
        System.out.println("正在执行 Employee 的 setEmpName 方法>>>>");
        this.empName = empName;
    }

    public void setDept(Dept dept) {
        System.out.println("正在执行 Employee 的 setDept 方法>>>>");
        this.dept = dept;
    }

    public Dept getDept() {
        System.out.println("正在执行 Employee 的 getDept 方法>>>>");
        return dept;
    }

    public String getEmpNo() {
        System.out.println("正在执行 Employee 的 getEmpNo 方法>>>>");
        return empNo;
    }
    public String getEmpName() {
        System.out.println("正在执行 Employee 的 getEmpName 方法>>>>");
        return empName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empNo='" + empNo + '\'' +
                ", empName='" + empName + '\'' +
                ", dept=" + dept +
                '}';
    }
}
