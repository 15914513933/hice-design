package com.design.hice.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.design.hice.common.ResultBody;
import com.design.hice.entity.DesignWork;
import com.design.hice.entity.DesignWorkCategory;
import com.design.hice.entity.DesignWorkPicture;
import com.design.hice.entity.Designer;
import com.design.hice.mapper.DesignWorkCategoryMapper;
import com.design.hice.mapper.DesignWorkMapper;
import com.design.hice.mapper.DesignWorkPictureMapper;
import com.design.hice.mapper.DesignerMapper;
import com.design.hice.param.DesignWorkCategoryQueryParam;
import com.design.hice.param.DesignWorkQueryParam;
import com.design.hice.service.UserService;
import com.design.hice.vo.DesignWorkPictureVo;
import com.design.hice.vo.DesignWorkVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @Description
 * @Author ckj
 * @Date 2022/7/26 5:54 PM
 **/
@RestController
@RequestMapping("/designWork")
public class DesignWorkController {

    @Autowired
    private DesignWorkMapper designWorkMapper;
    @Autowired
    private DesignWorkPictureMapper designWorkPictureMapper;
    @Autowired
    private DesignerMapper designerMapper;
    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public ResultBody<PageInfo<DesignWorkVo>> getDesignWorkCategoryList(DesignWorkQueryParam designWorkQueryParam) {
        PageHelper.startPage(designWorkQueryParam.getPageNum(), designWorkQueryParam.getPageSize());
        PageInfo<DesignWorkVo> pageInfo = new PageInfo<>(designWorkMapper.queryDesignWork(designWorkQueryParam));
        return ResultBody.ok(pageInfo);
    }

    @GetMapping("/listMy")
    public ResultBody<PageInfo<DesignWorkVo>> getMyDesignWorkCategoryList(DesignWorkQueryParam designWorkQueryParam) {
        Long userId = Long.parseLong((String) StpUtil.getLoginId());
        Long designerId = userService.getDesignerIdByUser(userId);
        designWorkQueryParam.setDesignerId(designerId);
        PageHelper.startPage(designWorkQueryParam.getPageNum(), designWorkQueryParam.getPageSize());
        PageInfo<DesignWorkVo> pageInfo = new PageInfo<>(designWorkMapper.queryDesignWork(designWorkQueryParam));
        return ResultBody.ok(pageInfo);
    }

    @PostMapping("/save")
    public ResultBody<Void> saveDesignWork(@RequestBody DesignWork designWorkVo) {
        DesignWork designWork = null;
        Date now = new Date();
        Long userId = userService.getCurrentUserId();
        boolean isAdmin = userService.isAdmin(userId);
        if(!isAdmin){
            Long designerId = userService.getDesignerIdByUser(userId);
            designWorkVo.setDesignerId(designerId);
        }
        if (designWorkVo.getId() != null) {
            designWork = designWorkMapper.selectByPrimaryKey(designWorkVo.getId());
            BeanUtil.copyProperties(designWorkVo, designWork, CopyOptions.create().setIgnoreNullValue(true));
            designWork.setUpdateDate(now);
            designWorkMapper.updateByPrimaryKey(designWork);
        } else {
            designWork = new DesignWork();
            BeanUtil.copyProperties(designWorkVo, designWork);
            designWork.setCreateDate(now);
            designWork.setUpdateDate(now);
            designWorkMapper.insert(designWork);
        }
        return ResultBody.ok();
    }

    @PostMapping("/delete")
    public ResultBody<Void> deleteDesignWork(@RequestParam("id") Long id) {
        DesignWork designWork = designWorkMapper.selectByPrimaryKey(id);
        if (designWork == null) {
            return ResultBody.fail("数据不存在");
        }
        designWorkMapper.delete(designWork);
        return ResultBody.ok();
    }

    @PostMapping("/savePicture")
    @Transactional
    public ResultBody<Void> saveDesignWorkPicture(@RequestBody DesignWorkVo designWorkVo) {
        DesignWork designWork = designWorkMapper.selectByPrimaryKey(designWorkVo.getId());
        if (designWork == null) {
            return ResultBody.fail("数据不存在");
        }
        List<DesignWorkPictureVo> designWorkPictures = designWorkVo.getDesignWorkPictures();
        Date now = new Date();
        for (DesignWorkPictureVo designWorkPictureVo : designWorkPictures) {
            designWorkPictureVo.setDesignWorkId(designWorkVo.getId());
            DesignWorkPicture designWorkPicture = new DesignWorkPicture();
            BeanUtil.copyProperties(designWorkPictureVo, designWorkPicture);

            if (designWorkPicture.getId() != null) {
                designWorkPicture.setUpdateDate(now);
                designWorkPictureMapper.updateByPrimaryKey(designWorkPicture);
            } else {
                designWorkPicture.setCreateDate(now);
                designWorkPictureMapper.insert(designWorkPicture);
            }
        }
        designWork.setUpdateDate(now);
        designWorkMapper.updateByPrimaryKey(designWork);
        return ResultBody.ok();
    }

    @GetMapping("/getPicture")
    public ResultBody<List<DesignWorkPicture>> getPicture(@RequestParam("id") Long id) {
        DesignWork designWork = designWorkMapper.selectByPrimaryKey(id);
        if (designWork == null) {
            return ResultBody.fail("数据不存在");
        }
        DesignWorkPicture designWorkPicture = new DesignWorkPicture();
        designWorkPicture.setDesignWorkId(id);
        return ResultBody.ok(designWorkPictureMapper.select(designWorkPicture));
    }

    @PostMapping("/deletePicture")
    public ResultBody<Void> deletePicture(@RequestParam("id") Long id) {
        DesignWorkPicture designWorkPicture = designWorkPictureMapper.selectByPrimaryKey(id);
        if (designWorkPicture == null) {
            return ResultBody.fail("图片不存在");
        }
        designWorkPictureMapper.delete(designWorkPicture);
        return ResultBody.ok();
    }

}
