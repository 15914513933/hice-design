package com.design.hice.entity;

import lombok.Data;

import javax.persistence.Id;
import java.util.Date;

/**
 * @Description
 * @Author ckj
 * @Date 2022/8/3 2:11 PM
 **/
@Data
public class SysMenu {
    @Id
    private Long id;
    private String title;
    private String href;
    private Long pid;
    private String icon;
    private String target;
    private Integer sort;
    private Boolean status;
    private String remark;
    private Date createDate;
    private Date updateDate;
    private Date deleteDate;
}
