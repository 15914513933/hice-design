package com.design.hice.param;

import lombok.Data;

/**
 * @Description
 * @Author ckj
 * @Date 2022/7/27 10:10 AM
 **/
@Data
public class DesignWorkQueryParam extends BasePageParam{
    private String designerName;
    private Integer categoryId;
    private Long designerId;
    private Integer recommend;
}
