package com.github.fgowiki.spider.utils;

/**
 * 阵营
 *
 * @author jiang
 * @create 2017-11-27 22:58
 **/
public enum FgoCamp {
	other("其他",  0),
    tian("天",  1),
    di("地",  2),
    ren("人", 3),
	xin("星",  4),
	shou("兽",  5);
    private String name;
    private int id;

    FgoCamp(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public static Integer getCamp(String campName){
        for (FgoCamp fgoCamp : FgoCamp.values()) {
            if(fgoCamp.getName().equals(campName)){
                return fgoCamp.id;
            }
        }
        return FgoCamp.getCamp("其他");
    }
}
