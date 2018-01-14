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
@Table(name = "FGO_SERVANT_CLASS_SKILL")
public class FgoServantClassSkill {
	private String id;
	private Integer servantId;
	private String name;
	private String lv;
	private String infoId;
	private Integer sid;

	@Id
	@Column(name = "ID")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Basic
	@Column(name = "SERVANT_ID")
	public Integer getServantId() {
		return servantId;
	}

	public void setServantId(Integer servantId) {
		this.servantId = servantId;
	}

	@Basic
	@Column(name = "NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Basic
	@Column(name = "LV")
	public String getLv() {
		return lv;
	}

	public void setLv(String lv) {
		this.lv = lv;
	}

	@Basic
	@Column(name = "INFO_ID")
	public String getInfoId() {
		return infoId;
	}

	public void setInfoId(String infoId) {
		this.infoId = infoId;
	}

	@Basic
	@Column(name = "SID")
	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		FgoServantClassSkill that = (FgoServantClassSkill) o;
		return Objects.equals(id, that.id) &&
				Objects.equals(servantId, that.servantId) &&
				Objects.equals(name, that.name) &&
				Objects.equals(lv, that.lv) &&
				Objects.equals(infoId, that.infoId) &&
				Objects.equals(sid, that.sid);
	}

	@Override
	public int hashCode() {

		return Objects.hash(id, servantId, name, lv, infoId, sid);
	}
}
