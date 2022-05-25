package com.liujie.vo;

public class Page {
    private Integer pageNo;
    private  Integer pageSize;

    private String name;

    private String queryUserRole;

    private Integer skipCount;

    public Integer getSkipCount() {
        return skipCount;
    }

    public void setSkipCount(Integer skipCount) {
        this.skipCount = skipCount;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQueryUserRole() {
        return queryUserRole;
    }

    public void setQueryUserRole(String queryUserRole) {
        this.queryUserRole = queryUserRole;
    }
}
