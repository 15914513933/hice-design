package com.design.hice.controller;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import com.design.hice.common.ResultBody;
import com.design.hice.entity.FileUpload;
import com.design.hice.mapper.FileUploadMapper;
import com.design.hice.vo.ImgUploadVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Description
 * @Author ckj
 * @Date 2022/7/28 8:13 AM
 **/
@RestController
public class UploadController {
    private static final int DEFAULT_IMG_SIZE = 10 * 1024 * 1024;
    private static final int LOGO_IMG_SIZE = 10 * 1024 * 1024;


    private static final Map<String, Integer> IMG_SIZE_MAP = new HashMap<>();
    private static final Set<String> IMG_TYPE_SET = new HashSet<>();
    private static final Snowflake snowflake = IdUtil.getSnowflake();

    @Value("${static.path}")
    private String staticPath;

    @Autowired
    private FileUploadMapper fileUploadMapper;

    static {
        IMG_SIZE_MAP.put("logo", LOGO_IMG_SIZE);

        IMG_TYPE_SET.add("image/jpg");
        IMG_TYPE_SET.add("image/png");
        IMG_TYPE_SET.add("image/jpeg");
        IMG_TYPE_SET.add("image/gif");
    }


    @PostMapping("/upload/img")
    public ResultBody<ImgUploadVo> uploadImg(@RequestParam("file") MultipartFile file, @RequestParam("module") String module) {
        if (file.isEmpty()) {
            return ResultBody.fail("图片文件不能为空");
        }
        int maxSize = IMG_SIZE_MAP.containsKey(module) ? IMG_SIZE_MAP.get(module) : DEFAULT_IMG_SIZE;
        if (file.getSize() > maxSize) {
            return ResultBody.fail("图片不能大于" + maxSize / 1024 + "KB");
        }
        String contentType = file.getContentType();
        if (!IMG_TYPE_SET.contains(contentType)) {
            return ResultBody.fail("不支持" + contentType.split("/")[1] + "格式");
        }

        File imgDir = new File(staticPath+"/upload/img/" + module);
        if (!imgDir.exists()) {
            imgDir.mkdirs();
        }
        Long uploadId = snowflake.nextId();
        String originalFilename = file.getOriginalFilename();
        int index = originalFilename.lastIndexOf(".");
        String imgSuffix = originalFilename.substring(index + 1, originalFilename.length());
        String targetFileName = uploadId + "." + imgSuffix;

        File targetFile = new File(imgDir, targetFileName);

        try {
            file.transferTo(targetFile);
        } catch (IOException e) {
            e.printStackTrace();
            return ResultBody.fail("上传失败");
        }
        ImgUploadVo imgUploadVo = new ImgUploadVo();
        imgUploadVo.setUploadId(uploadId);
        imgUploadVo.setOriginalFilename(originalFilename);
        imgUploadVo.setTargetFileName(targetFileName);
        imgUploadVo.setTargetFilePath("/" + module + "/" + targetFileName);

        FileUpload fileUpload = new FileUpload();
        fileUpload.setUploadId(uploadId);
        fileUpload.setOriginalName(originalFilename);
        fileUpload.setTargetName(targetFileName);
        fileUpload.setSize(file.getSize());
        fileUpload.setPath(imgUploadVo.getTargetFilePath());
        fileUploadMapper.insert(fileUpload);
        return ResultBody.ok(imgUploadVo);
    }
}
