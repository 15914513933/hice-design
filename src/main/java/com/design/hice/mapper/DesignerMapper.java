package com.design.hice.mapper;

import com.design.hice.entity.Designer;
import com.design.hice.param.DesignerQueryParam;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

/**
 * @Description
 * @Author ckj
 * @Date 2022/7/27 8:45 AM
 **/
public interface DesignerMapper extends BaseMapper<Designer> {

    List<Designer> selectByParam(@Param("designerParam") DesignerQueryParam designerParam);


}
