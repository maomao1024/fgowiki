package com.github.fgowiki.spider.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * fgo工具类
 *
 * @author jiang
 * @create 2017-11-27 21:42
 **/
public class FgoUtil {

    public static Integer getClazz(String clazz) {
        if ("Shielder".equals(clazz)) {
            return 1;
        }
        if ("Saber".equals(clazz)) {
            return 2;
        }
        if ("Archer".equals(clazz)) {
            return 3;
        }
        if ("Lancer".equals(clazz)) {
            return 4;
        }
        if ("Rider".equals(clazz)) {
            return 5;
        }
        if ("Caster".equals(clazz)) {
            return 6;
        }
        if ("Assassin".equals(clazz)) {
            return 7;
        }
        if ("Berserker".equals(clazz)) {
            return 8;
        }
        if ("Ruler".equals(clazz)) {
            return 9;
        }
        if ("Avenger".equals(clazz)) {
            return 10;
        }
        if ("Alterego".equals(clazz)) {
            return 11;
        }
        if ("MoonCancer".equals(clazz)) {
            return 12;
        }
        if (StringUtils.isNotBlank(clazz) && clazz.startsWith("Beast")) {
            return 13;
        }
        return null;
    }
}

