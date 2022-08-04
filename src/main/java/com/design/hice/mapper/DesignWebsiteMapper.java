package com.design.hice.mapper;

import com.design.hice.entity.DesignWebsite;
import com.design.hice.entity.DesignWork;
import com.design.hice.param.DesignWebsiteQueryParam;
import com.design.hice.param.DesignWorkQueryParam;
import com.design.hice.vo.DesignWebsiteVo;
import com.design.hice.vo.DesignWorkVo;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

/**
 * @Description
 * @Author ckj
 * @Date 2022/7/27 8:45 AM
 **/
public interface DesignWebsiteMapper extends BaseMapper<DesignWebsite> {

    List<DesignWebsiteVo> queryDesignWebsite(@Param("designWebsiteQueryParam") DesignWebsiteQueryParam designWebsiteQueryParam);


}
