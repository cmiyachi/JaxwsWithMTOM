package com.kb.ws;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.jws.WebService;

@WebService(endpointInterface="com.kb.ws.ImageService")
public class ImageServiceImpl implements ImageService{

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
