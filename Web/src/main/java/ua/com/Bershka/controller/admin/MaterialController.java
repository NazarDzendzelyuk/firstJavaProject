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

import ua.com.Bershka.Classes.Material;
import ua.com.Bershka.Service.MaterialService;
import ua.com.Bershka.dto.filter.SimpleFilter;
import ua.com.Bershka.validator.MaterialValidator;
import static ua.com.Bershka.util.ParamBuilder.*;

@Controller
@RequestMapping("/admin/material")
@SessionAttributes("material")
public class MaterialController {
	
	@Autowired
	private MaterialService materialService;
	
	@ModelAttribute("material")
	public Material getForm(){
		return new Material();
	}
	
	@ModelAttribute("filter")
	public SimpleFilter getFilter(){
		return new SimpleFilter();
	}
	
	@InitBinder("material")
	protected void bind(WebDataBinder binder){
		binder.setValidator(new MaterialValidator(materialService));
	}
	
	@GetMapping
	public String show(Model model,@PageableDefault Pageable pageable,@ModelAttribute("filter") SimpleFilter filter){
		model.addAttribute("page",materialService.findAll(filter,pageable));
		return "admin-material";
	}
	@GetMapping("delete/{id}")
	public String delete(@PathVariable int id,@PageableDefault Pageable pageable,@ModelAttribute("filter")SimpleFilter filter){
		materialService.delete(id);
		return "redirect:/admin/material"+getParams(pageable,filter);
	}
	
	@GetMapping("update/{id}")
	public String update(@PathVariable int id,Model model,@PageableDefault Pageable pageable,@ModelAttribute("filter")SimpleFilter filter){
		model.addAttribute("material",materialService.findOne(id));
		return show(model,pageable,filter);
	}
	
	@PostMapping
	public String save(@ModelAttribute("material")@Valid Material material,BindingResult br,Model model,SessionStatus status,@PageableDefault Pageable pageable,@ModelAttribute("filter")SimpleFilter filter){
		if(br.hasErrors()) return show(model,pageable,filter);
		materialService.save(material);
		status.setComplete();
		return "redirect:/admin/material"+getParams(pageable, filter);
	}

}
