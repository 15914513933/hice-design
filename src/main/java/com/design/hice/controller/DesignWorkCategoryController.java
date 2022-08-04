package com.design.hice.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.design.hice.common.ResultBody;
import com.design.hice.entity.DesignWorkCategory;
import com.design.hice.mapper.DesignWorkCategoryMapper;
import com.design.hice.param.DesignWorkCategoryQueryParam;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description
 * @Author ckj
 * @Date 2022/7/26 5:54 PM
 **/
@RestController
@RequestMapping("/designWorkCategory")
public class DesignWorkCategoryController {

    @Autowired
    private DesignWorkCategoryMapper designWorkCategoryMapper;

    @GetMapping("/list")
    public ResultBody<PageInfo<DesignWorkCategory>> getDesignWorkCategoryList(DesignWorkCategoryQueryParam designWorkCategoryParam) {
        PageHelper.startPage(designWorkCategoryParam.getPageNum(), designWorkCategoryParam.getPageSize());
        PageInfo<DesignWorkCategory> pageInfo = new PageInfo<>(designWorkCategoryMapper.selectAll());
        return ResultBody.ok(pageInfo);
    }

    @PostMapping("/save")
    public ResultBody<Void> saveDesignWorkCategory(@RequestBody DesignWorkCategory designWorkCategoryVo) {
        DesignWorkCategory designWorkCategory = null;
        if (designWorkCategoryVo.getId() != null) {
            designWorkCategory = designWorkCategoryMapper.selectByPrimaryKey(designWorkCategoryVo.getId());
            BeanUtil.copyProperties(designWorkCategoryVo, designWorkCategory, CopyOptions.create().setIgnoreNullValue(true));
            designWorkCategoryMapper.updateByPrimaryKey(designWorkCategory);
        } else {
            designWorkCategory = new DesignWorkCategory();
            BeanUtil.copyProperties(designWorkCategoryVo, designWorkCategory);
            designWorkCategoryMapper.insert(designWorkCategory);
        }
        return ResultBody.ok();
    }

    @PostMapping("/delete")
    public ResultBody<Void> deleteDesignWorkCategory(@RequestParam("id") Long id) {
        DesignWorkCategory designWorkCategory = designWorkCategoryMapper.selectByPrimaryKey(id);
        if (designWorkCategory == null) {
            return ResultBody.fail("数据不存在");
        }
        designWorkCategoryMapper.delete(designWorkCategory);
        return ResultBody.ok();
    }

}
