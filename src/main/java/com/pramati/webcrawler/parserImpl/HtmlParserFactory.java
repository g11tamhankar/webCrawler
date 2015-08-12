package com.pramati.webcrawler.parserImpl;

import com.pramati.webcrawler.constants.CrawlerConstants;
import com.pramati.webcrawler.parser.HtmlParser;

public class HtmlParserFactory {

	private static HtmlParser htmlParser;
	
	public static HtmlParser getHtmlParser(String type){
		if(type.equals(CrawlerConstants.MESSAGE_PARSER)){
			htmlParser = new MessageHtmlParser();
		}
		return htmlParser;
	}
	
}
