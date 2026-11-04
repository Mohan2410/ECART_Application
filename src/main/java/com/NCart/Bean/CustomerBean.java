package com.NCart.Bean;

import java.io.Serializable;

public class CustomerBean implements Serializable{
	private String cuname;
	private String cpwd;
	private String cfname;
	private String clname;
	private String caddr;
	private String cmailid;
	private String cmobile;
	
	public CustomerBean() {
		
	}

	public String getCuname() {
		return cuname;
	}

	public void setCuname(String cuname) {
		this.cuname = cuname;
	}

	public String getCpwd() {
		return cpwd;
	}

	public void setCpwd(String cpwd) {
		this.cpwd = cpwd;
	}

	public String getCfname() {
		return cfname;
	}

	public void setCfname(String cfname) {
		this.cfname = cfname;
	}

	public String getClname() {
		return clname;
	}

	public void setClname(String clname) {
		this.clname = clname;
	}

	public String getCaddr() {
		return caddr;
	}

	public void setCaddr(String caddr) {
		this.caddr = caddr;
	}

	public String getCmailid() {
		return cmailid;
	}

	public void setCmailid(String cmailid) {
		this.cmailid = cmailid;
	}

	public String getCmobile() {
		return cmobile;
	}

	public void setCmobile(String cmobile) {
		this.cmobile = cmobile;
	}
	
	

}
