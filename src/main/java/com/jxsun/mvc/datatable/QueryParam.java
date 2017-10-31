package com.jxsun.mvc.datatable;

import java.util.List;

public class QueryParam {

    private String kw;

    private int draw ;

    private int start ;

    private int length ;

//    private List<QueryColumn> columns;
//
//    private QueryOrder order;

    public String getKw() {
        return kw;
    }

    public void setKw(String kw) {
        this.kw = kw;
    }

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

//    public List<QueryColumn> getColumns() {
//        return columns;
//    }
//
//    public void setColumns(List<QueryColumn> columns) {
//        this.columns = columns;
//    }
//
//    public QueryOrder getOrder() {
//        return order;
//    }
//
//    public void setOrder(QueryOrder order) {
//        this.order = order;
//    }
}
