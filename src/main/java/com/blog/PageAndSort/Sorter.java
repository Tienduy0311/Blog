package com.blog.PageAndSort;

public class Sorter {
    private String sortName;
    private String sortAscDec;

    public Sorter(String sortName, String sortAscDec) {
        this.sortName = sortName;
        this.sortAscDec = sortAscDec;
    }

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

    public String getSortAscDec() {
        return sortAscDec;
    }

    public void setSortAscDec(String sortAscDec) {
        this.sortAscDec = sortAscDec;
    }
}
