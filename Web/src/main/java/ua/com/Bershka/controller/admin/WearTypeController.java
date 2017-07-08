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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.com.Bershka.Classes.Category;
import ua.com.Bershka.Classes.Sex;
import ua.com.Bershka.Classes.WearType;
import ua.com.Bershka.Editor.CategoryEditor;
import ua.com.Bershka.Editor.SexEditor;
import ua.com.Bershka.Service.CategoryService;
import ua.com.Bershka.Service.WearTypeService;
import ua.com.Bershka.dto.filter.WearTypeFilter;
import ua.com.Bershka.dto.form.WearTypeForm;
import ua.com.Bershka.util.ParamBuilder;
import ua.com.Bershka.validator.WearTypeValidator;
import static ua.com.Bershka.util.ParamBuilder.*;
@Controller
@RequestMapping("/admin/wearType")
@SessionAttributes("wearType")
public class WearTypeController {
	@Autowired
	private WearTypeService wearTypeService;
	@Autowired
	private CategoryService categoryService;
	
	@ModelAttribute("wearType")
	public WearTypeForm getForm(){
		return new WearTypeForm();
	}
	
	@ModelAttribute("filter")
	private WearTypeFilter getFilter(){
		return new WearTypeFilter();
	}
	
	@InitBinder("wearType")
	protected void bind(WebDataBinder binder){
		binder.registerCustomEditor(Category.class, new CategoryEditor(categoryService));
		binder.setValidator(new WearTypeValidator(wearTypeService));
	}
	
	@GetMapping
	public String show(Model model,@PageableDefault Pageable pageable,@ModelAttribute("filter")WearTypeFilter filter){
		model.addAttribute("page",wearTypeService.findAll(pageable,filter));
		model.addAttribute("categories",categoryService.findAll());
		return "admin-wearType";
	}
	
		
	@GetMapping("delete/{id}")
	public String delete(@PathVariable int id,@PageableDefault Pageable pageable,@ModelAttribute("filter")WearTypeFilter filter){
		wearTypeService.delete(id);
		return "redirect:/admin/wearType"+getParams(pageable,filter);
		
	}
	
	@GetMapping("update/{id}")
	public String update(@PathVariable int id,Model model,@PageableDefault Pageable pageable,@ModelAttribute("filter")WearTypeFilter filter ){
		model.addAttribute("wearType",wearTypeService.findForm(id));
		return show(model,pageable,filter);
	}
	@PostMapping
	public String save(@ModelAttribute("wearType")@Valid WearTypeForm form,BindingResult br,SessionStatus status,Model model,@PageableDefault Pageable pageable,@ModelAttribute("filter")WearTypeFilter filter){
		if(br.hasErrors()) return show(model,pageable,filter);
		wearTypeService.save(form);
		status.setComplete();
		return "redirect:/admin/wearType"+getParams(pageable,filter);
	}

	private String getParams(Pageable pageable, WearTypeFilter filter) {
		String page=ParamBuilder.getParams(pageable);
		StringBuilder builder=new StringBuilder(page);
		
		if(!filter.getCategoryId().isEmpty()){
			for (int id : filter.getCategoryId()) {
				builder.append("&categoryId=");
				builder.append(id);
			}
		}
		return builder.toString();
	}
}
