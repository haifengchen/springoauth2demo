package com.haifeng.account.controller;

import com.haifeng.account.service.UserService;
import com.haifeng.account.service.vo.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {
    @RequestMapping("")
    public String hello(){
        return "hello";
    };
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<UserVO> getAll(){
        List<UserVO> all = userService.findAll();
        return all;
    }
    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public UserVO  add(@RequestBody UserVO request){
        final UserVO userVO = new UserVO();
        BeanUtils.copyProperties(request, userVO);
        final UserVO result = userService.addUser(userVO);
        return result;
    }
}
