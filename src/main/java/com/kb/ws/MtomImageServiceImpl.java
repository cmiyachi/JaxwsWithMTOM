package com.kb.ws;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.soap.MTOM;

@MTOM
@WebService(endpointInterface="com.kb.ws.MtomImageService")
@SOAPBinding(style=Style.RPC)
public class MtomImageServiceImpl implements MtomImageService{

	@Override
	public String uploadImage(Image imageData) {
		if(null != imageData){
			//Write a code to store the image
			return "Image uploaded successfully";
		}
		//If image data is not there, then throw below exception
		throw new WebServiceException("Image Upload Failed!");
	}

	@Override
	public Image downloadImage(String imageName) {
		File image = new File("D:\\images\\"+imageName);
		try {
			return ImageIO.read(image);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
