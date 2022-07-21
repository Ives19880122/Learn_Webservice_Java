package com.bharah.ws.soap;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
		Endpoint endpoint = new EndpointImpl(bus,new Hellows());
		endpoint.publish("/hello");
		return endpoint;
	}
}
