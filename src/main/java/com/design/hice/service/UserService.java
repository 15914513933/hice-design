package com.design.hice.service;

import cn.dev33.satoken.stp.StpUtil;
import com.design.hice.entity.Designer;
import com.design.hice.entity.SysUserRole;
import com.design.hice.mapper.DesignerMapper;
import com.design.hice.mapper.SysUserRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author ckj
 * @Date 2022/8/3 3:46 PM
 **/
@Service
public class UserService {
    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;
    @Autowired
    private DesignerMapper designerMapper;
    public boolean isAdmin(Long userId){
        boolean isAdmin = false;
        List<SysUserRole> roles = sysUserRoleMapper.getRoles(userId);
        for (SysUserRole role : roles) {
            if(role.getRoleId()==1){
                isAdmin = true;
                break;
            }
        }
        return isAdmin;
    }

    public Long getCurrentUserId(){
        return Long.parseLong((String) StpUtil.getLoginId());
    }

    public Long getDesignerIdByUser(Long userId){
        Long designerId = 0L;
        Designer designer = new Designer();
        designer.setUserId(userId);
        designer = designerMapper.selectOne(designer);
        if (designer != null && designer.getUserId() != null) {
            designerId = designer.getId();
        }
        return designerId;
    }
}
