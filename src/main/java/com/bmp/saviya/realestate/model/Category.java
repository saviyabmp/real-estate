package com.bmp.saviya.realestate.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "category")
@NamedQuery(name = "Category.findAll", query = "SELECT p FROM Category p")
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	@Column(name = "display_name")
	private String displayName;

	private String code;

	private Integer status = 0;

	private String description;

	// @OneToMany(mappedBy = "Category")
	// private List<Business> business;

	public Category() {
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	/*
	 * public List<Business> getBusiness() { return business; }
	 * 
	 * public void setBusiness(List<Business> business) { this.business = business;
	 * }
	 */

	/*
	 * public Business addBusiness(Business business) { getBusiness().add(business);
	 * business.setCategory(this); return business; }
	 * 
	 * public Business removeBusiness(Business business) {
	 * getBusiness().remove(business); business.setCategory(null); return business;
	 * }
	 */

}