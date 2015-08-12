package com.pramati.webcrawler.crawler;

import com.pramati.webcrawler.Input.LinkToCrawl;

public interface Crawler {

	public void crawl(LinkToCrawl linkToCrawl);
}
