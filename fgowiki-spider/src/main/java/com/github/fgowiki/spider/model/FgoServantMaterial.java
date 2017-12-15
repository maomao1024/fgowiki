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
@Table(name = "FGO_SERVANT_MATERIAL")
public class FgoServantMaterial {
	private Integer servantId;
	private String id;
	private Integer sid;
	private String materialId;
	private Integer level;
	private Integer count;
	private Integer qp;
	private Integer type;

	@Basic
	@Column(name = "SERVANT_ID")
	public Integer getServantId() {
		return servantId;
	}

	public void setServantId(Integer servantId) {
		this.servantId = servantId;
	}

	@Id
	@Column(name = "ID")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Basic
	@Column(name = "SID")
	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	@Basic
	@Column(name = "MATERIAL_ID")
	public String getMaterialId() {
		return materialId;
	}

	public void setMaterialId(String materialId) {
		this.materialId = materialId;
	}

	@Basic
	@Column(name = "LEVEL")
	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	@Basic
	@Column(name = "COUNT")
	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@Basic
	@Column(name = "QP")
	public Integer getQp() {
		return qp;
	}

	public void setQp(Integer qp) {
		this.qp = qp;
	}

	@Basic
	@Column(name = "TYPE")
	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		FgoServantMaterial that = (FgoServantMaterial) o;
		return Objects.equals(servantId, that.servantId) &&
				Objects.equals(id, that.id) &&
				Objects.equals(sid, that.sid) &&
				Objects.equals(materialId, that.materialId) &&
				Objects.equals(level, that.level) &&
				Objects.equals(count, that.count) &&
				Objects.equals(qp, that.qp) &&
				Objects.equals(type, that.type);
	}

	@Override
	public int hashCode() {

		return Objects.hash(servantId, id, sid, materialId, level, count, qp, type);
	}
}
