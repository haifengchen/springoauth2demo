package com.haifeng.account.service;

import com.haifeng.account.model.RolesEnum;
import com.haifeng.account.service.vo.UserVO;

import java.util.List;

public interface UserService {
    List<UserVO> findAll();
    UserVO addUser(UserVO userVO);
    UserVO findOne(String id);
}
