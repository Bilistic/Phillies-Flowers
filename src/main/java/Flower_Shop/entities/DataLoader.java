package Flower_Shop.entities;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import Flower_Shop.Repositories.BasketRepo;
import Flower_Shop.Repositories.ItemRepo;
import Flower_Shop.Repositories.OrderRepo;
import Flower_Shop.Repositories.StaffRepo;

@Component
public class DataLoader implements ApplicationRunner{

	@Autowired
	ItemRepo ir;
	
	@Autowired
	BasketRepo BR;
	
	@Autowired
	Statistic stat;
	
	@Autowired
	OrderRepo OR;
	
	@Autowired
	StaffRepo SR;
	
	@Override
	public void run(ApplicationArguments arg0) throws Exception {
		// TODO Auto-generated method stub
		Item i1 = new Item(1, "Red Rose", 15);
		Item i2 = new Item(2, "Pink Tulip", 10);
		ir.save(i1);
		ir.save(i2);
		ir.save(new Item(3, "Yellow Tulip", 5));
		
		//Initialise a new basket
		Basket b = new Basket(1);
		
		//Initialise previous orders
		List<Order> orders = OR.findAll();
		for(Order x : orders){
			stat.addOrder(x);
		}
		//Initialise Administrator account
		Staff admin = SR.findOne(0);
		if(admin == null){
			SR.save(new Staff(0, "Admin", "Admin", "Administrator", "Password"));
		}
	}

}
