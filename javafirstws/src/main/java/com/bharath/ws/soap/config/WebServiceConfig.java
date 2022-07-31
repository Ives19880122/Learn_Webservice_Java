package com.bharath.ws.soap.config;

import java.util.HashMap;
import java.util.Map;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.ws.security.wss4j.WSS4JInInterceptor;
import org.apache.wss4j.common.ConfigurationConstants;
import org.apache.wss4j.dom.WSConstants;
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
		
		Map<String, Object> inProps = new HashMap<>();
		// 配置常數
		inProps.put(ConfigurationConstants.ACTION, ConfigurationConstants.USERNAME_TOKEN);
		// 密碼類型
		inProps.put(ConfigurationConstants.PASSWORD_TYPE, WSConstants.PW_TEXT);
		// 密碼回應類別
		inProps.put(ConfigurationConstants.PW_CALLBACK_CLASS, UTPasswordCallBack.class.getName());
				
		// 設置攔截器
		WSS4JInInterceptor wssIn = new WSS4JInInterceptor(inProps);
//		endpoint.getInInterceptors().add(wssIn);
		
		return endpoint;
	}
}
