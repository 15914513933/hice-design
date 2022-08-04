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
public class DesignWorkVo {
    private Long id;
    private String theme;
    private Long designerId;
    private String designerName;
    private Long categoryId;
    private String categoryName;
    private String categoryCode;
    private String label;
    private Integer sort;
    private String cover;
    private String description;
    private int status;
    private int recommend;
    private Date createDate;
    private Long createBy;
    private Date updateDate;

    private List<DesignWorkPictureVo> designWorkPictures;

}
