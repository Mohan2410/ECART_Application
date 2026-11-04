package com.NCart.Bean;

import java.io.Serializable;

public class AdminBean implements Serializable{
	private String aUNAME;
	private String aPWORD;
	private String aFNAME;
	private String aLNAME;
	private String aADDR;
	private String aMID;
	private String aPHNO;
	
	public AdminBean() {
		
	}

	public String getaUNAME() {
		return aUNAME;
	}

	public void setaUNAME(String aUNAME) {
		this.aUNAME = aUNAME;
	}

	public String getaPWORD() {
		return aPWORD;
	}

	public void setaPWORD(String aPWORD) {
		this.aPWORD = aPWORD;
	}

	public String getaFNAME() {
		return aFNAME;
	}

	public void setaFNAME(String aFNAME) {
		this.aFNAME = aFNAME;
	}

	public String getaLNAME() {
		return aLNAME;
	}

	public void setaLNAME(String aLNAME) {
		this.aLNAME = aLNAME;
	}

	public String getaADDR() {
		return aADDR;
	}

	public void setaADDR(String aADDR) {
		this.aADDR = aADDR;
	}

	public String getaMID() {
		return aMID;
	}

	public void setaMID(String aMID) {
		this.aMID = aMID;
	}

	public String getaPHNO() {
		return aPHNO;
	}

	public void setaPHNO(String aPHNO) {
		this.aPHNO = aPHNO;
	}

}
