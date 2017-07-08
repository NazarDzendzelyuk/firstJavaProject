package ua.com.Bershka.dto.form;

import org.springframework.web.multipart.MultipartFile;

import com.sun.activation.registries.MailcapFile;

import ua.com.Bershka.Classes.Category;
import ua.com.Bershka.Classes.Color;
import ua.com.Bershka.Classes.Material;
import ua.com.Bershka.Classes.Sex;
import ua.com.Bershka.Classes.WearType;

public class CommodityForm {

	private int id;
	private String price;
	private String commodity;
	private String size;
	
	private int version;
	
	private MultipartFile file;
	
	private Category category;
	
	private Color color;
	
	private Material material;
	
	private WearType wearType;
	
	private Sex sex;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getCommodity() {
		return commodity;
	}

	public void setCommodity(String commodity) {
		this.commodity = commodity;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public WearType getWearType() {
		return wearType;
	}

	public void setWearType(WearType wearType) {
		this.wearType = wearType;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}
}
