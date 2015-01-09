package com.hackathon.comtrac;

import static com.hackathon.comtrac.util.JsonUtil.json;
import static spark.Spark.get;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import spark.Request;
import spark.Response;
import spark.Route;

import com.hackathon.comtrac.model.CommunityInfo;
import com.hackathon.comtrac.model.CommunityStatusInfo;
import com.hackathon.comtrac.util.CommunityInfoCsvReader;

public class ComtracService {
	public static void main(String[] args) {
	  get("/communities/status",new Route() {
         @Override
         public Object handle(Request request, Response response) {
        	CommunityInfoCsvReader communityInfoCsvReader = new CommunityInfoCsvReader();
        	List<CommunityInfo> comtracCommunityInfoList = communityInfoCsvReader.readCommunityInfo();
        	
        	List<CommunityStatusInfo> communityStatuses = new LinkedList<>();
        	for (CommunityInfo info : comtracCommunityInfoList) {
        		boolean testStatus = SocketConnection.isListening(info.getTestIP(), info.getTestPortNo());
        		boolean productionStatus = SocketConnection.isListening(info.getProductionIP(), info.getProductionPortNo());
        		
        		communityStatuses.add(CommunityStatusInfo.getCommunityInfo(info.getCommunityName(), "Test", info.getTestIP(), info.getTestPortNo(), testStatus));
        		communityStatuses.add(CommunityStatusInfo.getCommunityInfo(info.getCommunityName(), "Production", info.getProductionIP(), info.getProductionPortNo(), productionStatus));
        	}
        	
            response.type("text/json");
        	return communityStatuses;
         }
      },json());

	  get("/communities/:name/status",new Route() {
         @Override
         public Object handle(Request request, Response response) {
            return "Hello World!";
         }
      },json());
   }
}
