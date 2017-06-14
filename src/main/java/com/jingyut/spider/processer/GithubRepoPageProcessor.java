package com.jingyut.spider.processer;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * 给webmagic使用的Github
 * Created by mmy on 2017/6/8.
 */
public class GithubRepoPageProcessor implements PageProcessor{

    //站点操作
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);

    /**
     * 处理一个爬到的页面
     * @param page 页面
     */
    public void process(Page page) {
        page.addTargetRequests(page.getHtml().links().regex("(https://github\\.com/\\w+/\\w+)").all());
        page.putField("author", page.getUrl().regex("https://github\\.com/(\\w+)/.*").toString());
        page.putField("name", page.getHtml().xpath("//h1[@class='entry-title public']/strong/a/text()").toString());
        if (page.getResultItems().get("name")==null){
            //skip this page
            page.setSkip(true);
        }
        page.putField("readme", page.getHtml().xpath("//div[@id='readme']/tidyText()"));
    }

    public Site getSite() {
        return site;
    }
}
