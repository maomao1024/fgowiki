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
@Table(name = "FGO_MATERIAL")
public class FgoMaterial {
	private Integer id;
	private String name;
	private Integer type;
	private Integer box;
	private String description;
	private String location;

	@Id
	@Column(name = "ID")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
	@Column(name = "TYPE")
	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	@Basic
	@Column(name = "BOX")
	public Integer getBox() {
		return box;
	}

	public void setBox(Integer box) {
		this.box = box;
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
	@Column(name = "LOCATION")
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		FgoMaterial that = (FgoMaterial) o;
		return Objects.equals(id, that.id) &&
				Objects.equals(name, that.name) &&
				Objects.equals(type, that.type) &&
				Objects.equals(box, that.box) &&
				Objects.equals(description, that.description) &&
				Objects.equals(location, that.location);
	}

	@Override
	public int hashCode() {

		return Objects.hash(id, name, type, box, description, location);
	}
}
