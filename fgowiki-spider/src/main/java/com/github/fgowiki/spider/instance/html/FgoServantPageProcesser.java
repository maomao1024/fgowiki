package com.github.fgowiki.spider.instance.html;

import com.alibaba.fastjson.JSONObject;
import com.github.fgowiki.spider.model.FgoServant;
import com.github.fgowiki.spider.utils.ObjectUtil;
import com.github.fgowiki.spider.utils.HibernateUtil;
import org.apache.commons.lang3.StringUtils;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.Selectable;

import java.text.MessageFormat;
import java.util.List;

/**
 * 英灵信息
 *
 * @author jiang
 * @create 2017-11-27 19:44
 **/
public class FgoServantPageProcesser implements PageProcessor {

    private Site site = Site.me().setRetryTimes(0).setSleepTime(1000);
    private static List<FgoServant> servantList;
    private static int index = 1;
    private static final String url = "http://fgowiki.com/guide/petdetail/{0}";

    @Override
    public void process(Page page) {
        System.out.println("=====================================================");
        System.out.println(page.getUrl());
        Html html = page.getHtml();
        Selectable script = html.xpath("//*[@id=\"row-move\"]/div[2]/div/script[9]");
        String datadetailString = script.regex("var datadetail = \\[(.+?)\\];").get();
        if (StringUtils.isNotBlank(datadetailString)) {
            JSONObject datadetail = JSONObject.parseObject(datadetailString);
            saveData(datadetail);
        }

        System.out.println("=====================================================");
    }

    public void saveData(JSONObject data) {
        FgoServant servant = (FgoServant) HibernateUtil.get(FgoServant.class, data.getInteger("ID"));
        if (servant != null) {
            //data.forEach((key, value) -> System.out.println(key + "\t" + value));
            String camp = data.getString("Camp");
            Integer star = data.getInteger("STAR");
            Integer card_quick = data.getInteger("CARD_QUICK");
            Integer card_arts = data.getInteger("CARD_ARTS");
            Integer card_buster = data.getInteger("CARD_BUSTER");
            String cards = ObjectUtil.getStringBylength("A", card_arts) + ObjectUtil.getStringBylength("B", card_buster) + ObjectUtil.getStringBylength("Q", card_quick);
            Integer lv90_atk = data.getInteger("LV90_ATK");
            Integer lv90_hp = data.getInteger("LV90_HP");
            Integer lv100_atk = data.getInteger("LV100_ATK");
            Integer lv100_hp = data.getInteger("LV100_HP");
            Integer exHit = data.getInteger("EXHit");
            Integer artHit = data.getInteger("ArtHit");
            Integer busHit = data.getInteger("BusHit");
            Integer quiHit = data.getInteger("QuiHit");
            String painter = data.getString("ILLUST");
            String cv = data.getString("CV");

        }
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        /*Object list = HibernateUtil.queryForlist("FROM FgoServant");
        servantList = (List<FgoServant>) list;*/
        Spider spider = Spider.create(new FgoServantPageProcesser());
        spider.addUrl(MessageFormat.format(url, 3));
        spider.thread(1).run();
    }

    private static String getNextRequest() {
        return MessageFormat.format(url, index);
    }
}
