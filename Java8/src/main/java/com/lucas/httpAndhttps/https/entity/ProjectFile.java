package com.lucas.httpAndhttps.https.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lucas
 * @Description TODO
 * @date 2023-06-15 9:33
 */
public class ProjectFile {
    private List<FileInfo> records;
    private int total;
    private int size;
    private int current;
    private int pages;
    private List orders;
    private boolean optimizeCountSql;
    private boolean searchCount;
    private String countId;
    private String maxLimit;

    public List<FileInfo> getRecords() {
        return records;
    }

    public void setRecords(List<FileInfo> records) {
        this.records = records;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public List getOrders() {
        return orders;
    }

    public void setOrders(List orders) {
        this.orders = orders;
    }

    public boolean isOptimizeCountSql() {
        return optimizeCountSql;
    }

    public void setOptimizeCountSql(boolean optimizeCountSql) {
        this.optimizeCountSql = optimizeCountSql;
    }

    public boolean isSearchCount() {
        return searchCount;
    }

    public void setSearchCount(boolean searchCount) {
        this.searchCount = searchCount;
    }

    public String getCountId() {
        return countId;
    }

    public void setCountId(String countId) {
        this.countId = countId;
    }

    public String getMaxLimit() {
        return maxLimit;
    }

    public void setMaxLimit(String maxLimit) {
        this.maxLimit = maxLimit;
    }

    public void clone(ProjectFile obj) {
        if (null == obj)
            return;

        if ( this.records == null )
            this.records = new ArrayList<>();

        if (this.records.size() == 0) {
            this.records.addAll(obj.getRecords());
            this.total = obj.getTotal();
            this.size = obj.getSize();
            this.current = obj.getCurrent();
            this.pages = obj.getPages();
            this.optimizeCountSql = obj.isOptimizeCountSql();
            this.searchCount = obj.isSearchCount();
            this.countId = obj.getCountId();
            this.maxLimit = obj.getMaxLimit();

            if (this.orders == null)
                this.orders = new ArrayList();
            this.orders.addAll(obj.getOrders());
        } else {
            this.records.addAll(obj.records);
        }
    }
}
