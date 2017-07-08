package ua.com.Bershka.Editor;

import java.beans.PropertyEditorSupport;

import ua.com.Bershka.Classes.Material;
import ua.com.Bershka.Service.MaterialService;

public class MaterialEditor extends PropertyEditorSupport	{

	private MaterialService materialService;

	public MaterialEditor(MaterialService materialService) {
		this.materialService = materialService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Material material=materialService.findOne(Integer.valueOf(text));
		setValue(material);
	}
	
	
}
