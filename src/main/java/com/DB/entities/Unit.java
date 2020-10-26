package com.DB.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "unit_Details")
public class Unit {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="unit_Id")
	private int unit_Id;
	
	@Column(name = "unit_Name")
	private String unitName;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "unitPatient")
	private List<Ward> wardList = new ArrayList();

	public int getUnit_Id() {
		return unit_Id;
	}

	public void setUnit_Id(int unit_Id) {
		this.unit_Id = unit_Id;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public List<Ward> getWardList() {
		return wardList;
	}

	public void setWardList(List<Ward> wardList) {
		this.wardList = wardList;
	}

	@Override
	public String toString() {
		return "Unit [unit_Id=" + unit_Id + ", unitName=" + unitName + ", wardList=" + wardList + "]";
	}
	
	

}
