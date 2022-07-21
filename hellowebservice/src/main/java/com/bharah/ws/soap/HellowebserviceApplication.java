package com.bharah.ws.soap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HellowebserviceApplication {
	/**
	 * 啟動預設連線 url services/${endpoint}
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(HellowebserviceApplication.class, args);
	}

}
