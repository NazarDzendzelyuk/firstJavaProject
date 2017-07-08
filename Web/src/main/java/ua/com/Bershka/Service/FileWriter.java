package ua.com.Bershka.Service;

import org.springframework.web.multipart.MultipartFile;

public interface FileWriter {

	enum Folder{
		COMMODITY,WEARTYPE
	}
	
	boolean write(Folder folder, MultipartFile file, int id);

}
