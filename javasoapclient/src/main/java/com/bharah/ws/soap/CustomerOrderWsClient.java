package com.bharah.ws.soap;

import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import com.bharath.ws.trainings.CreateOrdersRequest;
import com.bharath.ws.trainings.CreateOrdersResponse;
import com.bharath.ws.trainings.CustomerOrdersPortType;
import com.bharath.ws.trainings.GetOrdersRequest;
import com.bharath.ws.trainings.GetOrdersResponse;
import com.bharath.ws.trainings.Order;
import com.bharath.ws.trainings.Product;

public class CustomerOrderWsClient {

	public static void main(String[] args) throws MalformedURLException {
		// step 1 設定 WS位置
		CustomerOrdersWsImplService service = new CustomerOrdersWsImplService(new URL("http://localhost:8080/wsdlfirstws/customerordersservice?wsdl"));
		CustomerOrdersPortType customerOrdersWsImplPort = service.getCustomerOrdersWsImplPort();
		List<Order> orders = getOrderList(customerOrdersWsImplPort);
		System.out.println("Number of orders for the customer are:"+ orders.size());
		
		boolean result = createOrder(customerOrdersWsImplPort);
		System.out.println("The new order has been sent:"+ result);
	}
	
	/**
	 * 取得訂單列表
	 * @param portType
	 * @return
	 */
	private static List<Order> getOrderList(CustomerOrdersPortType portType){
		// step 2 設定 request
		GetOrdersRequest request = new GetOrdersRequest();
		request.setCustomerId(BigInteger.valueOf(1));
		// step 3 從response取得 orders
		GetOrdersResponse response = portType.getOrders(request);
		return response.getOrder();		
	}
	
	/**
	 * 新增訂單
	 * @param portType
	 * @return
	 */
	private static boolean createOrder(CustomerOrdersPortType portType) {
		// step 2 設定 request
		CreateOrdersRequest request = new CreateOrdersRequest();
		request.setCustomerId(BigInteger.valueOf(1));
		Order order = new Order();
		order.setId(BigInteger.valueOf(2));
		List<Product> products = order.getProduct();
		Product product = new Product();
		product.setId("2");
		product.setDescription("MAC BOOK PRO");
		product.setQuantity(BigInteger.valueOf(5));
		products.add(product);
		request.setOrder(order);
		// step 3 從response新增 order
		CreateOrdersResponse response = portType.createOrders(request);
		return response.isResult();
	}

}
