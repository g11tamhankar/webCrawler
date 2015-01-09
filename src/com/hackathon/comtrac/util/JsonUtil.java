package com.hackathon.comtrac.util;

import spark.ResponseTransformer;

import com.owlike.genson.Genson;

public class JsonUtil {
	
	public static String toJson(Object object) {
		//return new Genson().toJson(object);
		return new Genson().serialize(object);
	}
	
	public static ResponseTransformer json() {
		return new ResponseTransformer() {
			@Override
			public String render(Object obj) throws Exception {
				// TODO Auto-generated method stub
				return JsonUtil.toJson(obj);
			}
		};
	}
}




