package com.haifeng.account.service.impl;

import com.haifeng.account.model.RolesEnum;
import com.haifeng.account.model.User;
import com.haifeng.account.repository.UserRepository;
import com.haifeng.account.service.UserService;
import com.haifeng.account.service.vo.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserVO> findAll() {
        List<User> all = userRepository.findAll();
        return getVOS(all);
    }

    @Override
    public UserVO addUser(UserVO userVO) {
        User user = userRepository.findByLogin(userVO.getLogin());
        if(user!=null){
            throw new RuntimeException("Can not register repeatly");
        }
        User one = new User();
        BeanUtils.copyProperties(userVO, one);
        one.setRoles(new HashSet<>(userVO.getRoles()));
        one.setPassword(passwordEncoder.encode(one.getPassword()));
        User save = userRepository.save(one);

        return getVO(save);
    }

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public UserVO findOne(String id) {
        Optional<User> userOptional = userRepository.findById(id);
        return getVO(userOptional.orElse(null));
    }

    private List<UserVO> getVOS(List<User> users){
        List<UserVO> collect = users.stream().map(user -> {
            UserVO userVO = new UserVO();
            BeanUtils.copyProperties(user, userVO,"password");
            userVO.setRoles(new ArrayList<>(user.getRoles()));
            return userVO;
        }).collect(Collectors.toList());
        return collect;
    }

    private UserVO getVO(User user){
        if(user == null) return null;
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(user, userVO,"password");
        userVO.setRoles(new ArrayList<>(user.getRoles()));
        return userVO;
    }
}
