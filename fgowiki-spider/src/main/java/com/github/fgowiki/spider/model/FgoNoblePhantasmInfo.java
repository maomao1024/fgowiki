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
@Table(name = "FGO_NOBLE_PHANTASM_INFO")
public class FgoNoblePhantasmInfo {
	private String id;
	private String skillId;
	private String description;
	private Integer stage1;
	private Integer stage2;
	private Integer stage3;
	private Integer stage4;
	private Integer stage5;
	private Integer type;

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
	@Column(name = "STAGE1")
	public Integer getStage1() {
		return stage1;
	}

	public void setStage1(Integer stage1) {
		this.stage1 = stage1;
	}

	@Basic
	@Column(name = "STAGE2")
	public Integer getStage2() {
		return stage2;
	}

	public void setStage2(Integer stage2) {
		this.stage2 = stage2;
	}

	@Basic
	@Column(name = "STAGE3")
	public Integer getStage3() {
		return stage3;
	}

	public void setStage3(Integer stage3) {
		this.stage3 = stage3;
	}

	@Basic
	@Column(name = "STAGE4")
	public Integer getStage4() {
		return stage4;
	}

	public void setStage4(Integer stage4) {
		this.stage4 = stage4;
	}

	@Basic
	@Column(name = "STAGE5")
	public Integer getStage5() {
		return stage5;
	}

	public void setStage5(Integer stage5) {
		this.stage5 = stage5;
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
		FgoNoblePhantasmInfo that = (FgoNoblePhantasmInfo) o;
		return Objects.equals(id, that.id) &&
				Objects.equals(skillId, that.skillId) &&
				Objects.equals(description, that.description) &&
				Objects.equals(stage1, that.stage1) &&
				Objects.equals(stage2, that.stage2) &&
				Objects.equals(stage3, that.stage3) &&
				Objects.equals(stage4, that.stage4) &&
				Objects.equals(stage5, that.stage5) &&
				Objects.equals(type, that.type);
	}

	@Override
	public int hashCode() {

		return Objects.hash(id, skillId, description, stage1, stage2, stage3, stage4, stage5, type);
	}
}
