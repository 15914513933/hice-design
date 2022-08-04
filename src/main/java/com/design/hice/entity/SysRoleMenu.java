package com.design.hice.entity;

import lombok.Data;

import javax.persistence.Id;

/**
 * @Description
 * @Author ckj
 * @Date 2022/8/3 3:15 PM
 **/
@Data
public class SysRoleMenu {
    @Id
    private Long id;
    private Long menuId;
    private Long roleId;
}
