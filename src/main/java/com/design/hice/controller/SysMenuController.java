package com.design.hice.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.design.hice.entity.SysMenu;
import com.design.hice.entity.SysUserRole;
import com.design.hice.mapper.SysMenuMapper;
import com.design.hice.mapper.SysUserRoleMapper;
import com.design.hice.service.UserService;
import com.design.hice.util.TreeUtil;
import com.design.hice.vo.MenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author ckj
 * @Date 2022/8/3 2:06 PM
 **/
@RestController
@RequestMapping("/sysMenu")
public class SysMenuController {
    @Autowired
    private SysMenuMapper sysMenuMapper;
    @Autowired
    private UserService userService;
    @GetMapping("/menu")
    public Map<String, Object> menu() {
        Map<String, Object> map = new HashMap<>(16);
        Map<String,Object> home = new HashMap<>(16);
        Map<String,Object> logo = new HashMap<>(16);
        Long userId = userService.getCurrentUserId();
        boolean isAdmin = userService.isAdmin(userId);
        List<SysMenu> menuList;
        if(isAdmin){
            menuList = sysMenuMapper.getSysMenuByStatusAndSort(1);
        }else{
            menuList = sysMenuMapper.getSysMenuByUser(userId);
        }
        List<MenuVo> menuInfo = new ArrayList<>();
        for (SysMenu e : menuList) {
            MenuVo menuVO = new MenuVo();
            menuVO.setId(e.getId());
            menuVO.setPid(e.getPid());
            menuVO.setHref(e.getHref());
            menuVO.setTitle(e.getTitle());
            menuVO.setIcon(e.getIcon());
            menuVO.setTarget(e.getTarget());
            menuInfo.add(menuVO);
        }
        map.put("menuInfo", TreeUtil.toTree(menuInfo, 0L));
        home.put("title","首页");
        home.put("href","page/welcome-1.html?t=1");
        logo.put("title","ADMIN");
        logo.put("image","images/logo.png");
        map.put("homeInfo", home);
        map.put("logoInfo", logo);
        return map;
    }

}
