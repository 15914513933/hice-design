package com.design.hice.controller;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.design.hice.common.ResultBody;
import com.design.hice.vo.UserInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author ckj
 * @Date 2022/7/14 3:38 PM
 **/
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private ApplicationContext applicationContext;

    @PostMapping("save")
    @Transactional
    public int saveUser(){
        String sql = "insert into t_user (id,name) values (?,?)";
        int result = jdbcTemplate.update(sql, 3, "33ice");
        throw new RuntimeException("1");

        //return 1;
    }

    @GetMapping("/getUser")
    public ResultBody<UserInfoVo> getUser() {
        //SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
        UserInfoVo userInfoVo = new UserInfoVo();
        userInfoVo.setName("康杰");
        return ResultBody.ok(userInfoVo);
    }
}
