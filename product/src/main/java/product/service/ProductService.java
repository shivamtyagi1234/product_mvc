package product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import product.dao.ProductDao;
import product.model.Product;

@Service
public class ProductService {

	@Autowired
	private ProductDao productDao;
	public void saveProduct(Product product) {
		this.productDao.createProduct(product);
	}
	
	public Product getProductById(int id) {
		Product p1=this.productDao.getProduct(id);
	//System.out.println("Product by id: "+p1);
		return p1;
	}

}
