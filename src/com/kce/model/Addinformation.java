package com.kce.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="busroutecost1")
public class Addinformation {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="id")
private int id;
@Column(name="place")
private String place;
@Column(name="distance")
private int distance;
@Column(name="pvtbustime")
private String pvtbustime;
@Column(name="airbustime")
private String airbustime;
@Column(name="govtbustime")
private String govtbustime;
@Column(name="busno")
private String busno;
public String getPlace() {
	return place;
}
public void setPlace(String place) {
	this.place = place;
}
public String getBusno() {
	return busno;
}
public void setBusno(String busno) {
	this.busno = busno;
}
public int getDistance() {
	return distance;
}
public void setDistance(int distance) {
	this.distance = distance;
}
public String getPvtbustime() {
	return pvtbustime;
}
public void setPvtbustime(String pvtbustime) {
	this.pvtbustime = pvtbustime;
}
public String getAirbustime() {
	return airbustime;
}
public void setAirbustime(String airbustime) {
	this.airbustime = airbustime;
}
public String getGovtbustime() {
	return govtbustime;
}
public void setGovtbustime(String govtbustime) {
	this.govtbustime = govtbustime;
}

public Addinformation(String place, String busno, int distance, String pvtbustime, String airbustime, String govtbustime) {
	this.place = place;
	this.busno = busno;
	this.distance = distance;
	this.pvtbustime = pvtbustime;
	this.airbustime = airbustime;
	this.govtbustime = govtbustime;
}
public Addinformation() {
}

}