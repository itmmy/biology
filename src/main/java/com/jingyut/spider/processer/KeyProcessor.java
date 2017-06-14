package com.jingyut.spider.processer;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * 对搜索到的关键词进行处理的处理器
 * Created by mmy on 2017/6/8.
 */
public class KeyProcessor implements PageProcessor {
    //站点操作
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);

    public void process(Page page) {
        page.putField("result",page.getHtml().xpath("//table/tbody/tr[11]/"));
    }

    public Site getSite() {
        return site;
    }
}
