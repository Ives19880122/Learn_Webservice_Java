package com.bharah.trainings.ws.client;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.xml.datatype.DatatypeConfigurationException;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.endpoint.Endpoint;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;
import org.apache.wss4j.dom.WSConstants;
import org.apache.wss4j.dom.handler.WSHandlerConstants;

import com.bharath.ws.soap.PaymentProcessor;
import com.bharath.ws.soap.PaymentProcessorImplService;
import com.bharath.ws.soap.PaymentProcessorRequest;
import com.bharath.ws.soap.PaymentProcessorResponse;

public class PaymentWSClient {
	
	/**
	 * 建立Client端
	 * 1. 沒有建立Token 執行會導致錯誤
	 * @param args
	 * @throws DatatypeConfigurationException 
	 */
	public static void main(String[] args) throws DatatypeConfigurationException {
		try {
			PaymentProcessorImplService service = new PaymentProcessorImplService(new URL(
					"http://localhost:8080/javafirstws/paymentProcessor?wsdl"));
			PaymentProcessor port = service.getPaymentProcessorImplPort();
			Client client = ClientProxy.getClient(port);
			Endpoint endpoint = client.getEndpoint();
			// 設置參數
			Map<String, Object> props = new HashMap<>();
			props.put(WSHandlerConstants.ACTION, WSHandlerConstants.USERNAME_TOKEN);
			props.put(WSHandlerConstants.USER, "cxf");
			props.put(WSHandlerConstants.PASSWORD_TYPE, WSConstants.PW_TEXT);
			props.put(WSHandlerConstants.PW_CALLBACK_CLASS, UTPasswordCallback.class.getName());
			
			// 配置Interceptor至endpoint
			WSS4JOutInterceptor wssOut = new WSS4JOutInterceptor(props);
			// 一定要配置OutInterceptors, 不能誤用InInterceptors
			endpoint.getOutInterceptors().add(wssOut);
						
			PaymentProcessorResponse response = port.processPayment(new PaymentProcessorRequest());
			
			System.out.println(response.isResult());			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
}
