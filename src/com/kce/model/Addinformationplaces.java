package com.kce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="busroutecost1")
public class Addinformationplaces {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="place")
	private String place;
	@Column(name="distance")
	private int distance;
	@Column(name="busno")
	private String busno;
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public String getBusno() {
		return busno;
	}
	public void setBusno(String busno) {
		this.busno = busno;
	}
	public Addinformationplaces(String place,int distance, String busno) {
		this.place = place;
		this.distance = distance;
		this.busno = busno;
	}
	public Addinformationplaces()
	{
		
	}


}
