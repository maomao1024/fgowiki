package com.github.fgowiki.spider.utils;

/**
 * 阶职枚举
 *
 * @author jiang
 * @create 2017-11-27 22:58
 **/
public enum FgoClazz {

    /*
     1	盾	Shielder
     2	剑	Saber
     3	弓	Archer
     4	枪	Lancer
     5	骑	Rider
     6	术	Caster
     7	杀	Assassin
     8	狂	Berserker
     9	裁定	Ruler
     10	复仇者	Avenger
     11	冠位魔术师	Grand Caster
     12	小丑	Alterego
     13	月蚀	Moon Cancer
     14	兽	Beast
     15	异域者	Foreigner

     */

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
    GrandCaster("冠位魔术师", "Grand Caster", 11),
    AlterEgo("小丑", "Alterego", 12),
    MoonCancer("月蚀", "MoonCancer", 13),
    Beast("兽", "Beast", 14),
    Foreigner("异域者", "Foreigner", 15);

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
        if (clazz.contains("Beast")){
            return Beast;
        }
        return null;
    }
}
