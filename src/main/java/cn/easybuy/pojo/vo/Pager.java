package cn.easybuy.pojo.vo;

import lombok.Data;

@Data
public class Pager {
    public  long total;
    public  int rowPerPage;
    public  Integer currentPage;

    public Pager(long total, int rowPerPage, Integer currentPage) {
        this.total = total;
        this.rowPerPage = rowPerPage;
        this.currentPage = currentPage;
    }
}
