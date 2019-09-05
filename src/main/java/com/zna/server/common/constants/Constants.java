package com.zna.server.common.constants;

public enum Constants {
    /* 首页跳转url : 关于我们 */ GOTOABOUTUS("跳转到关于我们"),
    /* 首页跳转url : 经典项目 */  GOTOPROJECT("跳转到项目"),
    /* 首页跳转url : 核心团队 */ GOTOTEAM("跳转到核心团队"),
    /* 首页跳转url : 最新动态 */ GOTORECENTNEWS("跳转到最新动态"),
    /* 首页跳转url : 联系我们 */ GOTOOFFICECONTACT("跳转到办公室"),


    /* 首页跳转url : 酒店/度假 */ HOTELRESORT("HOTEL/RESORT"),
    /* 首页跳转url : 办公综合体 */ OFFICEMIXEDUSE("OFFICE/MIXED-USE"),
    /* 首页跳转url : 文化教育 */ EDUCATIONSCIENCE("EDUCATION/SCIENCE"),
    /* 首页跳转url : 养生居住 */ RESIDENTIALHEALTHCARE("RESIDENTIAL/HEALTHCARE"),
    /* 首页跳转url : 城市规划 */ MASTERPLANNING("MASTER/PLANNING"),
    /* 首页跳转url : 景观设计 */ LANDSCAPEDESIGN("LANDSCAPE/DESIGN"),
    /* 首页跳转url : 室内设计 */ INTERIORDESIGN("INTERIOR/DESIGN"),
    /* 首页跳转url : 展览 */ CIVICEXHIBITION("CIVIC/EXHIBITION");
    Constants(String value) {
        this.value = value;
    }

    private String value;

    public String getValue() {
        return value;
    }
}
