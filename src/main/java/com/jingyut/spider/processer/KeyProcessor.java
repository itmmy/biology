package com.jingyut.spider.processer;

import com.jingyut.spider.constant.StrConstant;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;

/**
 * 对搜索到的关键词进行处理的处理器
 * Created by mmy on 2017/6/8.
 */
public class KeyProcessor implements PageProcessor {
    //站点操作
    private Site site = Site.me().setRetryTimes(3).setSleepTime(10);

    public void process(Page page) {
        Html html = page.getHtml();
        page.putField("Amelogenin",html.xpath(StrConstant.STR_GET_KEYPAGE_XPATH1).all());
        page.putField("XY",html.xpath(StrConstant.STR_GET_KEYPAGE_XPATH2).all());
    }

    public Site getSite() {
        return site;
    }
}
