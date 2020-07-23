package com.yitiankeji.response;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
public class Pagation {

    private long draw = System.currentTimeMillis();

    private Integer sEcho;
    private Integer iDisplayStart;
    private Integer iDisplayLength;

    private long iTotalRecords;
    private long iTotalDisplayRecords;
    private List<?> aaData = new ArrayList<>();

    public Pagation page(com.baomidou.mybatisplus.extension.plugins.pagination.Page page) {
        setiTotalRecords(page.getTotal());
        setiTotalDisplayRecords(page.getTotal());
        setAaData(page.getRecords());
        return this;
    }

    public <T> com.baomidou.mybatisplus.extension.plugins.pagination.Page toPage() {
        Page<T> page = new Page<>();
        page.setCurrent(iDisplayStart / iDisplayLength + 1);
        page.setSize(getiDisplayLength());
        return page;
    }

    public Integer getsEcho() {
        return sEcho;
    }

    public void setsEcho(Integer sEcho) {
        this.sEcho = sEcho;
    }

    public Integer getiDisplayStart() {
        return iDisplayStart;
    }

    public void setiDisplayStart(Integer iDisplayStart) {
        this.iDisplayStart = iDisplayStart;
    }

    public Integer getiDisplayLength() {
        return iDisplayLength;
    }

    public void setiDisplayLength(Integer iDisplayLength) {
        this.iDisplayLength = iDisplayLength;
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
