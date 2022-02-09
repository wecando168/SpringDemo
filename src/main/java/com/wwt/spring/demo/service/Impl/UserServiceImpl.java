package com.wwt.spring.demo.service.Impl;

import com.wwt.spring.demo.dao.UserDao;
import com.wwt.spring.demo.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

//@Service 注解通常作用在业务层（Service 层），用于将业务层的类标识为 Spring 中的 Bean，其功能与 @Component 相同。
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void out() {
        userDao.print();
        System.out.println("一个精美而实用的网站");
    }
}
