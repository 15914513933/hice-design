package com.design.hice.vo;

import lombok.Data;

/**
 * @Description
 * @Author ckj
 * @Date 2022/7/28 9:11 AM
 **/
@Data
public class ImgUploadVo {
    private Long uploadId;
    private String originalFilename;
    private String targetFileName;
    private String targetFilePath;
}
