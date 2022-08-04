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
public class DesignWorkCategory {
    @Id
    private Long id;
    private String name;
    private String code;
    private Integer sort;
    private Date createDate;
    private Long createBy;
}
