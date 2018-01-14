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
@Table(name = "FGO_SERVANT_STORY")
public class FgoServantStory {
	private String id;
	private Integer servantId;
	private Integer sid;
	private String name;
	private String description;

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
	@Column(name = "SID")
	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
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
	@Column(name = "DESCRIPTION")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		FgoServantStory that = (FgoServantStory) o;
		return Objects.equals(id, that.id) &&
				Objects.equals(servantId, that.servantId) &&
				Objects.equals(sid, that.sid) &&
				Objects.equals(name, that.name) &&
				Objects.equals(description, that.description);
	}

	@Override
	public int hashCode() {

		return Objects.hash(id, servantId, sid, name, description);
	}
}
