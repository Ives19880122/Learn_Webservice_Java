package com.bharath.ws.soap.config;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.wss4j.common.ext.WSPasswordCallback;

public class UTPasswordCallBack implements CallbackHandler {
	
	private Map<String,String> passwords = new HashMap<>();
	
	public UTPasswordCallBack() {
		// TODO 正常情況下是使用DB進行相關資料的取得
		passwords.put("bharath", "bharath");
		passwords.put("cxf", "cxf");
	}
	
	/**
	 * 比對password callback
	 */
	@Override
	public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
		for(Callback callback : callbacks) {
			WSPasswordCallback passwordCallback = (WSPasswordCallback) callback;
			String password = passwords.get(passwordCallback.getIdentifier());
			if(password!=null) {
				passwordCallback.setPassword(password);
				return;
			}
		}
	}

}
