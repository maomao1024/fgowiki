package com.github.fgowiki.web.domain;

import java.math.BigDecimal;

public class FgoServant {
    private Integer id;

    private String nameZh;

    private String nameEn;

    private String nameJp;

    private Integer clazz;

    private Integer camp;

    private Integer star;

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

    private Integer etxtraHit;

    private String painter;

    private String cv;

    private String attributes;

    private Integer gender;

    private String region;

    private Integer height;

    private Integer weight;

    private BigDecimal critStar;

    private Integer crit;

    private BigDecimal npRateArt;

    private BigDecimal npRateBuster;

    private BigDecimal npRateQuick;

    private BigDecimal npRateExtra;

    private String origin;

    private BigDecimal npRateAttacked;

    private String nickname;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameZh() {
        return nameZh;
    }

    public void setNameZh(String nameZh) {
        this.nameZh = nameZh == null ? null : nameZh.trim();
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn == null ? null : nameEn.trim();
    }

    public String getNameJp() {
        return nameJp;
    }

    public void setNameJp(String nameJp) {
        this.nameJp = nameJp == null ? null : nameJp.trim();
    }

    public Integer getClazz() {
        return clazz;
    }

    public void setClazz(Integer clazz) {
        this.clazz = clazz;
    }

    public Integer getCamp() {
        return camp;
    }

    public void setCamp(Integer camp) {
        this.camp = camp;
    }

    public Integer getStar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
    }

    public Integer getAtkStage0() {
        return atkStage0;
    }

    public void setAtkStage0(Integer atkStage0) {
        this.atkStage0 = atkStage0;
    }

    public Integer getHpStage0() {
        return hpStage0;
    }

    public void setHpStage0(Integer hpStage0) {
        this.hpStage0 = hpStage0;
    }

    public String getCards() {
        return cards;
    }

    public void setCards(String cards) {
        this.cards = cards == null ? null : cards.trim();
    }

    public Integer getAtkStage4() {
        return atkStage4;
    }

    public void setAtkStage4(Integer atkStage4) {
        this.atkStage4 = atkStage4;
    }

    public Integer getHpStage4() {
        return hpStage4;
    }

    public void setHpStage4(Integer hpStage4) {
        this.hpStage4 = hpStage4;
    }

    public Integer getAtkLv90() {
        return atkLv90;
    }

    public void setAtkLv90(Integer atkLv90) {
        this.atkLv90 = atkLv90;
    }

    public Integer getHpLv90() {
        return hpLv90;
    }

    public void setHpLv90(Integer hpLv90) {
        this.hpLv90 = hpLv90;
    }

    public Integer getAtkLv100() {
        return atkLv100;
    }

    public void setAtkLv100(Integer atkLv100) {
        this.atkLv100 = atkLv100;
    }

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

    public Integer getBusterHit() {
        return busterHit;
    }

    public void setBusterHit(Integer busterHit) {
        this.busterHit = busterHit;
    }

    public Integer getQuickHit() {
        return quickHit;
    }

    public void setQuickHit(Integer quickHit) {
        this.quickHit = quickHit;
    }

    public Integer getEtxtraHit() {
        return etxtraHit;
    }

    public void setEtxtraHit(Integer etxtraHit) {
        this.etxtraHit = etxtraHit;
    }

    public String getPainter() {
        return painter;
    }

    public void setPainter(String painter) {
        this.painter = painter == null ? null : painter.trim();
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv == null ? null : cv.trim();
    }

    public String getAttributes() {
        return attributes;
    }

    public void setAttributes(String attributes) {
        this.attributes = attributes == null ? null : attributes.trim();
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region == null ? null : region.trim();
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public BigDecimal getCritStar() {
        return critStar;
    }

    public void setCritStar(BigDecimal critStar) {
        this.critStar = critStar;
    }

    public Integer getCrit() {
        return crit;
    }

    public void setCrit(Integer crit) {
        this.crit = crit;
    }

    public BigDecimal getNpRateArt() {
        return npRateArt;
    }

    public void setNpRateArt(BigDecimal npRateArt) {
        this.npRateArt = npRateArt;
    }

    public BigDecimal getNpRateBuster() {
        return npRateBuster;
    }

    public void setNpRateBuster(BigDecimal npRateBuster) {
        this.npRateBuster = npRateBuster;
    }

    public BigDecimal getNpRateQuick() {
        return npRateQuick;
    }

    public void setNpRateQuick(BigDecimal npRateQuick) {
        this.npRateQuick = npRateQuick;
    }

    public BigDecimal getNpRateExtra() {
        return npRateExtra;
    }

    public void setNpRateExtra(BigDecimal npRateExtra) {
        this.npRateExtra = npRateExtra;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin == null ? null : origin.trim();
    }

    public BigDecimal getNpRateAttacked() {
        return npRateAttacked;
    }

    public void setNpRateAttacked(BigDecimal npRateAttacked) {
        this.npRateAttacked = npRateAttacked;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }
}