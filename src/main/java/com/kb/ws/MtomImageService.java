package com.kb.ws;

import java.awt.Image;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style=Style.RPC)
public interface MtomImageService {
	
	//Upload image to server
	@WebMethod
	String uploadImage(Image imageData);
	
	//Download image from server
	@WebMethod
	Image downloadImage(String imageName);
	
	

}
