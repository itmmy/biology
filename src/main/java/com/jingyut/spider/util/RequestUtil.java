package com.jingyut.spider.util;

import com.jingyut.spider.constant.StrConstant;
import com.jingyut.spider.constant.StrValue;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.model.HttpRequestBody;
import us.codecraft.webmagic.utils.HttpConstant;

import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * Request工具，主要用于构造Request对象
 * Created by mmy on 2017/6/14.
 */
public class RequestUtil {
    /**
     * 根据跟给定的post请求的地址和请求参数构造Request对象
     * @param postActionName post请求地址
     * @param postMap 请求参数
     * @return 构建好的Request对象
     */
    public static Request getPostRequest(String postActionName, Map<String,Object> postMap){
        //请求地址
        Request strPostRequest = new Request(postActionName);
        //请求类型 post
        strPostRequest.setMethod(HttpConstant.Method.POST);
        //将参数设置到请求对象上
        try {
            strPostRequest.setRequestBody(HttpRequestBody.form(postMap,"utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return strPostRequest;
    }

    /**
     * 根据get请求地址和请求时所携带的关键字构造Request对象
     * @param getURLAddress get方式地址
     * @param getKey 携带的关键字
     * @return 构造完成的Rquest对象
     */
    public static Request getGetRequest(String getURLAddress,String getKey){
        Request strGetRequest = new Request(getURLAddress + StrValue.postResult);
        return  strGetRequest;
    }
}
