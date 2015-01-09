package com.hackathon.comtrac.model;

public class CommunityStatusInfo {
	private String environment;
	private String hostIp;
	private int port;
	private boolean isUp;
	private String communityName;

	public String getEnvironment() {
		return environment;
	}

	public String getHostIp() {
		return hostIp;
	}

	public int getPort() {
		return port;
	}

	public boolean isUp() {
		return isUp;
	}

	public String getCommunityName() {
		return communityName;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	public void setHostIp(String hostIp) {
		this.hostIp = hostIp;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public void setUp(boolean isUp) {
		this.isUp = isUp;
	}

	public void setCommunityName(String communityName) {
		this.communityName = communityName;
	}
	
	public static CommunityStatusInfo getCommunityInfo(String name, String environment, String hostIp, int port, boolean isUp) {
		CommunityStatusInfo communityStatusInfo = new CommunityStatusInfo();
		communityStatusInfo.setCommunityName(name);
		communityStatusInfo.setEnvironment(environment);
		communityStatusInfo.setHostIp(hostIp);
		communityStatusInfo.setPort(port);
		communityStatusInfo.setUp(isUp);
		return communityStatusInfo;
	}

}
