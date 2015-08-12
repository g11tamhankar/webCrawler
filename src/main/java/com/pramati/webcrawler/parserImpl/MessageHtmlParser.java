package com.pramati.webcrawler.parserImpl;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.pramati.webcrawler.Input.LinkToCrawl;
import com.pramati.webcrawler.bean.MessageBean;
import com.pramati.webcrawler.constants.CrawlerConstants;
import com.pramati.webcrawler.parser.HtmlParser;

public class MessageHtmlParser implements HtmlParser {

	private BlockingQueue<String> urlQueue;
	private List<MessageBean> messages = new LinkedList<MessageBean>();
	
	public BlockingQueue<String> getUrlQueue() {
		return urlQueue;
	}

	public void setUrlQueue(BlockingQueue<String> urlQueue) {
		this.urlQueue = urlQueue;
	}

	public void firstLevelParser(LinkToCrawl linkToCrawl){
		Document doc = null;
		try {
			doc = Jsoup.connect(urlQueue.poll()).get();		
			Elements element = doc.getElementsContainingOwnText(linkToCrawl.getYear());			
			for(Element elementObj : element){				
				for(Element ele :elementObj.parent().getElementsByAttribute("href")){
					if(ele.attr("href").endsWith("thread")){						
						try {
							urlQueue.put(ele.attr("href"));
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}						
				}					
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				urlQueue.put(CrawlerConstants.SECOND_LEVEL);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void secondLevelParser(LinkToCrawl linkToCrawl){
		Document doc = null;
		String thirdLevelUrlPostfix = "";
		try {
			while(urlQueue.peek()!=CrawlerConstants.SECOND_LEVEL){
				thirdLevelUrlPostfix = linkToCrawl.getLink()+urlQueue.poll();
				doc = Jsoup.connect(thirdLevelUrlPostfix).get();
				Elements element = doc.getElementById("msglist").getElementsByTag("tbody");
				for(Element ele : element){
					for(Element elem : ele.getElementsByTag("tr")){
						if(elem.getElementsByClass("subject").size()>0)
							if(elem.getElementsByClass("subject").get(0).getElementsByAttribute("href").size()>0)
								try {
									urlQueue.put(thirdLevelUrlPostfix.substring(0,thirdLevelUrlPostfix.lastIndexOf("/")+1)+(elem.getElementsByClass("subject").get(0).getElementsByAttribute("href").get(0).attr("href")));
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
					}
				}
			}					
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			urlQueue.poll();
		}
		
	}
	
	public List<MessageBean> thirdLevelParser(LinkToCrawl linkToCrawl){
		Document doc = null;
		String msgDate = "";
		String msgFrom = "";
		String msgSub = "";
		String msgBody = "";
		
		try {
			while(!urlQueue.isEmpty()){
				doc = Jsoup.connect(urlQueue.poll()).get();
				Elements element = doc.getElementsByTag("tbody");
				if(element.size()>0){
					if(element.get(0).getElementsByClass("subject").size()>0)
						if(element.get(0).getElementsByClass("subject").get(0).getElementsByClass("right").size()>0)
							msgSub = element.get(0).getElementsByClass("subject").get(0).getElementsByClass("right").html();
					
					if(element.get(0).getElementsByClass("from").size()>0)
						if(element.get(0).getElementsByClass("from").get(0).getElementsByClass("right").size()>0)
							msgFrom = element.get(0).getElementsByClass("from").get(0).getElementsByClass("right").html();
					
					if(element.get(0).getElementsByClass("date").size()>0)
						if(element.get(0).getElementsByClass("date").get(0).getElementsByClass("right").size()>0)
							msgDate = element.get(0).getElementsByClass("date").get(0).getElementsByClass("right").html();
					
					if(element.get(0).getElementsByClass("contents").size()>0)
							if(element.get(0).getElementsByClass("contents").get(0).getElementsByTag("td").size()>0)
								if(element.get(0).getElementsByClass("contents").get(0).getElementsByTag("td").get(0).getElementsByTag("pre").size()>0)
									msgBody = element.get(0).getElementsByClass("contents").get(0).getElementsByTag("td").get(0).getElementsByTag("pre").get(0).html();
				}
				
				messages.add(new MessageBean(msgDate, msgFrom, msgSub, msgBody));
				msgDate = "";
				msgFrom = "";
				msgSub = "";
				msgBody = "";					
			}
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return messages;
	}
}
