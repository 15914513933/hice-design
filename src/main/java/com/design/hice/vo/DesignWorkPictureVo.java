package com.design.hice.vo;

import lombok.Data;

import javax.persistence.Id;

/**
 * @Description
 * @Author ckj
 * @Date 2022/7/30 1:09 PM
 **/
@Data
public class DesignWorkPictureVo {
    private Long id;
    private Long designWorkId;
    private String description;
    private String pictureUrl;
}
