package com.jingyut.spider.server;

import com.jingyut.spider.constant.StrConstant;
import com.jingyut.spider.processer.PostProcessor;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.model.HttpRequestBody;
import us.codecraft.webmagic.utils.HttpConstant;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mmy on 2017/6/8.
 */
public class MySpider {

    public static void main(String[] args) throws Exception{
        //请求地址
        Request strRequest = new Request(StrConstant.STR_KEY_POST_URL);
        //请求类型 post
        strRequest.setMethod(HttpConstant.Method.POST);

        Map<String,Object> postMap = new HashMap<>();
        postMap.put("input","A549");

        //将参数设置到请求对象上
        strRequest.setRequestBody(HttpRequestBody.form(postMap,"utf-8"));

        Spider.create(new PostProcessor())
                .addRequest(strRequest)
                .run();
    }
}
