package com.github.fgowiki.spider.model;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author jiang
 * @create 2017-11-27 21:08
 **/
@Entity
@Table(name = "fgo_servant")
public class FgoServant {
    @Id
    private Integer id;
    @Column(name = "name_zh")
    private String nameZh;
    @Column(name = "name_en")
    private String nameEn;
    @Column(name = "name_jp")
    private String nameJp;
    @Column(name = "class")
    private Integer clazz;
    private Integer camp;
    private Integer star;
    @Column(name = "atk_stage0")
    private Integer atkStage0;
    @Column(name = "hp_stage0")
    private Integer hpStage0;
    private String cards;
    @Column(name = "atk_stage4")
    private Integer atkStage4;
    @Column(name = "hp_stage4")
    private Integer hpStage4;
    @Column(name = "atk_lv_90")
    private Integer atkLv90;
    @Column(name = "hp_lv_90")
    private Integer hpLv90;
    @Column(name = "atk_lv_100")
    private Integer atkLv100;
    @Column(name = "hp_lv_100")
    private Integer hpLv100;
    @Column(name = "art_hit")
    private Integer artHit;
    @Column(name = "buster_hit")
    private Integer busterHit;
    @Column(name = "quick_hit")
    private Integer quickHit;
    @Column(name = "etxtra_hit")
    private Integer etxtraHit;
    private String painter;
    private String cv;
    private String attributes;
    private Integer gender;
    private String region;
    private Integer height;
    private Integer weight;
    @Column(name = "crit_star")
    private BigDecimal critStar;
    private Integer crit;
    @Column(name = "np_rate_art")
    private BigDecimal npRateArt;
    @Column(name = "np_rate_buster")
    private BigDecimal npRateBuster;
    @Column(name = "np_rate_quick")
    private BigDecimal npRateQuick;
    @Column(name = "np_rate_extra")
    private BigDecimal npRateExtra;
    private String origin;
    @Column(name = "np_rate_attacked")
    private BigDecimal npRateAttacked;
    private String nickname;

    @Basic
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic

    public String getNameZh() {
        return nameZh;
    }

    public void setNameZh(String nameZh) {
        this.nameZh = nameZh;
    }

    @Basic

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameUs) {
        this.nameEn = nameUs;
    }

    @Basic

    public String getNameJp() {
        return nameJp;
    }

    public void setNameJp(String nameJp) {
        this.nameJp = nameJp;
    }

    @Basic
    public Integer getClazz() {
        return clazz;
    }

    public void setClazz(Integer clazz) {
        this.clazz = clazz;
    }

    @Basic
    public Integer getCamp() {
        return camp;
    }

    public void setCamp(Integer camp) {
        this.camp = camp;
    }

    @Basic
    @Column(name = "star")
    public Integer getStar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
    }

    @Basic

    public Integer getAtkStage0() {
        return atkStage0;
    }

    public void setAtkStage0(Integer atkStage0) {
        this.atkStage0 = atkStage0;
    }

    @Basic

    public Integer getHpStage0() {
        return hpStage0;
    }

    public void setHpStage0(Integer hpStage0) {
        this.hpStage0 = hpStage0;
    }

    @Basic
    public String getCards() {
        return cards;
    }

    public void setCards(String cards) {
        this.cards = cards;
    }

    @Basic

    public Integer getAtkStage4() {
        return atkStage4;
    }

    public void setAtkStage4(Integer atkStage4) {
        this.atkStage4 = atkStage4;
    }

    @Basic

    public Integer getHpStage4() {
        return hpStage4;
    }

    public void setHpStage4(Integer hpStage4) {
        this.hpStage4 = hpStage4;
    }

    @Basic

    public Integer getAtkLv90() {
        return atkLv90;
    }

    public void setAtkLv90(Integer atkLv90) {
        this.atkLv90 = atkLv90;
    }

    @Basic

    public Integer getHpLv90() {
        return hpLv90;
    }

    public void setHpLv90(Integer hpLv90) {
        this.hpLv90 = hpLv90;
    }

    @Basic

    public Integer getAtkLv100() {
        return atkLv100;
    }

    public void setAtkLv100(Integer atkLv100) {
        this.atkLv100 = atkLv100;
    }

    @Basic

    public Integer getHpLv100() {
        return hpLv100;
    }

    public void setHpLv100(Integer hpLv100) {
        this.hpLv100 = hpLv100;
    }

    public Integer getArtHit() {
        return artHit;
    }

    public void setArtHit(Integer artHit) {
        this.artHit = artHit;
    }

    @Basic

    public Integer getBusterHit() {
        return busterHit;
    }

    public void setBusterHit(Integer busterHit) {
        this.busterHit = busterHit;
    }

    @Basic
    public Integer getQuickHit() {
        return quickHit;
    }

    public void setQuickHit(Integer quickHit) {
        this.quickHit = quickHit;
    }

    @Basic

    public Integer getEtxtraHit() {
        return etxtraHit;
    }

    public void setEtxtraHit(Integer etxtraHit) {
        this.etxtraHit = etxtraHit;
    }

    @Basic
    public String getPainter() {
        return painter;
    }

    public void setPainter(String painter) {
        this.painter = painter;
    }

    @Basic
    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    @Basic
    public String getAttributes() {
        return attributes;
    }

    public void setAttributes(String attributes) {
        this.attributes = attributes;
    }

    @Basic
    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    @Basic
    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Basic
    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    @Basic
    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Basic

    public BigDecimal getCritStar() {
        return critStar;
    }

    public void setCritStar(BigDecimal critStar) {
        this.critStar = critStar;
    }

    @Basic
    public Integer getCrit() {
        return crit;
    }

    public void setCrit(Integer crit) {
        this.crit = crit;
    }

    @Basic

    public BigDecimal getNpRateArt() {
        return npRateArt;
    }

    public void setNpRateArt(BigDecimal npRateArt) {
        this.npRateArt = npRateArt;
    }

    @Basic

    public BigDecimal getNpRateBuster() {
        return npRateBuster;
    }

    public void setNpRateBuster(BigDecimal npRateBuster) {
        this.npRateBuster = npRateBuster;
    }

    @Basic

    public BigDecimal getNpRateQuick() {
        return npRateQuick;
    }

    public void setNpRateQuick(BigDecimal npRateQuick) {
        this.npRateQuick = npRateQuick;
    }

    @Basic

    public BigDecimal getNpRateExtra() {
        return npRateExtra;
    }

    public void setNpRateExtra(BigDecimal npRateExtra) {
        this.npRateExtra = npRateExtra;
    }

    @Basic
    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    @Basic

    public BigDecimal getNpRateAttacked() {
        return npRateAttacked;
    }

    public void setNpRateAttacked(BigDecimal npRateAttacked) {
        this.npRateAttacked = npRateAttacked;
    }

    @Basic
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

}
