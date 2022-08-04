package com.design.hice.param;

/**
 * 分页参数基类
 */
public class BasePageParam {

    private Integer pageNum = 1;

    private Integer pageSize = 10;


    /**
     * 页码
     *
     * @return
     */
    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    /**
     * 每页行数
     * @return
     */
    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

}
