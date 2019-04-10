package com.haifeng.account.service.vo;

import com.haifeng.account.model.RolesEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = false)
public class UserVO extends BaseEntityVO{
    private String name;
    private String login;
    private String password;
    private List<RolesEnum> roles;

}
