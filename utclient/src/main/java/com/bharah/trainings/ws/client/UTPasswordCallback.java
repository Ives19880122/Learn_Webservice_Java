package com.bharah.trainings.ws.client;

import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.wss4j.common.ext.WSPasswordCallback;

public class UTPasswordCallback implements CallbackHandler {

	@Override
	public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
		for(Callback callback : callbacks) {
			WSPasswordCallback wpc = (WSPasswordCallback) callback;
			wpc.setPassword("cxf");
			return;
		}
	}

}
