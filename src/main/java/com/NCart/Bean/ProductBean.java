package com.NCart.Bean;

import java.io.Serializable;

public class ProductBean implements Serializable{
	public String getpCode() {
		return pCode;
	}

	public void setpCode(String pCode) {
		this.pCode = pCode;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getpComp() {
		return pComp;
	}

	public void setpComp(String pComp) {
		this.pComp = pComp;
	}

	public String getpPrice() {
		return pPrice;
	}

	public void setpPrice(String pPrice) {
		this.pPrice = pPrice;
	}

	public String getpQty() {
		return pQty;
	}

	public void setpQty(String pQty) {
		this.pQty = pQty;
	}

	private String pCode;
	private String pName;
	private String pComp;
	private String pPrice;
	private String pQty;
	
	public ProductBean() {
		
	}

}
