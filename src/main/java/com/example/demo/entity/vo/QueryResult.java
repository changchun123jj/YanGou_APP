package com.example.demo.entity.vo;

import java.io.Serializable;
import java.util.List;


/**
 * 查询结果对象
 *
 * @author liaoc
 */
public class QueryResult implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 当前页数据
     */
    private List<?> result;
    /**
     * 页码
     */
    private int pageIndex = 1;
    /**
     * 每页条数
     */
    private int pageSize = 10;
    /**
     * 总页数
     */
    private int totalPage = 0;
    /**
     * 总记录数
     */
    private int totalRecord = 0;

    /**
     * 构建对象
     *
     * @param pageIndex   页码
     * @param pageSize    每页条数
     * @param result      结果集
     * @param totalRecord 总记录数
     */
    public QueryResult(int pageIndex, int pageSize, List<?> result, int totalRecord) {
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.result = result;
        this.totalRecord = totalRecord;
    }

    /**
     * 构建对象
     *
     * @param queryParam  页码、每页条数
     * @param result      结果集
     * @param totalRecord 总记录数
     */
    public QueryResult(QueryParam queryParam, List<?> result, int totalRecord) {
        this.pageIndex = queryParam.getPageIndex();
        this.pageSize = queryParam.getPageSize();
        this.result = result;
        this.totalRecord = totalRecord;
    }

    /**
     * 设置页码、每页条数
     */
    public QueryResult setQueryParam(QueryParam queryParam) {
        this.pageIndex = queryParam.getPageIndex();
        this.pageSize = queryParam.getPageSize();
        return this;
    }

    /**
     * 设置结果集、总记录数
     */
    public QueryResult setResult(List<?> result, int totalRecord) {
        this.result = result;
        this.totalRecord = totalRecord;
        return this;
    }

    /**
     * @return the 当前页数据
     */
    public List<?> getResult() {
        return result;
    }

    /**
     * @param 当前页数据 the result to set
     */
    public void setResult(List<?> result) {
        this.result = result;
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
     * @return the 总页数
     */
    public int getTotalPage() {
        if (this.pageSize > 0 && this.totalRecord > 0) {
            this.totalPage = (totalRecord % pageSize == 0 ? totalRecord / pageSize : totalRecord / pageSize + 1);
        }
        return totalPage;
    }

    /**
     * @return the 总记录数
     */
    public int getTotalRecord() {
        return totalRecord;
    }

    /**
     * @param 总记录数 the totalRecord to set
     */
    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }
}
