package com.design.hice.param;

import lombok.Data;

/**
 * @Description
 * @Author ckj
 * @Date 2022/7/27 10:10 AM
 **/
@Data
public class DesignWebsiteQueryParam extends BasePageParam{
    private String designerName;
    private Long designerId;

}
