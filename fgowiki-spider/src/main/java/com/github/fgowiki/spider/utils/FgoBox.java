package com.github.fgowiki.spider.utils;

/**
 * 箱子类型
 *
 * @author jiang
 * @create 2017-11-27 22:58
 **/
public enum FgoBox {

    Gold("金", "Gold", 1),
    Silver("银", "Silver", 2),
    Copper("铜", "Copper", 3);

    private String name;
    private String nameEn;
    private int id;

    FgoBox(String name, String nameEn, int id) {
        this.name = name;
        this.nameEn = nameEn;
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

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public static Integer getBoxType(String boxName){
        for (FgoBox fgoBox : FgoBox.values()) {
            if(fgoBox.getNameEn().equals(boxName)){
                return fgoBox.id;
            }
        }
        return null;
    }
}
