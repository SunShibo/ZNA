package com.zna.server.common.constants;

public enum Constants {
    /* 首页跳转url : 关于我们 */ GOTOABOUTUS("跳转到关于我们"),
    /* 首页跳转url : 经典项目 */  GOTOPROJECT("跳转到项目"),
    /* 首页跳转url : 核心团队 */ GOTOTEAM("跳转到核心团队"),
    /* 首页跳转url : 最新动态 */ GOTORECENTNEWS("跳转到最新动态"),
    /* 首页跳转url : 联系我们 */ GOTOOFFICECONTACT("跳转到办公室");
    Constants(String value) {
        this.value = value;
    }

    private String value;

    public String getValue() {
        return value;
    }
}
