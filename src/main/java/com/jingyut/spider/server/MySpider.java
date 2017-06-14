package com.jingyut.spider.server;

import com.jingyut.spider.constant.StrConstant;
import com.jingyut.spider.constant.StrValue;
import com.jingyut.spider.processer.KeyProcessor;
import com.jingyut.spider.processer.PostProcessor;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.model.HttpRequestBody;
import us.codecraft.webmagic.pipeline.Pipeline;
import us.codecraft.webmagic.utils.HttpConstant;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mmy on 2017/6/8.
 */
public class MySpider {

    public static void main(String[] args) throws Exception{
        //请求地址
        Request strPostRequest = new Request(StrConstant.STR_KEY_POST_URL);
        //请求类型 post
        strPostRequest.setMethod(HttpConstant.Method.POST);

        Map<String,Object> postMap = new HashMap<>();
        postMap.put("input","A549");

        //将参数设置到请求对象上
        strPostRequest.setRequestBody(HttpRequestBody.form(postMap,"utf-8"));

        PostProcessor postProcessor = new PostProcessor();
        System.out.println("======================PostSpider start=====================");
        Spider postSpider = Spider.create(postProcessor);
        postSpider.addRequest(strPostRequest);
        postSpider.run();
        System.out.println("======================PostSpider stop=====================");



        System.out.println("======================keySpider start=====================");
        Spider keySpider = Spider.create(new KeyProcessor());
        //请求地址
        Request strGetRequest = new Request(StrConstant.STR_KEY_GET_URL + StrValue.postResult);
        keySpider.addRequest(strGetRequest);
        keySpider.addPipeline(new Pipeline() {
            @Override
            public void process(ResultItems resultItems, Task task) {
                Map<String, Object> map = resultItems.getAll();
                System.out.println(map.keySet());
                System.out.println(map.values());
            }
        });
        keySpider.run();
        System.out.println("======================keySpider start=====================");
    }
}
