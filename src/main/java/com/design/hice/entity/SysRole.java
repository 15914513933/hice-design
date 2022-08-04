package com.design.hice.entity;

import lombok.Data;

import javax.persistence.Id;

/**
 * @Description
 * @Author ckj
 * @Date 2022/8/3 3:14 PM
 **/
@Data
public class SysRole {
    @Id
    private Long id;
    private String role;
}
