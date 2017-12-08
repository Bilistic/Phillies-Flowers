package Flower_Shop.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import Flower_Shop.Repositories.ItemRepo;
import Flower_Shop.entities.Item;
import Flower_Shop.entities.Statistic;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	ItemRepo IR;
	
	@Autowired
	Statistic stats;
	
	@GetMapping("/admin/statistic")
	public String statistics_page(Model model)
	{
		List<Item> items = IR.findAll();
		model.addAttribute("Statistics", stats);
		model.addAttribute("items", items);
		return "index";
	}	

}
