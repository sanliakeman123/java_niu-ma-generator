package com.common;

import java.util.List;

// must
public class PageInfo <T> {

    private List<T> list;
    private Long total;

    public PageInfo(List<T> list, Long total) {
        this.list = list;
        this.total = total;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
