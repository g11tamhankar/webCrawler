package com.pramati.webcrawler;

import com.pramati.webcrawler.Input.LinkToCrawl;
import com.pramati.webcrawler.constants.CrawlerConstants;
import com.pramati.webcrawler.crawler.Crawler;
import com.pramati.webcrawler.crawlerImpl.CrawlerFactory;

/**
 * Hello world!
 *
 */
public class WebCrawler 
{
    public static void main( String[] args )
    {
        String link = args[0];
        String year = args[1];
        LinkToCrawl linkToCrawl = LinkToCrawl.getLinkToCrawl(link, year);
        Crawler crawler = CrawlerFactory.getCrawler(CrawlerConstants.MESSAGE);
        crawler.crawl(linkToCrawl);
    }
}
