package com.design.hice.mapper;

import com.design.hice.entity.SysMenu;
import com.design.hice.entity.SysUserRole;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

/**
 * @Description
 * @Author ckj
 * @Date 2022/7/27 8:45 AM
 **/
public interface SysUserRoleMapper extends BaseMapper<SysUserRole> {

    @Select("select * from sys_user_role where user_id=#{userId}")
    List<SysUserRole> getRoles(@Param("userId") Long userId);

}
