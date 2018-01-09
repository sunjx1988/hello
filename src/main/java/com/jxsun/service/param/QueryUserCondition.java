package com.jxsun.service.param;

/**
 * Created by sunjx on 2017/11/29.
 */
public class QueryUserCondition {

    private int pageSize = 10;

    private int pageNo = 1;

    private String likeName;

    private String[] eqName;

    public String[] getEqName() {
        return eqName;
    }

    public void setEqName(String[] eqName) {
        this.eqName = eqName;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public String getLikeName() {
        return likeName;
    }

    public void setLikeName(String likeName) {
        this.likeName = likeName;
    }
}
