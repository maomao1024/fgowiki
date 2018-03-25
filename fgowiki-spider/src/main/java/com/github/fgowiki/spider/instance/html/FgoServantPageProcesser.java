package com.github.fgowiki.spider.instance.html;

import com.alibaba.fastjson.JSONObject;
import com.github.fgowiki.spider.model.FgoServant;
import com.github.fgowiki.spider.utils.FgoCamp;
import com.github.fgowiki.spider.utils.ObjectUtil;
import com.github.fgowiki.spider.utils.HibernateUtil;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.Selectable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 英灵信息
 *
 * @author jiang
 * @create 2017-11-27 19:44
 **/
public class FgoServantPageProcesser implements PageProcessor {

	private Site site = Site.me().setRetryTimes(0).setSleepTime(1000);
    private static Map<String, Integer> feilds = new HashMap<>();
	private static int index = 114;
	private static final String url = "http://fgowiki.com/guide/petdetail/{0}";

    private static Sheet sheet;
    private static Workbook workbook;
    private static int lastRowIndex = 0;
    private static File file;

    static {
        FileInputStream fos = null;
        try {
            System.out.println("文件路径：" + System.getProperty("user.home"));
            file = new File(System.getProperty("user.home") + "\\Documents\\fgo_servant.xls");
            fos = new FileInputStream(file);
            workbook = new HSSFWorkbook(new POIFSFileSystem(fos));
            sheet = workbook.getSheetAt(0);
            int cellIndex = 0;
            int rowIndex = 0;
            Row row = sheet.getRow(rowIndex);
            Cell cell = row.getCell(cellIndex);
            while (cell != null && StringUtils.isNotBlank(cell.getStringCellValue())) {
                feilds.put(cell.getStringCellValue().toLowerCase(), cellIndex - 1);
                cell = row.getCell(cellIndex++);
            }
            while (row != null && row.getCell(feilds.get("id")) != null && StringUtils.isNotBlank(row.getCell(feilds.get("id")).getStringCellValue())) {
                row = sheet.getRow(rowIndex++);
            }
            lastRowIndex = rowIndex - 1;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(fos);
        }
    }

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
            this.callback();
		}

		System.out.println("=====================================================");
	}

	public void saveData(JSONObject data) {
        Row row = sheet.createRow(lastRowIndex++);
        System.out.println("保存id为" + data.getString("ID") + "的数据");
        data.forEach((key, value) -> {
            row.createCell(feilds.get(key.toLowerCase())).setCellValue(Objects.toString(value, ""));
        });
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

    private void callback() {
        FileOutputStream fos = null;
        try {
            String name = "\\Documents\\fgo_servant_" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + ".xls";
            fos = new FileOutputStream(new File(System.getProperty("user.home") + name));
            workbook.write(fos);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(fos);
        }
    }


	private String removeString(String str) {
		String[] rem = {"cm", "CM", "KG", "kg", "?", "？", "㎝"};
		for (String s : rem) {
			str = str.replace(s, "");
		}
		return str;
	}
}
