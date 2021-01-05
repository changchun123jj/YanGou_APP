package com.example.demo.entity.vo;

/**
 * 排序对象
 *
 * @author liaoc
 */
public class SortParam {
    /**
     * 排序关键字(顺序)
     */
    public final static int ASC = 1;
    /**
     * 排序关键字(倒序)
     */
    public final static int DESC = -1;

    /**
     * 排序字段
     */
    private String sortPro;
    /**
     * 排序规则
     */
    private int sortRule;

    public SortParam() {
    }

    public SortParam(String sortPro, int sortRule) {
        this.sortPro = sortPro;
        this.sortRule = sortRule;
    }

    /**
     * @return the 排序字段
     */
    public String getSortPro() {
        return sortPro;
    }

    /**
     * @param 排序字段 the sortPro to set
     */
    public void setSortPro(String sortPro) {
        this.sortPro = sortPro;
    }

    /**
     * @return the 排序规则
     */
    public int getSortRule() {
        return sortRule;
    }

    /**
     * @param 排序规则 the sortRule to set
     */
    public void setSortRule(int sortRule) {
        this.sortRule = sortRule;
    }
}
