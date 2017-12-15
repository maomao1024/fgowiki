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
@Table(name = "FGO_SKILL_INFO")
public class FgoSkillInfo {
	private String id;
	private String skillId;
	private String description;
	private Integer value;
	private Integer growth;

	@Id
	@Column(name = "ID")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Basic
	@Column(name = "SKILL_ID")
	public String getSkillId() {
		return skillId;
	}

	public void setSkillId(String skillId) {
		this.skillId = skillId;
	}

	@Basic
	@Column(name = "DESCRIPTION")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Basic
	@Column(name = "VALUE")
	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	@Basic
	@Column(name = "GROWTH")
	public Integer getGrowth() {
		return growth;
	}

	public void setGrowth(Integer growth) {
		this.growth = growth;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		FgoSkillInfo that = (FgoSkillInfo) o;
		return Objects.equals(id, that.id) &&
				Objects.equals(skillId, that.skillId) &&
				Objects.equals(description, that.description) &&
				Objects.equals(value, that.value) &&
				Objects.equals(growth, that.growth);
	}

	@Override
	public int hashCode() {

		return Objects.hash(id, skillId, description, value, growth);
	}
}
