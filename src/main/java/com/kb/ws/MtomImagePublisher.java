package com.kb.ws;

import javax.xml.ws.Endpoint;
import javax.xml.ws.soap.SOAPBinding;

public class MtomImagePublisher {
	public static void main(String[] args) {
		Endpoint endpoint = Endpoint.create(new MtomImageServiceImpl());
		 SOAPBinding binding = (SOAPBinding) endpoint.getBinding();
		 binding.setMTOMEnabled(true);
		endpoint.publish("http://localhost:8888/ws/mtom/image");
		//Endpoint.publish("http://localhost:8888/ws/mtom/image", new MtomImageServiceImpl());
	}

}
