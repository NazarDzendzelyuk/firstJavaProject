package ua.com.Bershka.controller.user;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import ua.com.Bershka.Classes.Item;
import ua.com.Bershka.Service.CommodityService;
import ua.com.Bershka.Service.ItemService;
import ua.com.Bershka.Service.UserService;

@Controller
public class ItemController {
	@Autowired
	UserService userService;
	
	@Autowired
	private CommodityService commodityService;
	
	@Autowired
	private ItemService itemService;
	
	@GetMapping("/user/details/save/{id}")
	private String save(@ModelAttribute("item") Item item,@PathVariable int id,Principal principal, SessionStatus status){
		if(principal!=null){
			item.setUserName(principal.getName());
			item.setItemName(commodityService.findOne(id).getCommodity());
			item.setTotalPrice(commodityService.findOne(id).getPrice());
			item.setAddress(userService.findByEmail(principal.getName()).getAddress());
			item.setPhone(userService.findByEmail(principal.getName()).getPhoneNumber());
			itemService.save(item);
			status.setComplete();
		}
		return "redirect:/details/{id}";
	}
	@RequestMapping("/cart")
	private String cart(Model model,Principal principal){
		int totalPrice=0;
		if(principal!=null){
			model.addAttribute("items", itemService.findByUserAndStatus(principal.getName(), 0));
			for (Item item : itemService.findByUserAndStatus(principal.getName(), 0)) {
				totalPrice=item.getTotalPrice()+totalPrice;
			}
			model.addAttribute("totalPrices", totalPrice);
		}
		return "user-cart";
	}
	@RequestMapping("/checkOut")
	private String checkOut(Principal principal){
			if(principal!=null){
				for (Item item : itemService.findByUserAndStatus(principal.getName(), 0)) {
					item.setStatus(1);
					itemService.save(item);
				}
			}
		return "redirect:/";
	}
	@GetMapping("delete/{id}")
	private String delete(@PathVariable int id){
			itemService.delete(id);
		return "redirect:/cart";
	}
	
}
