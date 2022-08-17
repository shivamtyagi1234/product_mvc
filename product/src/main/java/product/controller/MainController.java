package product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import product.dao.ProductDao;
import product.model.Product;
import product.service.ProductService;

@Controller
public class MainController {

	
	  @Autowired 
	  private ProductService service;
	
	  @Autowired
	  private ProductDao productDao;
	  
	  @RequestMapping("/")
	  public String home(Model m) {
		 List<Product> products= productDao.getALLProduct();
		 m.addAttribute("product",products);
		 System.out.println(products);
			
		// m.addAttribute("pid",products.get(0).getId()+"");
			
			  for(int i=0;i<products.size();i++) {
			  System.out.println(products.get(i).getId());
			  System.out.println(products.get(i).getName());
			  System.out.println(products.get(i).getDescription());
			  System.out.println(products.get(i).getPrice()); }
			 
			 
		 return "index";
	  }
	  
	@RequestMapping("/add")
	public String addProduct(Model m) {
		m.addAttribute("title", "Product App");
		 List<Product> products= productDao.getALLProduct();
		 
			  for(int i=0;i<products.size();i++) {
			  System.out.println(products.get(i).getId());
			  System.out.println(products.get(i).getName());
			  System.out.println(products.get(i).getDescription());
			  System.out.println(products.get(i).getPrice()); 
			  }
			 
		 m.addAttribute("product",products);
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
	@RequestMapping(value="/fetch/{pid}",method=RequestMethod.GET)
	public Product fetchProduct(@PathVariable int pid) {
		Product p1=this.service.getProductById(pid);
		System.out.println("Product by id: "+pid+" :: "+p1);
		return p1;
	}
	
}