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
import com.design.hice.param.DesignWebsiteQueryParam;
import com.design.hice.param.DesignWorkQueryParam;
import com.design.hice.util.FreeMarkerUtil;
import com.design.hice.vo.DesignWebsiteVo;
import com.design.hice.vo.DesignWorkVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.nio.channels.FileChannel;
import java.util.*;

/**
 * @Description
 * @Author ckj
 * @Date 2022/7/26 5:54 PM
 **/
@RestController
@RequestMapping("/designWebsite")
public class DesignWebsiteController {
    @Value("${static.path}")
    private String staticPath;
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
    @Autowired
    private FreeMarkerUtil freeMarkerUtil;

    @GetMapping("/list")
    public ResultBody<PageInfo<DesignWebsiteVo>> getDesignWebsiteList(DesignWebsiteQueryParam designWebsiteQueryParam) {
        PageHelper.startPage(designWebsiteQueryParam.getPageNum(), designWebsiteQueryParam.getPageSize());//开始分页
        List<DesignWebsiteVo> designWebsiteVos = designWebsiteMapper.queryDesignWebsite(designWebsiteQueryParam);
        PageInfo<DesignWebsiteVo> pageInfo = new PageInfo<>(designWebsiteVos);
        return ResultBody.ok(pageInfo);
    }

    @PostMapping("/save")
    public ResultBody<Void> saveDesigner(@RequestBody DesignWebsiteVo designWebsiteVo) {
        DesignWebsite designWebsite = designWebsiteMapper.selectByPrimaryKey(designWebsiteVo.getId());
        if (designWebsite == null) {
            return ResultBody.fail("数据不存在");
        }
        BeanUtil.copyProperties(designWebsiteVo, designWebsite, CopyOptions.create().setIgnoreNullValue(true));
        designWebsiteMapper.updateByPrimaryKey(designWebsite);
        return ResultBody.ok();
    }

    @PostMapping("/publishWebsite")
    public ResultBody<Void> createWebsite(@RequestParam("id") Long id) {
        DesignWebsite designWebsite = designWebsiteMapper.selectByPrimaryKey(id);
        if (designWebsite == null) {
            return ResultBody.fail("数据不存在");
        }
        //设计师信息
        Designer designer = designerMapper.selectByPrimaryKey(designWebsite.getDesignerId());

        //品类信息
        List<DesignWorkCategory> designWorkCategoryList = designWorkCategoryMapper.selectAll();

        //作品信息
        DesignWorkQueryParam designWorkQueryParam = new DesignWorkQueryParam();
        designWorkQueryParam.setDesignerId(designWebsite.getDesignerId());
        List<DesignWorkVo> designWorks = designWorkMapper.queryDesignWork(designWorkQueryParam);

        int recommendMaxSize = 12;
        List<DesignWorkVo> recommendDesignWorks = new ArrayList<>();
        for (DesignWorkVo designWork : designWorks) {
            if (designWork.getRecommend() == 1) {
                recommendDesignWorks.add(designWork);
            }
        }
        Map<String, Object> map = new HashMap<>();
        map.put("designWebsite", designWebsite);
        map.put("designer", designer);
        map.put("designWorkCategoryList", designWorkCategoryList);
        map.put("designWorks", designWorks);
        map.put("recommendDesignWorks", recommendDesignWorks);

        String templateType = "1";
        String targetPath = "/" + designWebsite.getId();

        try {
            freeMarkerUtil.createHtml(templateType, "index.ftl", targetPath, "index.html", map);
            freeMarkerUtil.createHtml(templateType, "portfolio.ftl", targetPath, "portfolio.html", map);
            freeMarkerUtil.createHtml(templateType, "about.ftl", targetPath, "about.html", map);
            freeMarkerUtil.createHtml(templateType, "contact.ftl", targetPath, "contact.html", map);
            targetPath = targetPath + "/portfolio";
            List<DesignWorkPicture> designWorkPictures = null;
            DesignWorkPicture designWorkPicture = null;

            Date lastPublishDate = designWebsite.getLastPublishDate();
            for (DesignWorkVo designWork : designWorks) {
                /*if (lastPublishDate != null && designWork.getUpdateDate() != null && lastPublishDate.compareTo(designWork.getUpdateDate()) >= 0) {
                    continue;
                }*/
                map.put("designWork", designWork);
                designWorkPicture = new DesignWorkPicture();
                designWorkPicture.setDesignWorkId(designWork.getId());
                designWorkPictures = designWorkPictureMapper.select(designWorkPicture);
                map.put("designWorkPictures", designWorkPictures);
                freeMarkerUtil.createHtml("1", "portfolioDetail.ftl", targetPath, designWork.getId() + ".html", map);
            }
            if (lastPublishDate == null) {
                copyStaticResource(staticPath + "/static", staticPath + "/" + designWebsite.getId());
            }
            if (designWebsite.getId() == 1) {
                copyStaticResource(staticPath + "/" + designWebsite.getId(), staticPath);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultBody.fail("发布网站失败");
        }
        //记录网站发布时间
        designWebsite.setLastPublishDate(new Date());
        designWebsiteMapper.updateByPrimaryKey(designWebsite);
        return ResultBody.ok();
    }

    private void copyStaticResource(String source, String target) throws IOException {
        File sourceDir = new File(source);
        File targetDir = new File(target);
        File[] files = sourceDir.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                FileUtils.copyDirectoryToDirectory(file, targetDir);
            } else {
                FileUtils.copyFileToDirectory(file, targetDir);
            }
        }
    }

}
