package com.wwt.spring.demo.dao.Impl;

import com.wwt.spring.demo.dao.UserDao;
import org.springframework.stereotype.Repository;

/*
@Component 注解用于描述 Spring 中的 Bean，它是一个泛化的概念，仅仅表示容器中的一个组件（Bean），并且可以作用在应用的任何层次，例如 Service 层、Dao 层等。
使用时只需将该注解标注在相应类上即可。
 */
//@Repository 注解用于将数据访问层（Dao 层）的类标识为 Spring 中的 Bean，其功能与 @Component 相同。
@Repository("userDao")
public class UserDaoImpl implements UserDao{
    @Override
    public void print() {
        System.out.println("C语言中文网");
    }
}
