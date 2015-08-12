package com.pramati.webcrawler.crawlerImpl;

import com.pramati.webcrawler.constants.CrawlerConstants;
import com.pramati.webcrawler.crawler.Crawler;

public class CrawlerFactory {

	private static Crawler crawler ;
	
	public static Crawler getCrawler(String type){
		if(type.equals(CrawlerConstants.MESSAGE)){
			crawler = new MessageCrawler();
		}
		return crawler;
	}
}
