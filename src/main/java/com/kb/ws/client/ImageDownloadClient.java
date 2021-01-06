package com.kb.ws.client;

import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.kb.ws.ImageService;
import com.kb.ws.MtomImageService;

public class ImageDownloadClient {
	public static void main(String[] args) throws Exception {
		URL url = new URL("http://localhost:8889/ws/image?wsdl");

		QName qname = new QName("http://ws.kb.com/", "ImageServiceImplService");

		Service service = Service.create(url, qname);

		ImageService imageService = service.getPort(ImageService.class);
		Image image = imageService.downloadImage("logo.jpg");
		
		//Display it using Swing GUI
		JFrame imageFrame = new JFrame();
		imageFrame.setSize(400, 400);
        JLabel imageLabel = new JLabel(new ImageIcon(image));
        imageFrame.add(imageLabel);
        imageFrame.setVisible(true);
	}

}
