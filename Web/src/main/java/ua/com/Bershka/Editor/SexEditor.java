package ua.com.Bershka.Editor;

import java.beans.PropertyEditorSupport;

import ua.com.Bershka.Classes.Sex;
import ua.com.Bershka.Service.SexService;

public class SexEditor extends PropertyEditorSupport{

	private SexService sexService;

	public SexEditor(SexService sexService) {
		this.sexService = sexService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Sex sex=sexService.findOne(Integer.valueOf(text));
		setValue(sex);
		
	}
	
	
}
