package com.lucas.collection.abstractList;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class AbstractListTest<E> extends AbstractList<E> {
    private int currentPageNo;
    private int totalPageNo;
    private int pageSize;
    private int totalSize;
    private List<E> data;

    public AbstractListTest() {
        this.data = new ArrayList<>();
    }

    public AbstractListTest(int currentPageNo, int totalPageNo, int pageSize, int totalSize) {
        this.currentPageNo = currentPageNo;
        this.totalPageNo = totalPageNo;
        this.pageSize = pageSize;
        this.totalSize = totalSize;
    }

    public AbstractListTest(int currentPageNo, int totalPageNo, int pageSize, int totalSize, List<E> data) {
        this.currentPageNo = currentPageNo;
        this.totalPageNo = totalPageNo;
        this.pageSize = pageSize;
        this.totalSize = totalSize;
        this.data = data;
    }

    @Override
    public E get(int index) {
        // return this.data == null ? null : this.data.get(index);
        return this.data.get(index);
    }

    @Override
    public int size() {
        // return this.data == null ? 0 :this.data.size();
        return this.data.size();
    }

    public int getCurrentPageNo() {
        return currentPageNo;
    }

    public void setCurrentPageNo(int currentPageNo) {
        this.currentPageNo = currentPageNo;
    }

    public int getTotalPageNo() {
        return totalPageNo;
    }

    public void setTotalPageNo(int totalPageNo) {
        this.totalPageNo = totalPageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(int totalSize) {
        this.totalSize = totalSize;
    }

    public List<E> getData() {
        return data;
    }

    public void setData(List<E> data) {
        this.data = data;
    }
}
