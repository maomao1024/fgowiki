package com.github.fgowiki.spider.utils;

/**
 * 阶职枚举
 *
 * @author jiang
 * @create 2017-11-27 22:58
 **/
public enum FgoClazz {

    Shielder("盾", "Shielder", 1),
    Saber("剑", "Saber", 2),
    Archer("弓", "Archer", 3),
    Lancer("枪", "Lancer", 4),
    Rider("骑", "Rider", 5),
    Caster("术", "Caster", 6),
    Assassin("杀", "Assassin", 7),
    Berserker("狂", "Berserker", 8),
    Ruler("裁定", "Ruler", 9),
    Avenger("复仇者", "Avenger", 10),
    AlterEgo("小丑", "Alterego", 11),
    MoonCancer("月蚀", "Moon Cancer", 12),
    Beast("兽", "Beast", 13);

    private String name;
    private String nameEn;
    private int id;

    private FgoClazz(String name, String nameEn, int id) {
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

    public static FgoClazz getClazz(String clazz){
        for (FgoClazz fgoClazz : FgoClazz.values()) {
            if(fgoClazz.getNameEn().equals(clazz)){
                return fgoClazz;
            }
        }
        return null;
    }
}
