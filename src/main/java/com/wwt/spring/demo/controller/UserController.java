package com.wwt.spring.demo.controller;

import com.wwt.spring.demo.service.UserService;
import org.springframework.stereotype.Controller;
import javax.annotation.Resource;

//@Controller 注解通常作用在控制层（如 Struts2 的 Action、SpringMVC 的 Controller），用于将控制层的类标识为 Spring 中的 Bean，其功能与 @Component 相同。
@Controller("userController")
public class UserController {
    @Resource
    private UserService userService;
    public UserService getUserService() {
        return userService;
    }
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    public void doStr() {
        userService.out();
        System.out.println("专注于分享优质编程教程。");
    }
}
