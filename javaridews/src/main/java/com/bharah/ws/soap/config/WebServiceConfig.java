package com.bharah.ws.soap.config;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bharah.ws.soap.RideProcessorImpl;

@Configuration
public class WebServiceConfig {
	
	@Autowired
	private Bus bus;

    @Bean
    Endpoint endpoint() {
        Endpoint endpoint = new EndpointImpl(bus, new RideProcessorImpl());
        endpoint.publish("/rideProcessor");
        return endpoint;
    }
}
