package com.bharah.ws.soap;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.cxf.feature.Features;

import com.bharath.ws.trainings.CreateOrdersRequest;
import com.bharath.ws.trainings.CreateOrdersResponse;
import com.bharath.ws.trainings.CustomerOrdersPortType;
import com.bharath.ws.trainings.DeleteOrdersRequest;
import com.bharath.ws.trainings.DeleteOrdersResponse;
import com.bharath.ws.trainings.GetOrdersRequest;
import com.bharath.ws.trainings.GetOrdersResponse;
import com.bharath.ws.trainings.Order;
import com.bharath.ws.trainings.Product;

@Features(features="org.apache.cxf.feature.LoggingFeature")
public class CustomerOrdersWsImpl implements CustomerOrdersPortType {

	Map<BigInteger,List<Order>> customerOrders = new HashMap<>();
	int currentId;
	
	public CustomerOrdersWsImpl() {
		init();
	}
	
	/**
	 * 初始化訂單
	 */
	public void init() {
		List<Order> orders = new ArrayList<>();
		Order order = new Order();
		order.setId(BigInteger.valueOf(1));
		
		
		Product product = new Product();
		product.setId("1");
		product.setDescription("IPhone");
		product.setQuantity(BigInteger.valueOf(3));
		order.getProduct().add(product);
		
		orders.add(order);
		
		
		customerOrders.put(BigInteger.valueOf(++currentId), orders);
	}
	
	@Override
	public GetOrdersResponse getOrders(GetOrdersRequest request) {
		// 取得訂單資料
		BigInteger customerId = request.getCustomerId();
		List<Order> orders = customerOrders.get(customerId);
		
		// 回傳訂單資料
		GetOrdersResponse response = new GetOrdersResponse();
		response.getOrder().addAll(orders);
		
		return response;
	}

	@Override
	public CreateOrdersResponse createOrders(CreateOrdersRequest request) {
		BigInteger customerId = request.getCustomerId();
		Order order = request.getOrder();
		
		// 新增訂單
		List<Order> orders = customerOrders.get(customerId);
		orders.add(order);
		
		// 設定回傳結果
		CreateOrdersResponse response = new CreateOrdersResponse();
		response.setResult(true);
		
		return response;
	}

	@Override
	public DeleteOrdersResponse deleteOrders(DeleteOrdersRequest request) {
		// 取得訂單參數與既有資料比對
		BigInteger customerId = request.getCustomerId();
		Order order = request.getOrder();
		
		DeleteOrdersResponse response = new DeleteOrdersResponse();
		
		// 尋找訂單並且刪除, 如果找不到就回傳刪除失敗
		List<Order> orders = customerOrders.get(customerId);
		for(int i = 0; i<orders.size(); i++) {
			if(orders.get(i).getId().equals(order.getId())) {
				orders.remove(i);
				response.setResult(true);
				break;
			} 			
		}
		
		return response;
	}

}
