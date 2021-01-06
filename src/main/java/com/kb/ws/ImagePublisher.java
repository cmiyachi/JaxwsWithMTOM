package com.kb.ws;

import javax.xml.ws.Endpoint;

public class ImagePublisher {
	public static void main(String[] args) {
		Endpoint endpoint = Endpoint.create(new ImageServiceImpl());
		endpoint.publish("http://localhost:8889/ws/image");
		//Endpoint.publish("http://localhost:8889/ws/image", new ImageServiceImpl());
	}

}
