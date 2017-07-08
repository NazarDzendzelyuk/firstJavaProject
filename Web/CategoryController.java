package ua.com.Bershka.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ua.com.Bershka.Classes.Category;
import ua.com.Bershka.Classes.Sex;
import ua.com.Bershka.Service.CategoryService;
import ua.com.Bershka.Service.SexService;

@Controller
@RequestMapping("/admin/category")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private SexService sexService;
	
	@GetMapping
	public String show(Model model){
		model.addAttribute("category",categoryService.findAll());
		model.addAttribute("sexs",sexService.findAll());
		return "admin-category";
	}
	@GetMapping("delete/{id}")
	public String delete(@PathVariable int id) {
		categoryService.delete(id);
		return "redirect:/admin/category";
		
	}
	@PostMapping
	public String save(@RequestParam String category,@RequestParam int sex_id){
		Sex sex=sexService.findOne(sex_id);
		Category entity=new Category();
		entity.setSex(sex);
		entity.setCategory(category);
		categoryService.save(entity);
		return "redirect:/admin/category";
	}
}
