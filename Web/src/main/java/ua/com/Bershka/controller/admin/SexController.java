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
import ua.com.Bershka.Classes.Sex;
import ua.com.Bershka.Service.SexService;
import ua.com.Bershka.dto.filter.SimpleFilter;
import ua.com.Bershka.validator.SexValidator;
import static ua.com.Bershka.util.ParamBuilder.*; 

@Controller
@RequestMapping("/admin/sex")
@SessionAttributes("sex")
public class SexController {
	@Autowired
	private SexService sexService;
	private Category category;
	
	@ModelAttribute("sex")
	public Sex getForm(){
		return new Sex();
	}
	
	@ModelAttribute("filter")
	public SimpleFilter getFilter(){
		return new SimpleFilter();
	}
		
	@InitBinder("sex")
	protected void bind(WebDataBinder binder){
		binder.setValidator(new SexValidator(sexService));
	}
	@GetMapping
	public String show(Model model,@PageableDefault Pageable pageable,@ModelAttribute("filter")SimpleFilter filter){
		model.addAttribute("page", sexService.findAll(pageable,filter));
		return "admin-sex";
	}
	
	
	
	@GetMapping("delete/{id}")
	public String delete(@PathVariable int id,@PageableDefault Pageable pageable,@ModelAttribute("filter")SimpleFilter filter){
		sexService.delete(id);
		return "redirect:/admin/sex"+getParams(pageable);
		
	}
	
	@GetMapping("update/{id}")
	public String update(@PathVariable int id, Model model,@PageableDefault Pageable pageable,@ModelAttribute("filter")SimpleFilter filter){
		model.addAttribute("sex",sexService.findOne(id));
		return show(model,pageable,filter);
	}
	
	@PostMapping
	public String save(@ModelAttribute("sex")@Valid	Sex sex,BindingResult br,Model model,SessionStatus status,@PageableDefault Pageable pageable,@ModelAttribute("filter")SimpleFilter filter){
		if(br.hasErrors()) return show(model,pageable,filter);
		sexService.save(sex);
		status.setComplete();
		return "redirect:/admin/sex"+getParams(pageable);
		
	}

	
}
