package product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import product.model.Product;
import product.service.ProductService;

@Controller
public class MainController {

	
	  @Autowired 
	  private ProductService service;
	 
	@RequestMapping("/add")
	public String addProduct(Model m) {
		
		m.addAttribute("title", "Product App");
		return "addproduct";
	}
	
	//Adding Product form
	@RequestMapping(value="/registration",method=RequestMethod.POST)
	public String productAdded(@RequestParam("name") String name, @RequestParam("description") String description, @RequestParam("price") int price) {
	//	public String productAdded(@ModelAttribute Product p) {
		//System.out.println(p);
		Product p=new Product(100,name,description,price);
		this.service.saveProduct(p);
		System.out.println(p);
		return "registration";
	}
}