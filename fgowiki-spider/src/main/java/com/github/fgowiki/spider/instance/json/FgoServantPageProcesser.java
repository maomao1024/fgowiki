package com.github.fgowiki.spider.instance.json;

import com.alibaba.fastjson.JSONObject;
import com.github.fgowiki.spider.model.FgoServant;
import com.github.fgowiki.spider.utils.FgoClazz;
import com.github.fgowiki.spider.utils.HibernateUtil;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import us.codecraft.webmagic.Site;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 英灵信息
 *
 * @author jiang
 * @create 2017-11-27 19:44
 **/
public class FgoServantPageProcesser extends FgoJsonPage {

    private Site site = Site.me().setRetryTimes(0).setSleepTime(1000);

    private static Map<String, Integer> feilds = new HashMap<>();
    private static Map<Integer, JSONObject> unresolved = new HashMap<>();
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
            sheet = workbook.getSheetAt(1);
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
    String getUrl() {
        return "https://api.umowang.com/guides/data/fgo?jsoncallback=getguidedata&command=pets_list_all&page={0}&params=";
    }

    @Override
    void saveData(JSONObject data) {
        Row row = sheet.createRow(lastRowIndex++);
        System.out.println("保存id为" + data.getString("id") + "的数据");
        data.forEach((key, value) -> {
            row.createCell(feilds.get(key.toLowerCase())).setCellValue(Objects.toString(value, ""));
        });
    }

    @Override
    protected void callback() {
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

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        new FgoServantPageProcesser().start();
    }
}
