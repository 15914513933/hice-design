package com.design.hice.param;

import lombok.Data;

/**
 * @Description
 * @Author ckj
 * @Date 2022/7/27 10:10 AM
 **/
@Data
public class DesignWorkCategoryQueryParam extends BasePageParam{
    private String name;
    private String code;
}
