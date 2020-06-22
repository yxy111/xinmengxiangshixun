package cn.easybuy.pojo.vo;

import lombok.Data;

@Data
public class Pager {
    public  long pageCount;
    public  int rowPerPage;
    public  Integer currentPage;
    public String url;
    public  Integer userId;

    public Pager(long pageCount, int rowPerPage, Integer currentPage, String url) {
        this.pageCount = pageCount;
        this.rowPerPage = rowPerPage;
        this.currentPage = currentPage;
        this.url = url;
    }

    public Pager(long pageCount, int rowPerPage, Integer currentPage, String url, Integer userId) {
        this.pageCount = pageCount;
        this.rowPerPage = rowPerPage;
        this.currentPage = currentPage;
        this.url = url;
        this.userId = userId;
    }
}
