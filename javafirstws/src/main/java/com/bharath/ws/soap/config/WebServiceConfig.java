package com.bharath.ws.soap.config;

import java.util.HashMap;
import java.util.Map;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.ws.security.wss4j.WSS4JInInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bharath.ws.soap.PaymentProcessorImpl;

@Configuration
public class WebServiceConfig {
	
	@Autowired
	private Bus bus;
	
	/**
	 * 1. 設定EndpointImpl
	 * 2. 提供publish wsdl 路徑
	 * @return 
	 */
	@Bean
	public Endpoint endpoint() {
		EndpointImpl endpoint = new EndpointImpl(bus,new PaymentProcessorImpl());
		endpoint.publish("/paymentProcessor");
		
		// TODO 定義Token相關設定
		Map<String, Object> hashMap = new HashMap<>();
		
		// 設置攔截器
		WSS4JInInterceptor wssIn = new WSS4JInInterceptor(hashMap);
		endpoint.getInInterceptors().add(wssIn);
		
		return endpoint;
	}
}
