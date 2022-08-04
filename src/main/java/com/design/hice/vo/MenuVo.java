package com.design.hice.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

/**
 * @Description
 * @Author ckj
 * @Date 2022/8/3 2:11 PM
 **/
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MenuVo {
    private Long id;

    private Long pid;

    private String title;

    private String icon;

    private String href;

    private String target;

    private List<MenuVo> child;
}