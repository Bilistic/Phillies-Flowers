package Flower_Shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
//import org.springframework.boot.web.servlet.ServletRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.h2.server.web.WebServlet;

import Flower_Shop.Supplier.Services.SupplierServiceImpl;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;


@SpringBootApplication
public class PhilliesFlowersApplication{

	public static void main(String[] args) {
	SpringApplication.run(PhilliesFlowersApplication.class, args);
	}
	
	
}
