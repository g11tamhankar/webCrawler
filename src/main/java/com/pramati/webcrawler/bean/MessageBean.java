package com.pramati.webcrawler.bean;

public class MessageBean {

	private String msgDate;
	private String msgFrom;
	private String msgSub;
	private String msgBody;
	
	public MessageBean(){
		
	}
	
	public MessageBean(String msgDate, String msgFrom, String msgSub,
			String msgBody) {
		super();
		this.msgDate = msgDate;
		this.msgFrom = msgFrom;
		this.msgSub = msgSub;
		this.msgBody = msgBody;
	}

	public String getMsgDate() {
		return msgDate;
	}

	public void setMsgDate(String msgDate) {
		this.msgDate = msgDate;
	}

	public String getMsgFrom() {
		return msgFrom;
	}

	public void setMsgFrom(String msgFrom) {
		this.msgFrom = msgFrom;
	}

	public String getMsgSub() {
		return msgSub;
	}

	public void setMsgSub(String msgSub) {
		this.msgSub = msgSub;
	}

	public String getMsgBody() {
		return msgBody;
	}

	public void setMsgBody(String msgBody) {
		this.msgBody = msgBody;
	}
	
}
