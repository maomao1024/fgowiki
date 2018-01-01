package com.github.fgowiki.api.entity;

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
public class FgoServant {
    @Id
    private Integer id;
    private String nameZh;
    private String nameEn;
    private String nameJp;
    private String nickname;
    @OneToOne
    @JoinColumn(name="CLASS")
    private FgoClass clazz;
    private Integer star;
    private Integer camp;
    private Integer atkStage0;
    private Integer hpStage0;
    private String cards;
    private Integer atkStage4;
    private Integer hpStage4;
    private Integer atkLv90;
    private Integer hpLv90;
    private Integer atkLv100;
    private Integer hpLv100;
    private Integer artHit;
    private Integer busterHit;
    private Integer quickHit;
    private Integer extraHit;
    private Integer crit;
    private Integer critStar;
    private Double npRateArt;
    private Double npRateBuster;
    private Double npRateQuick;
    private Double npRateExtra;
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
