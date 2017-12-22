package com.github.fgowiki.api.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * 功能描述：
 *
 * @author 蒋经
 * @version 1.0
 * @since 2017/12/22
 */
@Entity
@Data
@Table(name = "FGO_SERVANT")
@SuppressWarnings("unused")
public class FgoServant {
    @Id
    private Integer id;
    @Column(name = "NAME_ZH")
    private String nameZh;
    @Column(name = "NAME_EN")
    private String nameEn;
    @Column(name = "NAME_JP")
    private String nameJp;
    private String nickname;
    @Column(name = "CLASS")
    private Integer clazz;
    private Integer star;
    private Integer camp;
    @Column(name = "ATK_STAGE0")
    private Integer atkStage0;
    @Column(name = "HP_STAGE0")
    private Integer hpStage0;
    private String cards;
    @Column(name = "ATK_STAGE4")
    private Integer atkStage4;
    @Column(name = "HP_STAGE4")
    private Integer hpStage4;
    @Column(name = "ATK_LV_90")
    private Integer atkLv90;
    @Column(name = "HP_LV_90")
    private Integer hpLv90;
    @Column(name = "ATK_LV_100")
    private Integer atkLv100;
    @Column(name = "HP_LV_100")
    private Integer hpLv100;
    @Column(name = "ART_HIT")
    private Integer artHit;
    @Column(name = "BUSTER_HIT")
    private Integer busterHit;
    @Column(name = "QUICK_HIT")
    private Integer quickHit;
    @Column(name = "EXTRA_HIT")
    private Integer extraHit;
    private Integer crit;
    @Column(name = "CRIT_STAR")
    private Integer critStar;
    @Column(name = "NP_RATE_ART")
    private Double npRateArt;
    @Column(name = "NP_RATE_BUSTER")
    private Double npRateBuster;
    @Column(name = "NP_RATE_QUICK")
    private Double npRateQuick;
    @Column(name = "NP_RATE_EXTRA")
    private Double npRateExtra;
    @Column(name = "NP_RATE_ATTACKED")
    private Double npRateAttacked;

    private Integer gender;
    private String region;
    private String attributes;
    private String painter;
    private String cv;
    private Integer height;
    private Integer weight;
    private String origin;

}
