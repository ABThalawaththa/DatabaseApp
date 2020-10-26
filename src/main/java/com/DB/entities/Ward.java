package com.DB.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ward_Details")
public class Ward {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ward_Id")
	private int ward_Id;
	
	@Column(name = "ward_No")
	private String wardNumber;
	
	@Column(name ="max_Patients")
	private int maxPatientsAllowed;
	
	@Column(name = "occupied_Beds")
	private int occupiedBeds;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "wardPatient")
	private List<Patient> patientList = new ArrayList();

	
	@ManyToOne
	@JoinColumn(name="unit_Id")
	private Unit unitPatient;
	
	@Override
	public String toString() {
		return "Ward [ward_Id=" + ward_Id + ", wardNumber=" + wardNumber + ", maxPatientsAllowed=" + maxPatientsAllowed
				+ ", occupiedBeds=" + occupiedBeds + ", patientList=" + patientList + ", unitPatient=" + unitPatient
				+ "]";
	}

	public Unit getUnitPatient() {
		return unitPatient;
	}

	public void setUnitPatient(Unit unitPatient) {
		this.unitPatient = unitPatient;
	}

	public int getWard_Id() {
		return ward_Id;
	}

	public void setWard_Id(int ward_Id) {
		this.ward_Id = ward_Id;
	}

	public String getWardNumber() {
		return wardNumber;
	}

	public void setWardNumber(String wardNumber) {
		this.wardNumber = wardNumber;
	}

	public int getMaxPatientsAllowed() {
		return maxPatientsAllowed;
	}

	public void setMaxPatientsAllowed(int maxPatientsAllowed) {
		this.maxPatientsAllowed = maxPatientsAllowed;
	}

	public int getOccupiedBeds() {
		return occupiedBeds;
	}

	public void setOccupiedBeds(int occupiedBeds) {
		this.occupiedBeds = occupiedBeds;
	}

	public List<Patient> getPatientList() {
		return patientList;
	}

	public void setPatientList(List<Patient> patientList) {
		this.patientList = patientList;
	}
	
	

}
