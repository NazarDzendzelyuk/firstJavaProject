package ua.com.Bershka.dto.filter;

import java.util.ArrayList;
import java.util.List;



public class CommodityFilter {

	private String minSize = "";
	private String maxSize = "";
	private String minPrice= "";
	private String maxPrice= "";
	private int minSizeValue;
	private int maxSizeValue;
	private int minPriceValue;
	private int maxPriceValue;

	private List<Integer> colorId = new ArrayList<>();
	private List<Integer> categoryId= new ArrayList<>();
	private List<Integer> materialId= new ArrayList<>();
	private List<Integer> sexId= new ArrayList<>();
	private List<Integer> wearTypeId= new ArrayList<>();
	
	public String getMinSize() {
		return minSize;
	}
	public void setMinSize(String minSize) {
		this.minSize = minSize;
	}
	public String getMaxSize() {
		return maxSize;
	}
	public void setMaxSize(String maxSize) {
		this.maxSize = maxSize;
	}
	public String getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(String minPrice) {
		this.minPrice = minPrice;
	}
	public String getMaxPrice() {
		return maxPrice;
	}
	public void setMaxPrice(String maxPrice) {
		this.maxPrice = maxPrice;
	}
	public int getMinSizeValue() {
		return minSizeValue;
	}
	public void setMinSizeValue(int minSizeValue) {
		this.minSizeValue = minSizeValue;
	}
	public int getMaxSizeValue() {
		return maxSizeValue;
	}
	public void setMaxSizeValue(int maxSizeValue) {
		this.maxSizeValue = maxSizeValue;
	}
	public int getMinPriceValue() {
		return minPriceValue;
	}
	public void setMinPriceValue(int minPriceValue) {
		this.minPriceValue = minPriceValue;
	}
	public int getMaxPriceValue() {
		return maxPriceValue;
	}
	public void setMaxPriceValue(int maxPriceValue) {
		this.maxPriceValue = maxPriceValue;
	}
	public List<Integer> getColorId() {
		return colorId;
	}
	public void setColorId(List<Integer> colorId) {
		this.colorId = colorId;
	}
	public List<Integer> getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(List<Integer> categoryId) {
		this.categoryId = categoryId;
	}
	public List<Integer> getMaterialId() {
		return materialId;
	}
	public void setMaterialId(List<Integer> materialId) {
		this.materialId = materialId;
	}
	public List<Integer> getSexId() {
		return sexId;
	}
	public void setSexId(List<Integer> sexId) {
		this.sexId = sexId;
	}
	public List<Integer> getWearTypeId() {
		return wearTypeId;
	}
	public void setWearTypeId(List<Integer> wearTypeId) {
		this.wearTypeId = wearTypeId;
	}
	
}
