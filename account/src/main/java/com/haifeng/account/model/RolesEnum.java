package com.haifeng.account.model;

public enum RolesEnum {
    USER("USER"),   //普通用户
    SUPERADMIN("SUPERADMIN"),//系统管理员
    ADMIN("ADMIN") ; //管理员

    private final String name;
    RolesEnum(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
}
