package com.hackathon.comtrac.model;

import com.univocity.parsers.annotations.Parsed;

public class CommunityInfo {
	
	@Parsed(field="Community Name")
	private String communityName;
	
	@Parsed(field="Test IP")
	private String testIP;
	
	@Parsed(field="Test Port")
	private int testPortNo;
	
	@Parsed(field="Production IP")
	private String productionIP;
	
	@Parsed(field="Production Port")
	private int productionPortNo;		
	
	public String getCommunityName() {
		return communityName;
	}
	public void setCommunityName(String communityName) {
		this.communityName = communityName;
	}
	public int getTestPortNo() {
		return testPortNo;
	}
	public void setTestPortNo(int testPortNo) {
		this.testPortNo = testPortNo;
	}
	public int getProductionPortNo() {
		return productionPortNo;
	}
	public void setProductionPortNo(int productionPortNo) {
		this.productionPortNo = productionPortNo;
	}
	public String getTestIP() {
		return testIP;
	}
	public void setTestIP(String testIP) {
		this.testIP = testIP;
	}
	public String getProductionIP() {
		return productionIP;
	}
	public void setProductionIP(String productionIP) {
		this.productionIP = productionIP;
	}
	
	
	
}
