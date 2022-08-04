package com.design.hice.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import com.design.hice.common.ResultBody;
import com.design.hice.entity.DesignWebsite;
import com.design.hice.entity.DesignWorkCategory;
import com.design.hice.entity.DesignWorkPicture;
import com.design.hice.entity.Designer;
import com.design.hice.mapper.*;
import com.design.hice.param.DesignWorkQueryParam;
import com.design.hice.param.DesignerQueryParam;
import com.design.hice.util.FreeMarkerUtil;
import com.design.hice.vo.DesignWorkVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @Description
 * @Author ckj
 * @Date 2022/7/26 5:54 PM
 **/
@RestController
public class DesignerController {

    @Autowired
    private DesignerMapper designerMapper;
    @Autowired
    private DesignWorkCategoryMapper designWorkCategoryMapper;
    @Autowired
    private DesignWorkMapper designWorkMapper;
    @Autowired
    private DesignWorkPictureMapper designWorkPictureMapper;
    @Autowired
    private DesignWebsiteMapper designWebsiteMapper;
    private static final Snowflake snowflake = IdUtil.getSnowflake(1);

    @GetMapping("/designer/list")
    public ResultBody<PageInfo<Designer>> getDesignerList(DesignerQueryParam designerParam) {
        PageHelper.startPage(designerParam.getPageNum(), designerParam.getPageSize());//开始分页
        List<Designer> designers = designerMapper.selectByParam(designerParam);
        PageInfo<Designer> pageInfo = new PageInfo<>(designers);
        return ResultBody.ok(pageInfo);
    }

    @PostMapping("/designer/save")
    public ResultBody<Void> saveDesigner(@RequestBody Designer designerVo) {
        Designer designer = null;
        if (designerVo.getId() != null) {
            designer = designerMapper.selectByPrimaryKey(designerVo.getId());
            BeanUtil.copyProperties(designerVo, designer, CopyOptions.create().setIgnoreNullValue(true));
            designerMapper.updateByPrimaryKey(designer);
        } else {
            Long id = snowflake.nextId();
            designer = new Designer();
            BeanUtil.copyProperties(designerVo, designer);
            designer.setId(id);
            designerMapper.insert(designer);

            DesignWebsite designWebsite = new DesignWebsite();
            designWebsite.setDesignerId(id);
            designWebsite.setName(designer.getName() + "的网站");
            designWebsiteMapper.insert(designWebsite);
        }
        return ResultBody.ok();
    }

    @Transactional
    @PostMapping("/designer/delete")
    public ResultBody<Void> deleteDesigner(@RequestParam("id") Long id) {
        Designer designer = designerMapper.selectByPrimaryKey(id);
        if (designer == null) {
            return ResultBody.fail("数据不存在");
        }
        designerMapper.delete(designer);
        DesignWebsite designWebsite = new DesignWebsite();
        designWebsite.setDesignerId(designer.getId());
        designWebsite = designWebsiteMapper.selectOne(designWebsite);
        if (designWebsite != null) {
            designWebsiteMapper.delete(designWebsite);
        }
        return ResultBody.ok();
    }

}
