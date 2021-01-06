package com.kb.ws.client;

import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

import com.kb.ws.MtomImageService;

public class MtomImageDownloadClient {
	public static void main(String[] args) throws Exception {
		URL url = new URL("http://localhost:8888/ws/mtom/image?wsdl");

		QName qname = new QName("http://ws.kb.com/", "MtomImageServiceImplService");

		Service service = Service.create(url, qname);

		MtomImageService imageService = service.getPort(MtomImageService.class);
		// Enabling MTOM in client code
		BindingProvider bindingProvider = (BindingProvider) imageService;
		SOAPBinding binding = (SOAPBinding) bindingProvider.getBinding();
		binding.setMTOMEnabled(true);
		Image image = imageService.downloadImage("logo.jpg");

		// Display it using Swing GUI
		JFrame imageFrame = new JFrame();
		imageFrame.setSize(400, 400);
		JLabel imageLabel = new JLabel(new ImageIcon(image));
		imageFrame.add(imageLabel);
		imageFrame.setVisible(true);
	}

}
