package com.github.fgowiki.spider.instance.json;

import com.alibaba.fastjson.JSONObject;
import com.github.fgowiki.spider.model.FgoServant;
import com.github.fgowiki.spider.utils.FgoClazz;
import com.github.fgowiki.spider.utils.HibernateUtil;
import org.apache.commons.lang3.StringUtils;
import us.codecraft.webmagic.Site;

import java.util.HashMap;
import java.util.Map;

/**
 * 英灵信息
 *
 * @author jiang
 * @create 2017-11-27 19:44
 **/
public class FgoServantPageProcesser extends FgoJsonPage {

    private Site site = Site.me().setRetryTimes(0).setSleepTime(1000);

    private static Map<String, String> feilds = new HashMap<>();

    static {
        feilds.put("id", "id");
        feilds.put("name", "name");
        feilds.put("name_jp", "name_jp");
        feilds.put("name_en", "name_en");
        feilds.put("image", "image");
        feilds.put("class", "class");
        feilds.put("lv1_hp", "lv1_hp");
        feilds.put("lv1_atk", "lv1_atk");
        feilds.put("lvmax4_hp", "lvmax4_hp");
        feilds.put("lvmax4_atk", "lvmax4_atk");
    }


    @Override
    Map<String, String> getFeilds() {
        return feilds;
    }

    @Override
    String getUrl() {
        return "http://api.umowang.com/guides/data/fgo?jsoncallback=getguidedata&command=pets_list_all&page={0}";
    }

    @Override
    void saveData(JSONObject data) {
        /*
         image	http://file.fgowiki.com/fgo/head/191.png
         lv1_hp	1744
         lvmax4_atk	9997
         lvmax4_hp	10901
         name	机械伊丽酱Ⅱ号机
         name_jp	メカエリチャンⅡ号機
         id	191
         lv1_atk	1666
         class	Alterego
         name_en	mekaerichan Ⅱ
         */
        FgoServant servant = new FgoServant();
        servant.setAtkStage0(data.getInteger("lv1_atk"));
        servant.setHpStage0(data.getInteger("lv1_hp"));
        servant.setAtkStage4(data.getInteger("lvmax4_atk"));
        servant.setHpStage4(data.getInteger("lvmax4_hp"));
        servant.setNameZh(data.getString("name"));
        servant.setNameJp(data.getString("name_jp"));
        servant.setId(data.getInteger("id"));
        servant.setAtkStage0(data.getInteger("lv1_atk"));
        String s = data.getString("class");
        if (StringUtils.isNotBlank(s)) {
            // FIXME 仍然有问题
            s = s.trim().replaceAll("Ⅰ", "").replaceAll("Ⅱ ", "").replaceAll("Ⅲ", "");
            FgoClazz fgoClazz = FgoClazz.getClazz(s);
            servant.setClazz(fgoClazz == null ? 0 : fgoClazz.getId());
        }
        servant.setNameEn(data.getString("name_en"));
        HibernateUtil.add(servant);
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        new FgoServantPageProcesser().start();
    }
}
