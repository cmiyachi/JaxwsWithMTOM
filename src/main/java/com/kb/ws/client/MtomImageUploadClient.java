package com.kb.ws.client;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

import com.kb.ws.MtomImageService;

public class MtomImageUploadClient {
	public static void main(String[] args) throws IOException {

		URL url = new URL("http://localhost:8888/ws/mtom/image?wsdl");

		QName qname = new QName("http://ws.kb.com/", "MtomImageServiceImplService");

		Service service = Service.create(url, qname);

		MtomImageService imageService = service.getPort(MtomImageService.class);
		Image image = ImageIO.read(new File("D:\\images\\logo.jpg"));
		
		//Enabling MTOM in client code
		BindingProvider bindingProvider = (BindingProvider) imageService;
		SOAPBinding binding = (SOAPBinding) bindingProvider.getBinding();
		binding.setMTOMEnabled(true);

	}
}
