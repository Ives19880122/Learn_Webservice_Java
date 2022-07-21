package com.bharah.ws.soap;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.apache.cxf.feature.Features;

@WebService
@Features(features= "org.apache.cxf.feature.LoggingFeature") // 設定開啟Log功能
public class Hellows {
	@WebMethod
	public String hello() {
		return "hello";
	}
}
