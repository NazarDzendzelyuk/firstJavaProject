package ua.com.Bershka.controller.admin;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.com.Bershka.Classes.Category;
import ua.com.Bershka.Classes.Color;
import ua.com.Bershka.Classes.Material;
import ua.com.Bershka.Classes.Sex;
import ua.com.Bershka.Classes.WearType;
import ua.com.Bershka.Editor.CategoryEditor;
import ua.com.Bershka.Editor.ColorEditor;
import ua.com.Bershka.Editor.MaterialEditor;
import ua.com.Bershka.Editor.SexEditor;
import ua.com.Bershka.Editor.WearTypeEditor;
import ua.com.Bershka.Service.CategoryService;
import ua.com.Bershka.Service.ColorService;
import ua.com.Bershka.Service.CommodityService;
import ua.com.Bershka.Service.MaterialService;
import ua.com.Bershka.Service.SexService;
import ua.com.Bershka.Service.WearTypeService;
import ua.com.Bershka.dto.filter.CommodityFilter;
import ua.com.Bershka.dto.form.CommodityForm;
import ua.com.Bershka.util.ParamBuilder;
import ua.com.Bershka.validator.CommodityValidator;
import static ua.com.Bershka.util.ParamBuilder.*;

@Controller
@RequestMapping("/admin/commodity")
@SessionAttributes("commodity")

public class CommodityController {

	@Autowired
	private CommodityService commodityService;
	@Autowired
	private CategoryService categoryService;	
	@Autowired
	private ColorService colorService;
	@Autowired
	private MaterialService materialService;
	@Autowired
	private WearTypeService wearTypeService;
	@Autowired
	private SexService sexService;
	
	@ModelAttribute("commodity")
	public CommodityForm getForm(){
		return new CommodityForm();
	}
	
	@ModelAttribute("filter")
	public CommodityFilter getFilter(){
		return new CommodityFilter();
	}
	
	
	@InitBinder("commodity")
	protected void bind(WebDataBinder binder){
		binder.registerCustomEditor(Category.class, new CategoryEditor(categoryService));
		binder.registerCustomEditor(Color.class, new ColorEditor(colorService));
		binder.registerCustomEditor(Material.class, new MaterialEditor(materialService));
		binder.registerCustomEditor(WearType.class, new WearTypeEditor(wearTypeService));
		binder.registerCustomEditor(Sex.class, new SexEditor(sexService));
		binder.setValidator(new CommodityValidator(commodityService));
	}
	
	@GetMapping
	public String show(Model model,@PageableDefault Pageable pageable,@ModelAttribute("filter")CommodityFilter filter){
		model.addAttribute("page",commodityService.findAll(pageable,filter));
		model.addAttribute("categories",categoryService.findAll());
		model.addAttribute("colors",colorService.findAll());
		model.addAttribute("materials",materialService.findAll());
		model.addAttribute("wearTypes",wearTypeService.findAll());
		model.addAttribute("sexs",sexService.findAll());
		return "admin-commodity";
	}
	
	@GetMapping("update/{id}")
	public String update(@PathVariable int id, Model model,@PageableDefault Pageable pageable,@ModelAttribute("filter")CommodityFilter filter){
		model.addAttribute("commodity",commodityService.findForm(id));
		return show(model,pageable,filter);
	}
	
	@GetMapping("delete/{id}")
	public String delete(@PathVariable int id,@PageableDefault Pageable pageable,@ModelAttribute("filter")CommodityFilter filter){
		commodityService.delete(id);
		return "redirect:/admin/commodity"+getParams(pageable,filter);
		
	}
	@PostMapping
	public String save(@ModelAttribute("commodity")@ Valid CommodityForm form,BindingResult br,Model model,SessionStatus status,@PageableDefault Pageable pageable,@ModelAttribute("filter")CommodityFilter filter){
		if(br.hasErrors()) return show(model,pageable,filter);
		commodityService.save(form);
		status.setComplete();
		return "redirect:/admin/commodity"+getParams(pageable,filter);
		
	}

	private String getParams(Pageable pageable, CommodityFilter filter) {
		String page=ParamBuilder.getParams(pageable);
		StringBuilder builder=new StringBuilder(page);
		
		if(filter.getMaxPrice().isEmpty()){
			builder.append("&maxPrice=");
			builder.append(filter.getMaxPrice());
		}
		
		if(filter.getMinPrice().isEmpty()){
			builder.append("&minPrice=");
			builder.append(filter.getMinPrice());
		}
		
		if(filter.getMaxSize().isEmpty()){
			builder.append("&maxSize=");
			builder.append(filter.getMaxSize());
			}
		
		if(filter.getMinSize().isEmpty()){
			builder.append("&minSize=");
			builder.append(filter.getMinSize());
		}
		if(!filter.getCategoryId().isEmpty()){
			for (int id : filter.getCategoryId()) {
				builder.append("&categoryId=");
				builder.append(id);
			}
		}
		
		if(!filter.getColorId().isEmpty()){
			for (int id : filter.getColorId()) {
				builder.append("&colorId=");
				builder.append(id);
			}
		}
		if(!filter.getMaterialId().isEmpty()){
			for (int id : filter.getMaterialId()) {
				builder.append("&materialId=");
				builder.append(id);
			}
		}
		if(!filter.getSexId().isEmpty()){
			for (int id : filter.getSexId()) {
				builder.append("&sexId=");
				builder.append(id);
			}
		}
		
		if(!filter.getWearTypeId().isEmpty()){
			for (int  id : filter.getWearTypeId()) {
				builder.append("&wearTypeid=");
				builder.append(id);
			}
		}
		return builder.toString();
	}
}
