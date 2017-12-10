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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Flower_Shop.Repositories.ItemRepo;
import Flower_Shop.Repositories.StaffRepo;
import Flower_Shop.entities.Item;
import Flower_Shop.entities.Staff;
import Flower_Shop.entities.Statistic;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	private static final String POSITION = "position";
	private static final String FIRSTNAME = "firstname";
	private static final String LASTNAME = "lastname";
	private static final String PASSWORD = "password";
	
	@Autowired
	ItemRepo IR;
	
	@Autowired
	Statistic stats;
	
	@Autowired
	StaffRepo SR;
	
	@GetMapping("/statistic")
	public String statistics_page(Model model)
	{
		List<Staff> staff = SR.findAll();
		List<Item> items = IR.findAll();
		model.addAttribute("Statistics", stats);
		model.addAttribute("items", items);
		model.addAttribute("Staff", staff);
		return "adminPanel";
	}	
	
	@RequestMapping(method = RequestMethod.PUT, value = "/staff/edit", consumes = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<Void> EditStaff(@RequestBody Map<String, String> body){
		Staff staff = SR.findOne(Integer.parseInt(body.get("id")));
		staff.setPosition(body.get(POSITION));
		SR.delete(Integer.parseInt(body.get("id")));
		SR.save(staff);
		return new ResponseEntity<Void>(HttpStatus.OK);	
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/staff/add", consumes = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<Void> CreateStaff(@RequestBody Map<String, String> body){
		SR.save(new Staff((int)SR.count(), body.get(FIRSTNAME), body.get(LASTNAME), body.get(POSITION), body.get(PASSWORD) ));
		return new ResponseEntity<Void>(HttpStatus.OK);	
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/staff/get", produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<List<Staff>> viewOrder(){
		List<Staff> staff = SR.findAll();
		return new ResponseEntity<List<Staff>>(staff, HttpStatus.OK);
	}
	
	

}
