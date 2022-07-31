package com.bharah.ws.soap.config;

import java.util.ArrayList;

import javax.xml.ws.Endpoint;
import javax.xml.ws.handler.Handler;
import javax.xml.ws.soap.SOAPBinding;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bharah.ws.handlers.SiteHandler;
import com.bharah.ws.soap.CustomerOrdersWsImpl;

@Configuration
public class WebServiceConfig {
	
	@Autowired
	private Bus bus;
	
	/**
	 * 1. 設定EndpointImpl
	 * 2. 提供publish wsdl 路徑 customerordersservice
	 * @return 
	 */
	@Bean
	public Endpoint endpoint() {
		Endpoint endpoint = new EndpointImpl(bus,new CustomerOrdersWsImpl());
		endpoint.publish("/customerordersservice");
		SOAPBinding binding = (SOAPBinding) endpoint.getBinding();
		
		// 加入SiteHandler Chain
		ArrayList<Handler> handlerChain = new ArrayList<>();
		handlerChain.add(new SiteHandler());
		
		// 設定至binding
		binding.setHandlerChain(handlerChain);
		
		return endpoint;
	}
}
