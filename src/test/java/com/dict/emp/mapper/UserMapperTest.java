package com.dict.emp.mapper;

import com.dict.emp.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void selectUserList() {
        List<User> users = userMapper.selectUserList();
        System.out.println(users);
    }

    @Test
    void selectById() {
        User user = userMapper.selectById(1L);
        System.out.println(user);
    }

    @Test
    void insert() {
        User user = new User();
        user.setUserName("zhangsan");
        user.setUserPassword("123456");
        user.setUserNickname("dashan");
        user.setUserGender((byte)1);
        user.setUserBirth(new Date());
        user.setUserState((byte)1);
        userMapper.insert(user);
    }

    @Test
    void batchInsert() {
        List<User> list = new ArrayList<>();
        for (int i=1; i<=20; i++){
            User user = new User();
            user.setUserName("user" + i);
            user.setUserPassword("123456");
            user.setUserNickname("用户" + i);
            user.setUserGender((byte)(i%2));
            user.setUserBirth(new Date());
            user.setUserState((byte)1);
            list.add(user);
        }
        System.out.println(list);
        userMapper.batchInsert(list);
        for (User user: list){
            System.out.println(user.getUserId());
        }
    }

    @Test
    void update() {
        User user = new User();
        user.setUserId(1L);
        user.setUserPassword("123456");
        user.setUserNickname("han");
        user.setUserBirth(new Date());
        user.setUserState((byte)0);
        userMapper.update(user);
    }

    @Test
    void batchUpdate() {
    }

    @Test
    void delete() {
        userMapper.deleteById(3L);
    }

    @Test
    void batchDelete() {
        userMapper.batchDelete(Arrays.asList(4L,5L,6L));
    }
}