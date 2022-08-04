package com.design.hice.vo;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @Description
 * @Author ckj
 * @Date 2022/7/28 5:42 PM
 **/
@Data
public class DesignWebsiteVo {
    private Long id;
    private String name;
    private Long designerId;
    private String designerName;
    private String logo;
    private String url;
    private String indexBg;
    private String workBg;
    private String aboutBg;
    private String contactBg;
    private Date lastPublishDate;
    private Date createDate;
    private Long createBy;
    private Date updateDate;
}
