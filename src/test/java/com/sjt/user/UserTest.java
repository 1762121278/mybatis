package com.sjt.user;

import com.github.pagehelper.PageHelper;
import com.sjt.user.dao.UserMapper;
import com.sjt.user.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class UserTest {
    @Test
    public void test() throws IOException {
/*
        String s = "mapper/mybatis-config.xml";
        InputStream stream = Resources.getResourceAsStream(s);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(stream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = sqlSession.selectOne("UserMapper.selectById");
        System.out.println(user);
        sqlSession.close();*/

        String s = "mapper/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(s);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectById(1);
        PageHelper.startPage(1,2);
        List<User> userList = mapper.selectAll();
        System.out.println(userList);
        System.out.println(user);
        sqlSession.close();
    }

}
