package Flower_Shop.entities;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import Flower_Shop.Repositories.BasketRepo;
import Flower_Shop.Repositories.ItemRepo;
import Flower_Shop.Repositories.StatisticRepo;

@Component
public class DataLoader implements ApplicationRunner{

	@Autowired
	ItemRepo ir;
	
	@Autowired
	BasketRepo BR;
	
	@Autowired
	Statistic stat;
	
	@Override
	public void run(ApplicationArguments arg0) throws Exception {
		// TODO Auto-generated method stub
		Item i1 = new Item(1, "Red Rose", 15);
		Item i2 = new Item(2, "Pink Tulip", 10);
		ir.save(i1);
		ir.save(i2);
		ir.save(new Item(3, "Yellow Tulip", 5));
		Basket b = new Basket(1);
		b.add(i1, 1);
		b.add(i2, 1);
		BR.save(b);
		
		List<Item> orderItems = new ArrayList<Item>();
		orderItems.add(i1);
		orderItems.add(i2);
		double total= i1.getCost()+ i2.getCost();
		Order o1 = new Order(1,orderItems,total,"Date,time,address");
		Order o2 = new Order(1,orderItems,total,"Date,time,address");
	
		stat.setUserBalance(10.00);
	}
}
