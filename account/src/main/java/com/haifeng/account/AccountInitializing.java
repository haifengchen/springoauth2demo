package com.haifeng.account;

import com.haifeng.account.model.RolesEnum;
import com.haifeng.account.repository.UserRepository;
import com.haifeng.account.service.UserService;
import com.haifeng.account.service.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Slf4j
public class AccountInitializing implements InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        initAdmins();
//        addTwoUser();
    }

    @Autowired
    private UserService userService;

    private void initAdmins(){
        try{

        UserVO userVO = new UserVO();
        userVO.setName("admin");
        userVO.setPassword("haifeng");
        userVO.setLogin("admin");
        userVO.setRole(RolesEnum.ADMIN);
        userService.addUser(userVO);
        }catch (RuntimeException e){
            if(!e.getMessage().equals("Can not register repeatly")){
                throw e;
            }else {
                log.debug("already init, ignore this runtime exception");
            }
        }
    }

    /**
     *  In real project  remove this.
     *  in service to add real user to register
     */
    private void addTwoUser(){
        try{
            UserVO userVO = new UserVO();
            userVO.setName("user_1");
            userVO.setPassword("123456");
            userVO.setLogin("user_1");
            userVO.setRole(RolesEnum.USER);
            UserVO save = userService.addUser(userVO);


        }catch (RuntimeException e){
            if(!e.getMessage().equals("Can not register repeatly")){
                throw e;
            }else {
                log.debug("already init, ignore this runtime exception");
            }
        }
        /*try{
            UserVO userVO = new UserVO();
            userVO.setName("user_2");
            userVO.setPassword("123456");
            userVO.setLogin("user_2");
            userVO.setRoles(Arrays.asList(RolesEnum.USER));
            userService.addUser(userVO);


        }catch (RuntimeException e){
            if(!e.getMessage().equals("Can not register repeatly")){
                throw e;
            }else {
                log.debug("already init, ignore this runtime exception");
            }
        }*/

    }
}
