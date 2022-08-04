package com.design.hice.mapper;

import com.design.hice.entity.Designer;
import com.design.hice.entity.SysMenu;
import com.design.hice.param.DesignerQueryParam;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

/**
 * @Description
 * @Author ckj
 * @Date 2022/7/27 8:45 AM
 **/
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    @Select("select * from sys_menu where status=#{status} order by sort")
    List<SysMenu> getSysMenuByStatusAndSort(@Param("status") Integer status);

    @Select("select m.* from sys_menu m\n" +
            "join sys_role_menu rm on m.id=rm.menu_id\n" +
            "join sys_user_role ur on ur.role_id = rm.role_id \n" +
            "where ur.user_id = #{userId} ")
    List<SysMenu> getSysMenuByUser(@Param("userId") Long userId);

}
