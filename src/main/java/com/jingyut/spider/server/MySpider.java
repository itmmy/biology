package com.jingyut.spider.server;

import com.jingyut.spider.constant.StrConstant;
import com.jingyut.spider.constant.StrValue;
import com.jingyut.spider.pipline.ExcelPipline;
import com.jingyut.spider.processer.KeyProcessor;
import com.jingyut.spider.processer.PostProcessor;
import com.jingyut.spider.util.InputKeyUtil;
import com.jingyut.spider.util.RequestUtil;
import us.codecraft.webmagic.Spider;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mmy on 2017/6/8.
 */
public class MySpider {
    public static void main(String[] args) throws Exception{
        //从Excel中获取所有待查的Key
        List<String> keys = InputKeyUtil.getKeysFromEecel(args[0]);
        //创建第一次post请求用的爬虫
        Spider postSpider = Spider.create(new PostProcessor());
        //创建第二次get带结果key请求的爬虫
        Spider keySpider = Spider.create(new KeyProcessor());
        for (String key: keys) {
            System.out.println("key: [" + key + "] start!!!");

            //封装post请求参数
            Map<String,Object> postMap = new HashMap<>();
            postMap.put(StrConstant.STR_FROM_1,key);

            //执行第一次post请求
            postSpider.addRequest(RequestUtil.getPostRequest(StrConstant.STR_KEY_POST_URL,postMap))
                    .run();
            postSpider.close();

            //执行第二次get带结果key的请求
            keySpider.addRequest(RequestUtil.getGetRequest(StrConstant.STR_KEY_GET_URL,StrValue.postResult))
                    .addPipeline(new ExcelPipline())
                    .run();
            keySpider.close();

            System.out.println("key: [" + key + "] start!!!");
        }
    }
}
