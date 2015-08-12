package com.pramati.webcrawler.Input;

public class LinkToCrawl {

	private String link ;
	private String year;
	
	public LinkToCrawl(String link,String year){
		this.link = link;
		this.year = year;
	}
	
	public static LinkToCrawl getLinkToCrawl(String link,String year){
		return new LinkToCrawl(link, year);
	}
	
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
}
