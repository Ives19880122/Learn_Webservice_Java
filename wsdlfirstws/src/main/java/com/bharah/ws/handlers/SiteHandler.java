package com.bharah.ws.handlers;

import java.util.Iterator;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.Node;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

/**
 * 1. 移除T,改成SOAPMessageContext
 * 2. 實作所有方法
 * @author ives
 *
 */
public class SiteHandler implements SOAPHandler<SOAPMessageContext> {

	@Override
	public boolean handleMessage(SOAPMessageContext context) {
		Boolean isResponse = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
		System.out.println("handleMessage");
		
		if(!isResponse) {
			SOAPMessage soapMsg = context.getMessage();
			try {
				SOAPEnvelope envelope = soapMsg.getSOAPPart().getEnvelope();
				SOAPHeader header = envelope.getHeader();
				Iterator childElements = header.getChildElements();
				while(childElements.hasNext()) {
					Node eachNode = (Node) childElements.next();
					
					String name = eachNode.getLocalName();
					if(name != null && "SiteName".equals(name)) {
						System.out.println("Site Name Is====>"+eachNode.getValue());
					}
				}
			} catch (SOAPException e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("Response on the way");
		}
		return true;
	}

	@Override
	public boolean handleFault(SOAPMessageContext context) {
		System.out.println("handleFault");
		return false;
	}

	@Override
	public void close(MessageContext context) {
		System.out.println("close");
	}

	@Override
	public Set<QName> getHeaders() {
		System.out.println("getHeaders");
		return null;
	}

}
