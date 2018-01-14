package com.github.fgowiki.spider.instance.html;

import com.alibaba.fastjson.JSONObject;
import com.github.fgowiki.spider.model.FgoServant;
import com.github.fgowiki.spider.utils.FgoCamp;
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
import java.util.*;

/**
 * 英灵信息
 *
 * @author jiang
 * @create 2017-11-27 19:44
 **/
public class FgoServantPageProcesser implements PageProcessor {

	private Site site = Site.me().setRetryTimes(0).setSleepTime(1000);
	private static List<FgoServant> servantList;
	Map<String, String> map = new HashMap<>();
	private static int index = 114;
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
			index++;
			page.addTargetRequest(getNextRequest());
		} else {
			map.forEach((key, value) -> System.out.println(key));
		}

		System.out.println("=====================================================");
	}

	public void saveData(JSONObject data) {
		FgoServant servant = (FgoServant) HibernateUtil.get(FgoServant.class, data.getInteger("ID"));
		if (servant != null) {
			try {
				String campStr = data.getString("Camp");
				Integer camp = FgoCamp.getCamp(campStr);
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
				String orgin = data.getString("Origin");
				String region = data.getString("Region");
				Integer Height = null;
				Integer Weight = null;
				try {
					Height = Integer.parseInt(removeString(data.getString("Height")));
				} catch (NumberFormatException e) {
					System.out.println(servant.getNameZh() + "-Weight:" + data.getString("Height").toLowerCase());
				}
				try {
					Weight = Integer.parseInt(removeString(data.getString("Weight")));
				} catch (NumberFormatException e) {
					System.out.println(servant.getNameZh() + "-Weight:" + data.getString("Weight").toLowerCase());
				}
				String gender = data.getString("Gender");

				servant.setCamp(camp);
				servant.setCards(cards);
				servant.setAtkLv90(lv90_atk);
				servant.setHpLv90(lv90_hp);
				servant.setAtkLv100(lv100_atk);
				servant.setHpLv100(lv100_hp);
				servant.setPainter(painter);
				servant.setCv(cv);
				servant.setOrigin(orgin);
				servant.setGender(gender == null ? 0 : (gender.contains("女") ? 0 : 1));
				servant.setRegion(region);
				servant.setHeight(Height);
				servant.setWeight(Weight);
				HibernateUtil.saveOrUpdate(servant);
			} catch (Exception e) {
				e.printStackTrace();
			}
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
		spider.addUrl(MessageFormat.format(url, index));
		spider.thread(1).run();
	}

	private static String getNextRequest() {
		return MessageFormat.format(url, index);
	}


	private String removeString(String str) {
		String[] rem = {"cm", "CM", "KG", "kg", "?", "？", "㎝"};
		for (String s : rem) {
			str = str.replace(s, "");
		}
		return str;
	}
}
