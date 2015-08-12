package com.pramati.webcrawler.crawlerImpl;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import com.pramati.webcrawler.Input.LinkToCrawl;
import com.pramati.webcrawler.bean.MessageBean;
import com.pramati.webcrawler.constants.CrawlerConstants;
import com.pramati.webcrawler.crawler.Crawler;
import com.pramati.webcrawler.parserImpl.HtmlParserFactory;
import com.pramati.webcrawler.parserImpl.MessageHtmlParser;
import com.pramati.webcrawler.util.WebCrawlerUtil;

public class MessageCrawler implements Crawler{
	
	private final int DEPTH_OF_CRAWL = 3;
	private BlockingQueue<String> urlQueue = new LinkedBlockingQueue<String>();
	private int depth =1;
	private MessageHtmlParser htmlParser = null; 
	private List<MessageBean> messages ;
	
	public void crawl(LinkToCrawl linkToCrawl){
		htmlParser = (MessageHtmlParser)HtmlParserFactory.getHtmlParser(CrawlerConstants.MESSAGE_PARSER);
		
		if(linkToCrawl.getLink()!=null){
			try {
				urlQueue.put(linkToCrawl.getLink());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		htmlParser.setUrlQueue(urlQueue);
		while(depth<=DEPTH_OF_CRAWL){
			switch(depth){
				case 1 : htmlParser.firstLevelParser(linkToCrawl);
					break;
				case 2 : htmlParser.secondLevelParser(linkToCrawl);
					break;
				case 3 : messages = htmlParser.thirdLevelParser(linkToCrawl);
						WebCrawlerUtil.downloadMessages(messages);
					break;					
			}
			depth++;
		}
	}
}
