package com.jxsun.pojo;

import org.apache.solr.client.solrj.beans.Field;

import java.util.Arrays;

public class News {

    @Field
    private String id ;

    @Field
    private String[] title;

    @Field
    private String comments;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String[] getTitle() {
        return title;
    }

    public void setTitle(String[] title) {
        this.title = title;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append("[News] id:")
                .append(this.getId())
                .append(", title:")
                .append(Arrays.toString(this.getTitle()))
                .append(", comments:")
                .append(this.getComments());
        return sb.toString() ;
    }

}
