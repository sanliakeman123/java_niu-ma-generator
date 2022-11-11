package com.common;
// must
public class PageQuery<T> {
    private Long pageNum;
    private Long pageSize;
    private Long offset;
    private T entity;

    public T getEntity() {
        return entity;
    }

    public void setEntity(T entity) {
        this.entity = entity;
    }

    public PageQuery(Long pageNum, Long pageSize) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    // 组装参数
    public PageQuery make(){
        if(this.pageNum==null || this.pageNum.compareTo(1L) < 0){
            this.pageNum = 1L;
        }
        if(this.pageSize==null || this.pageSize.compareTo(1L) < 0){
            this.pageSize = 10L;
        }
        this.offset = ( this.pageNum - 1) * this.pageSize;
        return this;
    }

    public Long getPageNum() {
        return pageNum;
    }

    public PageQuery setPageNum(Long pageNum) {
        this.pageNum = pageNum;
        return this;
    }

    public Long getPageSize() {
        return pageSize;
    }

    public PageQuery setPageSize(Long pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public Long getOffset() {
        return offset;
    }

    public void setOffset(Long offset) {
        this.offset = offset;
    }
}
