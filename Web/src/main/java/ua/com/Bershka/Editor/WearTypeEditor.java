package ua.com.Bershka.Editor;

import java.beans.PropertyEditorSupport;

import ua.com.Bershka.Classes.WearType;
import ua.com.Bershka.Service.WearTypeService;

public class WearTypeEditor extends PropertyEditorSupport {

	private WearTypeService wearTypeService;

	public WearTypeEditor(WearTypeService wearTypeService) {
		this.wearTypeService = wearTypeService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		WearType wearType=wearTypeService.findOne(Integer.valueOf(text));
		setValue(wearType);
	}
	
	
}
