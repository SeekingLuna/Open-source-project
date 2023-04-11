package com.li.domain;

import java.util.List;

public class Pages {
    private List arrayLis;
    private int total;
    private int pageSize;
    private int pageIndex;
    public Pages() {


    }
    public Pages(List arrayList, int total, int pageSize, int pageIndex) {
        this.arrayLis = arrayList;
        this.total = total;
        this.pageSize = pageSize;
        this.pageIndex = pageIndex;
    }

    public List getArrayLis() {
        return arrayLis;
    }

    public void setArrayLis(List arrayLis) {
        this.arrayLis = arrayLis;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }
/*
    "total": 46,
    "pageSize": 100,
    "page": 2,
    "list": []*/
}
