package com.design.hice.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import com.design.hice.annotation.NoLogin;
import com.design.hice.common.ResultBody;
import com.design.hice.common.VerifyCode;
import com.design.hice.mapper.DesignerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @Author ckj
 * @Date 2022/7/1 11:27 AM
 **/
@RestController
public class LoginController {
    @Autowired
    private RedisTemplate redisTemplate;

    private static Snowflake snowflake = IdUtil.getSnowflake();

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostMapping("/doLogin")
    @NoLogin
    public ResultBody<String> Login(@RequestParam("userId") String userId, @RequestParam("password") String password
            , @RequestParam("verifyId") String verifyId, @RequestParam("verifyCode") String verifyCode) {
        Object value = redisTemplate.opsForValue().get("verify_img_" + verifyId);
        /*if (value == null || !value.equals(verifyCode)) {
            return ResultBody.fail("验证码错误");
        }*/
        //String sql = "select * from user (user_id,password) values (?,?)";
        /*if ("chen".equals(userId) && "123456".equals(password)) {
            StpUtil.login(userId);
            return ResultBody.ok(StpUtil.getTokenInfo().getTokenValue());
        }
        return ResultBody.fail("账号密码错误");*/
        StpUtil.login(userId);
        return ResultBody.ok(StpUtil.getTokenInfo().getTokenValue());
    }

    @GetMapping("/logout")
    public String logout() {
        StpUtil.logout();
        return "登出";
    }

    @GetMapping("/login/getVerifyId")
    @NoLogin
    public ResultBody<String> getVerifyId() {
        long key = snowflake.nextId();
        long value = snowflake.nextId();
        redisTemplate.boundValueOps("verify_" + key).set(value, 30, TimeUnit.SECONDS);
        return ResultBody.ok(String.valueOf(key));
    }

    @GetMapping("/login/getVerifyImg/{verifyId}")
    @NoLogin
    public void getVerifyImg(@PathVariable("verifyId") String verifyId, HttpServletResponse response) {
        Object value = redisTemplate.opsForValue().get("verify_" + verifyId);
        if (value == null) {
            throw new IllegalArgumentException("请重新获取验证码");
        }
        VerifyCode verifyCode = new VerifyCode();
        String text = verifyCode.getText();
        BufferedImage image = verifyCode.getImage();
        redisTemplate.delete("verify_" + verifyId);
        redisTemplate.boundValueOps("verify_img_" + verifyId).set(text, 30, TimeUnit.SECONDS);
        // 转换流信息写出
        try {
            ServletOutputStream os = response.getOutputStream();
            response.setContentType(MediaType.IMAGE_JPEG_VALUE);
            ImageIO.write(image, "jpeg", os);
        } catch (IOException e) {
            throw new IllegalArgumentException("获取验证码失败");
        }
    }
}
