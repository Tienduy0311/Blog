package com.blog.PageAndSort;

public class PageRequest implements Pageable {
    private Integer startPage;
    private Integer rowOfPage;
    private Sorter sortedBy;

    public PageRequest(Integer startPage, Integer rowOfPage, Sorter sortedBy) {
        if (startPage == null) {
            this.startPage = 1;
        } else {
            this.startPage = startPage;
        }
        if (rowOfPage == null) {
            this.rowOfPage = 3;
        } else {
            this.rowOfPage = rowOfPage;
        }
        this.sortedBy = sortedBy;
    }

    @Override
    public Integer getStartPage() {
        return this.startPage;
    }

    @Override
    public Integer getOffset() {
        if (startPage != null && rowOfPage != null) {
            return (this.startPage - 1) * rowOfPage;
        }
        return null;
    }

    @Override
    public Integer getRowOfPage() {
        return this.rowOfPage;
    }

    @Override
    public Sorter getSortedBy() {
        return this.sortedBy;
    }
}
