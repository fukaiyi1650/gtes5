package com.yitiankeji.response;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
public class Pagation {

    private long draw = System.currentTimeMillis();
    private long sEcho;
    private long iTotalRecords;
    private long iTotalDisplayRecords;

    private List<?> aaData = new ArrayList<>();

    public Pagation(Page<?> page) {
        page(page);
    }

    public Pagation page(com.baomidou.mybatisplus.extension.plugins.pagination.Page<?> page) {
        setsEcho(page.getCurrent());
        setiTotalRecords(page.getTotal());
        setiTotalDisplayRecords(page.getTotal());
        setAaData(page.getRecords());
        return this;
    }

    public long getsEcho() {
        return sEcho;
    }

    public void setsEcho(long sEcho) {
        this.sEcho = sEcho;
    }

    public long getiTotalRecords() {
        return iTotalRecords;
    }

    public void setiTotalRecords(long iTotalRecords) {
        this.iTotalRecords = iTotalRecords;
    }

    public long getiTotalDisplayRecords() {
        return iTotalDisplayRecords;
    }

    public void setiTotalDisplayRecords(long iTotalDisplayRecords) {
        this.iTotalDisplayRecords = iTotalDisplayRecords;
    }

    public List<?> getAaData() {
        return aaData;
    }

    public void setAaData(List<?> aaData) {
        this.aaData = aaData;
    }
}
