package ua.com.Bershka.dto.form;

import org.springframework.web.multipart.MultipartFile;

import ua.com.Bershka.Classes.Category;

public class WearTypeForm {

	private int id;
	
	private String wearType;
	
	private Category category;
	

	private int version;
	
	private MultipartFile file;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getWearType() {
		return wearType;
	}

	public void setWearType(String wearType) {
		this.wearType = wearType;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}
	
	
}
