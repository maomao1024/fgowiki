package com.github.fgowiki.spider.instance.json;

import com.alibaba.fastjson.JSONObject;
import com.github.fgowiki.spider.model.FgoMaterial;
import com.github.fgowiki.spider.utils.FgoBox;
import com.github.fgowiki.spider.utils.HibernateUtil;
import us.codecraft.webmagic.Site;

import java.util.HashMap;
import java.util.Map;

/**
 * 材料信息
 *
 * @author
 * @create 2017-11-27 19:17
 **/
public class FgoMaterialPageProcesser extends FgoJsonPage {

    private Site site = Site.me().setRetryTimes(0).setSleepTime(1000);

    private static Map<String, String> feilds = new HashMap<>();

    static {
        feilds.put("no", "id");
        feilds.put("no", "name");
        feilds.put("no", "type");
        feilds.put("no", "box");
        feilds.put("no", "description");
        feilds.put("no", "loaction");
    }


    @Override
    Map<String, String> getFeilds() {
        return feilds;
    }

    @Override
    String getUrl() {
        return "http://api.umowang.com/guides/data/fgo?jsoncallback=getmaterialdata&command=material_list_all&page={0}";
    }

    @Override
    void saveData(JSONObject data) {
        /*
         about:"时代久远的贝类的壳。↵放在耳边的话，能够听到远古时期清澈的海潮声。"
         box:"Gold"
         class:"技能强化&灵基再临素材"
         image:"http://file.umowang.com/fgo/material/shell.png"
         name:"追忆的贝壳"
         no:74
         place:"——"
         */
        FgoMaterial material = new FgoMaterial();
        material.setDescription(data.getString("about"));
        material.setName(data.getString("name"));
        material.setLocation(data.getString("place"));
        material.setId(data.getInteger("no"));
        String type = data.getString("class");
        material.setType(type.contains("&") ? 1 : 0);
        material.setBox(FgoBox.getBoxType(data.getString("box")));

        HibernateUtil.saveOrUpdate(material);
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        new FgoMaterialPageProcesser().start();
    }
}