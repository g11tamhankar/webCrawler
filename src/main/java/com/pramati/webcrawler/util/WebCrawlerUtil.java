package com.pramati.webcrawler.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.pramati.webcrawler.bean.MessageBean;

public class WebCrawlerUtil {

	private static final String FOLDER_NAME = "C:/crawledMessages";
	private static final String MSG_PRE = "msg-";
	private static final String MSG_FROM = "FROM" ;
	private static final String MSG_DATE = "DATE" ;
	private static final String MSG_SUBJECT = "SUBJECT" ;
	private static final String MSG_BODY = "BODY" ;
	
	public static void downloadMessages(List<MessageBean> messages){
		int count = 1;
		File file = null;
		file = new File(FOLDER_NAME);
		if(!file.exists())
			file.mkdir();
		PrintWriter pw=null;
		for(MessageBean msg : messages){			
			try {
				pw = new PrintWriter(new FileWriter(FOLDER_NAME+"/"+MSG_PRE+count));
				pw.write(MSG_DATE + " : " +msg.getMsgDate());
				pw.write("\n");
				pw.write(MSG_FROM + " : " +msg.getMsgFrom());
				pw.write("\n");
				pw.write(MSG_SUBJECT + " : " +msg.getMsgSub());
				pw.write("\n");
				pw.write(MSG_BODY + " : " +msg.getMsgBody());
				pw.write("\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				pw.close();
			}
			count++;
		}
		
	}
}
