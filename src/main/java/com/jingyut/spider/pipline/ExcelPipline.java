package com.jingyut.spider.pipline;


import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.Map;

/**
 * Created by mmy on 2017/6/14.
 */
public class ExcelPipline implements Pipeline {
    @Override
    public void process(ResultItems resultItems, Task task) {
        Map<String, Object> map = resultItems.getAll();
        System.out.println(map.keySet());
        System.out.println(map.values());
    }
}
