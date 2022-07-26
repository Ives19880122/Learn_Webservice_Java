package com.bharath.ws.soap;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import com.bharath.ws.soap.dto.PaymentProcessorRequest;
import com.bharath.ws.soap.dto.PaymentProcessorResponse;

// 註解WebService, 設定名稱將在Wsdl顯示
@WebService(name="PaymentProcessor")
public interface PaymentProcessor {
	/**
	 * 1. 註解WebParam 可設定命名
	 * 2. 註解WebResult 設定回傳命名為response
	 * 3. 註解WebMethod 表示這是一個WebService方法
	 * @param paymentProcessorRequest
	 * @return
	 */
	@WebMethod
	public @WebResult(name="response") PaymentProcessorResponse processPayment(@WebParam(name="paymentProcessorRequest") PaymentProcessorRequest paymentProcessorRequest);
}
