package com.shopping.beans;

public class CartItemBean {
	
	int equantity;
	String eid;
	String ename;
	String eprice;
	String esellerid;
	String edetails;
	int estock;
	double totalcost;
	
	
	public double getTotalcost() {
		return totalcost;
	}
	public void setTotalcost(double totalcost) {
		this.totalcost = totalcost;
	}
	public int getEquantity() {
		return equantity;
	}
	public void setEquantity(int equantity) {
		this.equantity = equantity;
	}
	public String getEid() {
		return eid;
	}
	public void setEid(String eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEprice() {
		return eprice;
	}
	public void setEprice(String eprice) {
		this.eprice = eprice;
	}
	public String getEsellerid() {
		return esellerid;
	}
	public void setEsellerid(String esellerid) {
		this.esellerid = esellerid;
	}
	public int getEstock() {
		return estock;
	}
	public void setEstock(int estock) {
		this.estock = estock;
	}
	
	public String getEdetails() {
		return edetails;
	}
	public void setEdetails(String edetails) {
		this.edetails = edetails;
	}
	

}
