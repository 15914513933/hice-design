package com.design.hice.entity;

import lombok.Data;

import javax.persistence.Id;
import java.util.Date;

/**
 * @Description
 * @Author ckj
 * @Date 2022/7/29 10:37 AM
 **/
@Data
public class FileUpload {
    @Id
    private Long id;
    private Long uploadId;
    private String originalName;
    private String targetName;
    private Long size;
    private String path;
    private Long createBy;
    private Date createDate;
}
