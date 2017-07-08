package ua.com.Bershka.Editor;

import java.beans.PropertyEditorSupport;

import ua.com.Bershka.Classes.Color;
import ua.com.Bershka.Service.ColorService;

public class ColorEditor extends PropertyEditorSupport {
	
	private ColorService colorService;

	public ColorEditor(ColorService colorService) {
		this.colorService = colorService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Color color=colorService.findOne(Integer.valueOf(text));
		setValue(color);
	}
	
	

}
