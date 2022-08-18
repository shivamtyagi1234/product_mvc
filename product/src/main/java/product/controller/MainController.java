package product.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import org.springframework.web.servlet.view.RedirectView;

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
			
		/*
		 * for(int i=0;i<products.size();i++) {
		 * System.out.println(products.get(i).getId());
		 * System.out.println(products.get(i).getName());
		 * System.out.println(products.get(i).getDescription());
		 * System.out.println(products.get(i).getPrice()); }
		 */
			 
		 return "index";
	  }
	  
	@RequestMapping("/add-product")
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
	@RequestMapping("/fetch/{productId}")
	public Product fetchProduct(@PathVariable("productId") int pid) {
		Product p1=productDao.getProduct(pid);
		System.out.println("Product by id: "+pid+" :: "+p1);
		return p1;
	}
	
	@RequestMapping("/load-product")
	public String loadProduct(Model m,HttpServletRequest request) {
		m.addAttribute("title", "Product App");
		 List<Product> products= productDao.getALLProduct();
		 
			/*
			 * for(int i=0;i<products.size();i++) {
			 * System.out.println(products.get(i).getId());
			 * System.out.println(products.get(i).getName());
			 * System.out.println(products.get(i).getDescription());
			 * System.out.println(products.get(i).getPrice()); }
			 */
			 
		 m.addAttribute("product",products);
		 return "productdetails";
	}
	
	//Delete Product Handler
	
	@RequestMapping("/delete/{productId}")
	public RedirectView deleteProduct(@PathVariable("productId") int productId, HttpServletRequest request) {
		this.productDao.deleteProduct(productId);
		RedirectView redirectView=new RedirectView();
		System.out.println("request.getContentType: "+request.getContextPath());
		redirectView.setUrl(request.getContextPath()+"/load-product");
		return redirectView;
	}
	
	//Update Product Handler
	@RequestMapping("/update/{productId}")
	public String update(@PathVariable("productId") int productId, Model m) {
		Product product=this.productDao.getProduct(productId);
		
		/*
		 * System.out.println("Product Name: "+product.getName());
		 * System.out.println("Product Description: "+product.getDescription());
		 * System.out.println("Product Price: "+product.getPrice());
		 */
		 
		System.out.println(product);
		m.addAttribute("product", product);
		
		return "updateproduct";
	}
	
	@RequestMapping(value="/update-product",method=RequestMethod.POST)
	public RedirectView updateIproduct(@ModelAttribute Product p,HttpServletRequest request) {
		this.productDao.createProduct(p);
		RedirectView redirectView=new RedirectView();
		redirectView.setUrl(request.getContextPath()+"/load-product");
		return redirectView;
	}
	
}