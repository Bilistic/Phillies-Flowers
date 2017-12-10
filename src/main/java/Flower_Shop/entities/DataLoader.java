package Flower_Shop.entities;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import Flower_Shop.Repositories.BasketRepo;
import Flower_Shop.Repositories.ItemRepo;
import Flower_Shop.Supplier.Services.SupplierServiceImpl;

@Component
public class DataLoader implements ApplicationRunner{

	@Autowired
	ItemRepo ir;
	
	@Autowired
	BasketRepo BR;
	
	@Autowired
	SupplierServiceImpl ssi;
	
	@Override
	public void run(ApplicationArguments arg0) throws Exception {
		// TODO Auto-generated method stub
		Item i1 = new Item(1, "Red Rose", 15);
		Item i2 = new Item(2, "Pink Tulip", 10);
		ir.save(i1);
		ir.save(i2);
		ir.save(new Item(3, "Yellow Tulip", 5));
		Basket b = new Basket(1);
		
		System.out.println(ssi.getItem(1));
	}

}
