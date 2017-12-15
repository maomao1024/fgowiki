package com.github.fgowiki.spider.model;

import javax.persistence.*;
import java.util.Objects;

/**
 * 功能描述：
 *
 * @author 蒋经
 * @version 1.0
 * @since 2017/12/15
 */
@Entity
@Table(name = "FGO_SERVANT")
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
	private Integer critStar;
	private Integer crit;
	private Integer npRateArt;
	private Integer npRateBuster;
	private Integer npRateQuick;
	private Integer npRateExtra;
	private String origin;
	private Integer npRateAttacked;
	private String nickname;

	@Id
	@Column(name = "ID")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Basic
	@Column(name = "NAME_ZH")
	public String getNameZh() {
		return nameZh;
	}

	public void setNameZh(String nameZh) {
		this.nameZh = nameZh;
	}

	@Basic
	@Column(name = "NAME_EN")
	public String getNameEn() {
		return nameEn;
	}

	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}

	@Basic
	@Column(name = "NAME_JP")
	public String getNameJp() {
		return nameJp;
	}

	public void setNameJp(String nameJp) {
		this.nameJp = nameJp;
	}

	@Basic
	@Column(name = "CLASS")
	public Integer getClazz() {
		return clazz;
	}

	public void setClazz(Integer clazz) {
		this.clazz = clazz;
	}

	@Basic
	@Column(name = "CAMP")
	public Integer getCamp() {
		return camp;
	}

	public void setCamp(Integer camp) {
		this.camp = camp;
	}

	@Basic
	@Column(name = "STAR")
	public Integer getStar() {
		return star;
	}

	public void setStar(Integer star) {
		this.star = star;
	}

	@Basic
	@Column(name = "ATK_STAGE0")
	public Integer getAtkStage0() {
		return atkStage0;
	}

	public void setAtkStage0(Integer atkStage0) {
		this.atkStage0 = atkStage0;
	}

	@Basic
	@Column(name = "HP_STAGE0")
	public Integer getHpStage0() {
		return hpStage0;
	}

	public void setHpStage0(Integer hpStage0) {
		this.hpStage0 = hpStage0;
	}

	@Basic
	@Column(name = "CARDS")
	public String getCards() {
		return cards;
	}

	public void setCards(String cards) {
		this.cards = cards;
	}

	@Basic
	@Column(name = "ATK_STAGE4")
	public Integer getAtkStage4() {
		return atkStage4;
	}

	public void setAtkStage4(Integer atkStage4) {
		this.atkStage4 = atkStage4;
	}

	@Basic
	@Column(name = "HP_STAGE4")
	public Integer getHpStage4() {
		return hpStage4;
	}

	public void setHpStage4(Integer hpStage4) {
		this.hpStage4 = hpStage4;
	}

	@Basic
	@Column(name = "ATK_LV_90")
	public Integer getAtkLv90() {
		return atkLv90;
	}

	public void setAtkLv90(Integer atkLv90) {
		this.atkLv90 = atkLv90;
	}

	@Basic
	@Column(name = "HP_LV_90")
	public Integer getHpLv90() {
		return hpLv90;
	}

	public void setHpLv90(Integer hpLv90) {
		this.hpLv90 = hpLv90;
	}

	@Basic
	@Column(name = "ATK_LV_100")
	public Integer getAtkLv100() {
		return atkLv100;
	}

	public void setAtkLv100(Integer atkLv100) {
		this.atkLv100 = atkLv100;
	}

	@Basic
	@Column(name = "HP_LV_100")
	public Integer getHpLv100() {
		return hpLv100;
	}

	public void setHpLv100(Integer hpLv100) {
		this.hpLv100 = hpLv100;
	}

	@Basic
	@Column(name = "ART_HIT")
	public Integer getArtHit() {
		return artHit;
	}

	public void setArtHit(Integer artHit) {
		this.artHit = artHit;
	}

	@Basic
	@Column(name = "BUSTER_HIT")
	public Integer getBusterHit() {
		return busterHit;
	}

	public void setBusterHit(Integer busterHit) {
		this.busterHit = busterHit;
	}

	@Basic
	@Column(name = "QUICK_HIT")
	public Integer getQuickHit() {
		return quickHit;
	}

	public void setQuickHit(Integer quickHit) {
		this.quickHit = quickHit;
	}

	@Basic
	@Column(name = "ETXTRA_HIT")
	public Integer getEtxtraHit() {
		return etxtraHit;
	}

	public void setEtxtraHit(Integer etxtraHit) {
		this.etxtraHit = etxtraHit;
	}

	@Basic
	@Column(name = "PAINTER")
	public String getPainter() {
		return painter;
	}

	public void setPainter(String painter) {
		this.painter = painter;
	}

	@Basic
	@Column(name = "CV")
	public String getCv() {
		return cv;
	}

	public void setCv(String cv) {
		this.cv = cv;
	}

	@Basic
	@Column(name = "ATTRIBUTES")
	public String getAttributes() {
		return attributes;
	}

	public void setAttributes(String attributes) {
		this.attributes = attributes;
	}

	@Basic
	@Column(name = "GENDER")
	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	@Basic
	@Column(name = "REGION")
	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	@Basic
	@Column(name = "HEIGHT")
	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	@Basic
	@Column(name = "WEIGHT")
	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	@Basic
	@Column(name = "CRIT_STAR")
	public Integer getCritStar() {
		return critStar;
	}

	public void setCritStar(Integer critStar) {
		this.critStar = critStar;
	}

	@Basic
	@Column(name = "CRIT")
	public Integer getCrit() {
		return crit;
	}

	public void setCrit(Integer crit) {
		this.crit = crit;
	}

	@Basic
	@Column(name = "NP_RATE_ART")
	public Integer getNpRateArt() {
		return npRateArt;
	}

	public void setNpRateArt(Integer npRateArt) {
		this.npRateArt = npRateArt;
	}

	@Basic
	@Column(name = "NP_RATE_BUSTER")
	public Integer getNpRateBuster() {
		return npRateBuster;
	}

	public void setNpRateBuster(Integer npRateBuster) {
		this.npRateBuster = npRateBuster;
	}

	@Basic
	@Column(name = "NP_RATE_QUICK")
	public Integer getNpRateQuick() {
		return npRateQuick;
	}

	public void setNpRateQuick(Integer npRateQuick) {
		this.npRateQuick = npRateQuick;
	}

	@Basic
	@Column(name = "NP_RATE_EXTRA")
	public Integer getNpRateExtra() {
		return npRateExtra;
	}

	public void setNpRateExtra(Integer npRateExtra) {
		this.npRateExtra = npRateExtra;
	}

	@Basic
	@Column(name = "ORIGIN")
	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	@Basic
	@Column(name = "NP_RATE_ATTACKED")
	public Integer getNpRateAttacked() {
		return npRateAttacked;
	}

	public void setNpRateAttacked(Integer npRateAttacked) {
		this.npRateAttacked = npRateAttacked;
	}

	@Basic
	@Column(name = "NICKNAME")
	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		FgoServant that = (FgoServant) o;
		return id == that.id &&
				Objects.equals(nameZh, that.nameZh) &&
				Objects.equals(nameEn, that.nameEn) &&
				Objects.equals(nameJp, that.nameJp) &&
				Objects.equals(clazz, that.clazz) &&
				Objects.equals(camp, that.camp) &&
				Objects.equals(star, that.star) &&
				Objects.equals(atkStage0, that.atkStage0) &&
				Objects.equals(hpStage0, that.hpStage0) &&
				Objects.equals(cards, that.cards) &&
				Objects.equals(atkStage4, that.atkStage4) &&
				Objects.equals(hpStage4, that.hpStage4) &&
				Objects.equals(atkLv90, that.atkLv90) &&
				Objects.equals(hpLv90, that.hpLv90) &&
				Objects.equals(atkLv100, that.atkLv100) &&
				Objects.equals(hpLv100, that.hpLv100) &&
				Objects.equals(artHit, that.artHit) &&
				Objects.equals(busterHit, that.busterHit) &&
				Objects.equals(quickHit, that.quickHit) &&
				Objects.equals(etxtraHit, that.etxtraHit) &&
				Objects.equals(painter, that.painter) &&
				Objects.equals(cv, that.cv) &&
				Objects.equals(attributes, that.attributes) &&
				Objects.equals(gender, that.gender) &&
				Objects.equals(region, that.region) &&
				Objects.equals(height, that.height) &&
				Objects.equals(weight, that.weight) &&
				Objects.equals(critStar, that.critStar) &&
				Objects.equals(crit, that.crit) &&
				Objects.equals(npRateArt, that.npRateArt) &&
				Objects.equals(npRateBuster, that.npRateBuster) &&
				Objects.equals(npRateQuick, that.npRateQuick) &&
				Objects.equals(npRateExtra, that.npRateExtra) &&
				Objects.equals(origin, that.origin) &&
				Objects.equals(npRateAttacked, that.npRateAttacked) &&
				Objects.equals(nickname, that.nickname);
	}

	@Override
	public int hashCode() {

		return Objects.hash(id, nameZh, nameEn, nameJp, clazz, camp, star, atkStage0, hpStage0, cards, atkStage4, hpStage4, atkLv90, hpLv90, atkLv100, hpLv100, artHit, busterHit, quickHit, etxtraHit, painter, cv, attributes, gender, region, height, weight, critStar, crit, npRateArt, npRateBuster, npRateQuick, npRateExtra, origin, npRateAttacked, nickname);
	}
}
