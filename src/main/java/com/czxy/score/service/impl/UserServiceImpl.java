package com.czxy.score.service.impl;

import com.czxy.score.dao.UserMapper;
import com.czxy.score.domain.User;
import com.czxy.score.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User login(User user) {
        List<User> login = userMapper.login(user);
        if(login.isEmpty()){
            return null;
        }else {
            return login.get(0);
        }
    }
}
