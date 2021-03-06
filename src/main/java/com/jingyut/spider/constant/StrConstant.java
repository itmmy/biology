package com.jingyut.spider.constant;

/**
 * Str项目的常量类
 * Created by mmy on 2017/6/8.
 */
public class StrConstant {
    //带关键字POST访问的请求地址
    public static final String STR_KEY_POST_URL = "http://web.expasy.org/cgi-bin/cellosaurus/search";

    //POST请求结果页面的XPATH地址
    public static final String STR_POSTPAGE_XPATH = "//table/tbody/tr/td/a/text()";

    //带关键字Get形式访问的请求地址
    public static final String STR_KEY_GET_URL = "http://web.expasy.org/cellosaurus/";

    //带关键字Get形式访问的结果页面上的XPATH地址
    public static final String STR_GET_KEYPAGE_XPATH1 = "//table/tbody/tr[12]/td/table/tbody/tr/td/a/text()";

    //带关键字Get形式访问的结果页面上的XPATH地址
    public static final String STR_GET_KEYPAGE_XPATH2 = "//table/tbody/tr[12]/td/table/tbody/tr/td[2]/text()";

    //Form表单提交时参数的名字
    public static final String STR_FROM_1 = "input";
}
