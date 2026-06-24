package com.example.web4;

import com.alibaba.fastjson2.JSON;

public class book {
    private String id;
    private String name;
    private String pub;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPub() {
        return pub;
    }

    public void setPub(String pub) {
        this.pub = pub;
    }

    public book(){

    }
    public book(String id,String name,String pub){
        this.id = id;
        this.name = name;
    }
    public static void main(String[] args){
        book b1 = new book("01","a","qs");
        System.out.println(JSON.toJSONString(b1));

    }
}
