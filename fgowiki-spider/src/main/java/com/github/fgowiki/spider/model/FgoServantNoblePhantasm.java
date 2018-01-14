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
@Table(name = "FGO_SERVANT_NOBLE_PHANTASM")
public class FgoServantNoblePhantasm {
	private String id;
	private Integer servantId;
	private String name;
	private String nameEn;
	private String level;
	private String infoId;

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
	@Column(name = "NAME_EN")
	public String getNameEn() {
		return nameEn;
	}

	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}

	@Basic
	@Column(name = "LEVEL")
	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	@Basic
	@Column(name = "INFO_ID")
	public String getInfoId() {
		return infoId;
	}

	public void setInfoId(String infoId) {
		this.infoId = infoId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		FgoServantNoblePhantasm that = (FgoServantNoblePhantasm) o;
		return Objects.equals(id, that.id) &&
				Objects.equals(servantId, that.servantId) &&
				Objects.equals(name, that.name) &&
				Objects.equals(nameEn, that.nameEn) &&
				Objects.equals(level, that.level) &&
				Objects.equals(infoId, that.infoId);
	}

	@Override
	public int hashCode() {

		return Objects.hash(id, servantId, name, nameEn, level, infoId);
	}
}
