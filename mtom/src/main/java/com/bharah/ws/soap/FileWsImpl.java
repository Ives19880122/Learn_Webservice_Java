package com.bharah.ws.soap;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;

public class FileWsImpl implements FileWs {

	@Override
	public void upload(DataHandler attachment) {
		String filePath = "/Users/ives/Coding/udemy/webservice/files/uploaded/test.jpg";
		try (
			InputStream inputStream = attachment.getInputStream();
			OutputStream outputStream = new FileOutputStream(
					new File(filePath));
		){
			byte[] b = new byte[100000];
			int bytesRead = 0;
			
			while((bytesRead = inputStream.read(b))!= -1) {
				outputStream.write(b, 0, bytesRead);
			}
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public DataHandler download() {
		return new DataHandler(new FileDataSource(new File("/Users/ives/Coding/udemy/webservice/files/uploaded/test.jpg")));
	}

}
