package ua.com.Bershka.controller.admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import ua.com.Bershka.Service.ItemService;
import ua.com.Bershka.dto.filter.SimpleFilter;

@Controller
@RequestMapping("/admin/item")
@SessionAttributes("item")
public class ItemControler {
	
	@ModelAttribute("filter")
	public SimpleFilter getFilter(){
		return new SimpleFilter();
	}
	
	@Autowired
	private ItemService itemService;
	
	@GetMapping
	public String show(Model model, @PageableDefault Pageable pageable,@ModelAttribute("filter")SimpleFilter  filter){
		model.addAttribute("page", itemService.findAll(pageable,filter));
		return "admin-item";
	}
}
