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
public class DesignWebsite {
    @Id
    private Long id;
    private String name;
    private String url;
    private String logo;
    private Long designerId;
    private String indexBg;
    private String workBg;
    private String aboutBg;
    private String contactBg;
    private Date lastPublishDate;
    private Date createDate;
    private Long createBy;
    private Date updateDate;
}
