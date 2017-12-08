package Flower_Shop.Controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Flower_Shop.Repositories.BasketRepo;
import Flower_Shop.Repositories.ItemRepo;
import Flower_Shop.Repositories.OrderRepo;
import Flower_Shop.Repositories.StatisticRepo;
import Flower_Shop.entities.Basket;
import Flower_Shop.entities.Item;
import Flower_Shop.entities.Order;
import Flower_Shop.entities.Statistic;

@Controller
@RequestMapping("/shop")
public class Controllers {
	
	@Autowired
	ItemRepo IR;
	
	@Autowired
	BasketRepo BR;
	
	@Autowired
	OrderRepo OR;
	
	@Autowired
	Statistic stats;
	
	private static final String OPERATION = "operation";
	private static final String COUNTER = "count";
	
	@GetMapping("/admin")
	public String admin_panel(Model model)
	{
		return "admin";
	}
	
	@GetMapping("/")
	public String home_page(Model model)
	{
		List<Item> items = IR.findAll();
		model.addAttribute("items", items);
		return "index";
	}
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/{itemID}", produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<Item> showItems(@PathVariable int itemID)
	{
		Item item = (Item)IR.findOne(itemID);
		return new ResponseEntity<Item>(item, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/cart/{cartID}", produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<Basket> showCart(@PathVariable int cartID)
	{
		Basket basket = BR.findOne(cartID);
		return new ResponseEntity<Basket>(basket, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/cart/{cartID}/{itemID}", consumes = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<Void> editCart(@PathVariable int cartID, @PathVariable int itemID, @RequestBody Map<String, String> body)
	{
		String operation = get_operation(body);
		String count = get_count(body);
		Basket basket = BR.findOne(cartID);
		Item item = (Item)IR.findOne(itemID);
		if(operation.equals("ADD")){
			basket.add(item, Integer.parseInt(count));
		}else if(operation.equals("REMOVE")){
			basket.remove(item);
		}
		BR.save(basket);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	private String get_operation(Map<String, String> body){
		String value = null;
		if(body.containsKey(OPERATION)){
			value = body.get(OPERATION);
		}
		return value;
	}
	
	private String get_count(Map<String, String> body){
		String value = null;
		if(body.containsKey(COUNTER)){
			value = body.get(COUNTER);
		}
		return value;
	}
	
}
