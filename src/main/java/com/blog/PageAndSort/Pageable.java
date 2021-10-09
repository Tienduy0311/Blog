package com.blog.PageAndSort;

public interface Pageable {
    Integer getStartPage();

    Integer getOffset();

    Integer getRowOfPage();

    Sorter getSortedBy();
}
