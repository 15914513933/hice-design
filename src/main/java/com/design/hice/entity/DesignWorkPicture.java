package com.design.hice.entity;

import lombok.Data;

import javax.persistence.Id;
import java.util.Date;

/**
 * @Description
 * @Author ckj
 * @Date 2022/7/30 1:09 PM
 **/
@Data
public class DesignWorkPicture {
    @Id
    private Long id;
    private Long designWorkId;
    private String description;
    private String pictureUrl;
    private Long createBy;
    private Date createDate;
    private Date updateDate;
}
