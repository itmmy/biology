package com.jingyut.spider.processer;

import com.jingyut.spider.constant.StrConstant;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * 对使用post方式进行提交的程序进行处理的处理器
 * Created by mmy on 2017/6/8.
 */
public class PostProcessor implements PageProcessor {
    public static String postResult;
    //站点操作
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);

    public void process(Page page) {
        page.putField("postResult",page.getHtml().xpath(StrConstant.STR_POSTPAGE_XPATH));
        postResult = page.getResultItems().get("postResult");
    }

    public Site getSite() {
        return site;
    }
}
