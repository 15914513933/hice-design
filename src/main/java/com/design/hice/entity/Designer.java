package com.design.hice.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import javax.persistence.Id;
import java.util.Date;

/**
 * @Description
 * @Author ckj
 * @Date 2022/7/27 9:03 AM
 **/
@Data
public class Designer {
    @Id
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    private Long userId;
    private String name;
    private Integer sex;
    private String phone;
    private String email;
    private String logo;
    private String cover;
    private String introduction;
    private String qq;
    private Date createDate;
    private Date updateDate;
}
