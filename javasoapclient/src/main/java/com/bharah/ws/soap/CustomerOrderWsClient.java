package com.bharah.ws.soap;

import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import com.bharath.ws.trainings.CustomerOrdersPortType;
import com.bharath.ws.trainings.GetOrdersRequest;
import com.bharath.ws.trainings.GetOrdersResponse;
import com.bharath.ws.trainings.Order;

public class CustomerOrderWsClient {

	public static void main(String[] args) throws MalformedURLException {
		// step 1 設定 WS位置
		CustomerOrdersWsImplService service = new CustomerOrdersWsImplService(new URL("http://localhost:8080/wsdlfirstws/customerordersservice?wsdl"));
		CustomerOrdersPortType customerOrdersWsImplPort = service.getCustomerOrdersWsImplPort();
		// step 2 設定 request
		GetOrdersRequest request = new GetOrdersRequest();
		request.setCustomerId(BigInteger.valueOf(1));
		// step 3 從response取得 orders
		GetOrdersResponse response = customerOrdersWsImplPort.getOrders(request);
		List<Order> orders = response.getOrder();
		System.out.println("Number of orders for the customer are:"+ orders.size());
	}

}
