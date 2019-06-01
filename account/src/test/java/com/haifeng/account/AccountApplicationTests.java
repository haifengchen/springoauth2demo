package com.haifeng.account;

import com.haifeng.account.controller.AccountController;
import com.haifeng.account.model.RolesEnum;
import com.haifeng.account.model.User;
import com.haifeng.account.service.UserService;
import com.haifeng.account.service.vo.UserVO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountApplicationTests {

    @Test
    public void contextLoads() {
    }
    @Autowired
    private UserService userService;

    @Test
    @Transactional
    public void testAddUser1(){
        UserVO userVO = new UserVO();
        userVO.setName("user_1");
        userVO.setPassword("123456");
        userVO.setLogin("user_1");
//        userVO.setRoles(Arrays.asList(RolesEnum.USER));
        userVO.setRole(RolesEnum.USER);
        UserVO save = userService.addUser(userVO);

        UserVO one = userService.findOne(save.getId());
        Assert.assertEquals(one.getLogin(), "user_1");
        Assert.assertEquals(one.getName(), "user_1");
        Assert.assertTrue(one.getRole().equals(RolesEnum.USER));

    }
    @Autowired
    private AccountController accountController;

    @Test
    @Transactional
    public void testAddUser2(){
        UserVO userVO = new UserVO();
        userVO.setName("user_2");
        userVO.setPassword("123456");
        userVO.setLogin("user_2");
        userVO.setRole(RolesEnum.USER);
        final UserVO save = accountController.add(userVO);
        UserVO one = userService.findOne(save.getId());
        Assert.assertEquals(one.getLogin(), "user_2");
        Assert.assertEquals(one.getName(), "user_2");
    }

}
