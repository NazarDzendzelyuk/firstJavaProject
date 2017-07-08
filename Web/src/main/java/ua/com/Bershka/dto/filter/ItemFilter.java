package ua.com.Bershka.dto.filter;

import java.util.LinkedList;
import java.util.List;

import ua.com.Bershka.Classes.Item;

public class ItemFilter {

	List<Item>userName=new LinkedList<>();

	public List<Item> getUserName() {
		return userName;
	}

	public void setUserName(List<Item> userName) {
		this.userName = userName;
	}
}
