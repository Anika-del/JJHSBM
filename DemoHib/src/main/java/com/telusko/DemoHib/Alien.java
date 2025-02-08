package com.telusko.DemoHib;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Alien   //POJO
{
         @Id
	private int id;
	private String name;
	private String color;
	
	public int getAid() {
		return id;
	}
	public void setAid(int aid) {
		this.id = aid;
	}
	public String getAname() {
		return name;
	}
	public void setAname(String aname) {
		this.name = aname;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
//	@Override
//	public String toString() {
//		// TODO Auto-generated method stub
////		return super.toString();
//		return this.aid+" : "+this.aname+" : "+this.color;
//	}
//	
	
	
	
}
