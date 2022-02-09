package com.wwt.spring.demo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Grade {
    private static final Log LOGGER = LogFactory.getLog(Grade.class);
    private Integer gradeId;
    private  String gradeName;

    /**
     * 无参构造函数
     * 若该类中不存在其他的带参构造函数，则这个默认的无参构造函数可以省略
     */
    public Grade() {
    }

    public void setGradeId(Integer gradeId) {
        LOGGER.info("正在执行 Grade 类的 setGradeId() 方法…… ");
        this.gradeId = gradeId;
    }
    public void setGradeName(String gradeName) {
        LOGGER.info("正在执行 Grade 类的 setGradeName() 方法…… ");
        this.gradeName = gradeName;
    }

    public Grade(Integer gradeId,String gradeName){
        LOGGER.info("正在执行 Course 的有参构造方法，参数分别为：gradeId=" + gradeId + ",gradeName=" + gradeName);
        this.gradeId = gradeId;
        this.gradeName = gradeName;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "gradeId=" + gradeId +
                ", gradeName='" + gradeName + '\'' +
                '}';
    }
}
