package com.hackathon.comtrac.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import com.hackathon.comtrac.model.CommunityInfo;
import com.univocity.parsers.common.processor.BeanListProcessor;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;

public class CommunityInfoCsvReader {
	
	public List<CommunityInfo> readCommunityInfo(){
		BeanListProcessor<CommunityInfo> rowProcessor = new BeanListProcessor<CommunityInfo>(CommunityInfo.class);

	    CsvParserSettings parserSettings = new CsvParserSettings();
	    parserSettings.setRowProcessor(rowProcessor);
	    parserSettings.setHeaderExtractionEnabled(true);

	    CsvParser parser = new CsvParser(parserSettings);
	    try {
			parser.parse((new FileReader("C:/Users/gauravt/Desktop/community.csv")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	    

	    // The BeanListProcessor provides a list of objects extracted from the input.
	    List<CommunityInfo> beans = rowProcessor.getBeans();	    
		return beans;
	}
	
	
	
}
