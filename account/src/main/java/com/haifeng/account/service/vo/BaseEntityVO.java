package com.haifeng.account.service.vo;

import lombok.Data;

import java.util.Date;

@Data
public class BaseEntityVO {
    private String id;
    private Date createTime;
    private String createBy;

    private Date updateTime;
    private String updateBy;
}
