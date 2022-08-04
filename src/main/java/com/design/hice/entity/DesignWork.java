package com.design.hice.entity;

import lombok.Data;

import javax.persistence.Id;
import java.util.Date;

/**
 * @Description
 * @Author ckj
 * @Date 2022/7/28 10:49 AM
 **/
@Data
public class DesignWork {
    @Id
    private Long id;
    private String theme;
    private Long designerId;
    private Long categoryId;
    private String label;
    private Integer sort;
    private String cover;
    private String description;
    private Integer status;
    private Integer recommend;
    private Date createDate;
    private Long createBy;
    private Date updateDate;
}
