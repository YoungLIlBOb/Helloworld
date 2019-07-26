package com.czxy.score.controller;

import com.czxy.score.domain.User;
import com.czxy.score.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/add")
    public ResponseEntity<String> add(){
        System.out.println("... 执行add方法");
        return new ResponseEntity<>("add..OK",HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<String> update(){
        System.out.println("... 执行update方法");
        return new ResponseEntity<>("update..OK",HttpStatus.OK);
    }

    @PostMapping("/del")
    public ResponseEntity<String> del(){
        System.out.println("... 执行del方法");
        return new ResponseEntity<>("del..OK",HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<Boolean> login(User user, HttpServletRequest request){
        User login = userService.login(user);
        if(login==null){
            return ResponseEntity.ok(false);
        }else{
            request.getSession().setAttribute("login",login);
            return ResponseEntity.ok(true);
        }
    }
}
