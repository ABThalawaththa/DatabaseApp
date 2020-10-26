package com.DB.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "patient_details")
public class Patient {
	@Id
	@Column(name = "patient_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int patientId;
	
	@Column(name = "first_name",nullable = false)
	private String patient_firstName;
	
	@Column(name = "last_name",nullable = false)
	private String patient_lastname;
	
	@ManyToOne
	@JoinColumn(name="ward_Id")
	private Ward wardPatient;

	

	

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getPatient_firstName() {
		return patient_firstName;
	}

	public void setPatient_firstName(String patient_firstName) {
		this.patient_firstName = patient_firstName;
	}

	public String getPatient_lastname() {
		return patient_lastname;
	}

	public void setPatient_lastname(String patient_lastname) {
		this.patient_lastname = patient_lastname;
	}

	public Ward getWard() {
		return wardPatient;
	}

	public void setWard(Ward ward) {
		this.wardPatient = ward;
	}
}
