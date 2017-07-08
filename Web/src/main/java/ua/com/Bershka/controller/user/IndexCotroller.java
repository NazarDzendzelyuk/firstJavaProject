package ua.com.Bershka.controller.user;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import ua.com.Bershka.Classes.Item;
import ua.com.Bershka.Classes.User;
import ua.com.Bershka.Dao.ItemDao;
import ua.com.Bershka.Service.CategoryService;
import ua.com.Bershka.Service.ColorService;
import ua.com.Bershka.Service.CommodityService;
import ua.com.Bershka.Service.ItemService;
import ua.com.Bershka.Service.MaterialService;
import ua.com.Bershka.Service.SexService;
import ua.com.Bershka.Service.UserService;
import ua.com.Bershka.Service.WearTypeService;
import ua.com.Bershka.validator.UserValidator;

@Controller
public class IndexCotroller {
	
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private CategoryService categoryService;

	@Autowired
	private WearTypeService wearTypeService;
	
	@Autowired
	private CommodityService  commodityService;
	
	@Autowired
	private ColorService  colorService;
	
	@Autowired
	private MaterialService  materialService;
	
	@Autowired
	private SexService sexService;
	
	@Autowired
	private UserService userService;
	
//	@RequestMapping("/")
//	public String index(Principal principal){
//		if(principal!=null){
//			System.out.println(principal.getName());
//		}
//		return "admin-color";
//	}
	
	@RequestMapping("/")
	public String dB(Model model,Principal principal){
		if(principal!=null){
			System.out.println(principal.getName());
		}
		model.addAttribute("sexs",sexService.findAll());
		return "user-index";
	}
//	@RequestMapping("/c")
//	public String neRandomCommodity(Model model){
//		
//		return "user-category";
//		
//	}
	
	@RequestMapping("/category/{id}")
	public String category(@PathVariable int id, Model model){
		model.addAttribute("sex",sexService.findOne(id));
		model.addAttribute("categories",categoryService.findBySexId(id));
		model.addAttribute("wearTypes",wearTypeService.findAll());
		model.addAttribute("commodities", commodityService.findAll());
		return "user-category";
	}
	@RequestMapping("/wearType/{id}")
	public String wearType(@PathVariable int id, Model model){
		model.addAttribute("category",categoryService.findOne(id));
		model.addAttribute("wearTypes",wearTypeService.findByCategoryId(id));
		return "user-wearType";
	}
	
	@RequestMapping("/commodity/{id}")
	public String commodity(@PathVariable int id, Model model){
		model.addAttribute("wearType",wearTypeService.findOne(id));
		model.addAttribute("commodities",commodityService.findByWearTypeId(id));
		return "user-commodity";
	}
	
	@RequestMapping("/details/{id}")
	public String details(@PathVariable int id, Model model){
		model.addAttribute("commodity",commodityService.findOne(id));
		model.addAttribute("colors",colorService.findByCommodityId(id));
		model.addAttribute("materials", materialService.findByMaterialId(id));
		model.addAttribute("sexs", sexService.findBySexId(id));
		return "user-details";
	}
	
	@GetMapping("/registration")
	public String registration(Model model){
		model.addAttribute("user", new User());
		return "user-registration";
	}
	
	@PostMapping("/registration")
	public String save(@ModelAttribute("user") @Valid User user,BindingResult br,Model model, Principal principal){
		if(br.hasErrors()) return "user-registration";
		userService.save(user);
		
		userService.sendMail("Реєстрація", user.getEmail(), "Дякуємо за реєстрацію на Bershka.com");
		
		return "redirect:/login";
	}
	
	@GetMapping("/login")
	public String login(@ModelAttribute("user")User user){
		return "user-login";
	}

	
	@InitBinder("user")
	protected void bind(WebDataBinder binder){
		binder.setValidator(new UserValidator(userService));
	}
	
	@GetMapping("/peoples")
	public String people(){
		return "redirect:/user/people";
	}
//	@GetMapping("/cart")
//	public String cart(Model model){
////		model.addAttribute("items", itemService.findAll());
//		return "user-cart";
//	}
	
}
