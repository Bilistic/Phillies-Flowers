package Flower_Shop.entities;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Order {

	@Id
	private int id;
	private List<Item> ordersItems;
	private double totalCost;
	private String orderInformation;
	
	Order(){}

	public Order(int id, List<Item> ordersItems, double totalCost, String orderInformation) {
		super();
		this.id = id;
		this.ordersItems = ordersItems;
		this.totalCost = totalCost;
		this.orderInformation = orderInformation;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Item> getOrdersItems() {
		return ordersItems;
	}

	public void setOrdersItems(List<Item> ordersItems) {
		this.ordersItems = ordersItems;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public String getOrderInformation() {
		return orderInformation;
	}

	public void setOrderInformation(String orderInformation) {
		this.orderInformation = orderInformation;
	}
	

	@Override
	public String toString() {
		return "Order [id=" + id + ", ordersItems=" + ordersItems + ", totalCost=" + totalCost + ", orderInformation="
				+ orderInformation + "]";
	}
	
	
}
