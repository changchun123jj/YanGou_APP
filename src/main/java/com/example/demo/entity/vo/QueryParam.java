package com.example.demo.entity.vo;

import java.io.Serializable;
import java.util.List;

/**
 * 查询对象基类
 *
 * @author liaoc
 */
public class QueryParam implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 查询字段(多个字段用逗号隔开)
     */
    private String selectProperties;
    /**
     * 排序字段(多个字段用逗号隔开)
     */
    private List<SortParam> sortProperties;

    /**
     * 页码
     */
    private int pageIndex = 1;
    /**
     * 每页条数
     */
    private int pageSize = 10;

    /**
     * @return the 查询字段(多个字段用逗号隔开)
     */
    public String getSelectProperties() {
        return selectProperties;
    }

    /**
     * @param 查询字段(多个字段用逗号隔开) the selectProperties to set
     */
    public void setSelectProperties(String selectProperties) {
        this.selectProperties = selectProperties;
    }

    /**
     * @return the 排序字段(多个字段用逗号隔开)
     */
    public List<SortParam> getSortProperties() {
        return sortProperties;
    }

    /**
     * @param 排序字段(多个字段用逗号隔开) the sortProperties to set
     */
    public void setSortProperties(List<SortParam> sortProperties) {
        this.sortProperties = sortProperties;
    }

    /**
     * @return the 页码
     */
    public int getPageIndex() {
        return pageIndex;
    }

    /**
     * @param 页码 the pageIndex to set
     */
    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    /**
     * @return the 每页条数
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * @param 每页条数 the pageSize to set
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * @return the 数据索引
     */
    public int getFirstRecordIndex() {
        return this.pageIndex == 0 ? 0 : ((this.pageIndex - 1) * this.pageSize);
    }
}
