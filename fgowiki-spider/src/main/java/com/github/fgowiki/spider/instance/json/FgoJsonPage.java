package com.github.fgowiki.spider.instance.json;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

/**
 * json
 *
 * @author jiang
 * @create 2017-11-27 19:53
 **/
public abstract class FgoJsonPage implements PageProcessor {

    private int pageNumber = 1;

    @Override
    public void process(Page page) {
        System.out.println("=====================================================");
        System.out.println(page.getUrl());
        String response = page.getJson().get();
        JSONObject object = JSONObject.parseObject(response.substring(response.indexOf("(") + 1, response.lastIndexOf(")")));
        JSONArray datas = object.getJSONArray("data");
        if (datas != null && datas.size() > 0) {
            datas.forEach((data -> saveData((JSONObject) data)));
            pageNumber++;
            page.addTargetRequest(this.getNextRequest());
        }
        System.out.println("=====================================================");
    }

    /**
     * 设置将josn转为field的映射关系
     *
     * @return
     */
    abstract Map<String, String> getFeilds();

    /**
     * 设置url 须包含分页信息
     * 使用占位符{0}
     *
     * @return
     */
    abstract String getUrl();

    protected void start() throws IllegalAccessException, InstantiationException {
        Spider.create(this.getClass().newInstance())
                .addUrl(this.getNextRequest())
                //.addPipeline(new JsonFilePipeline("D:\\webmagic\\"))
                .thread(1)
                .run();
    }

    protected String getNextRequest() {
        return MessageFormat.format(this.getUrl(), pageNumber);
    }

    /**
     * 自定义保存
     *
     * @param data
     */
    abstract void saveData(JSONObject data);

}
