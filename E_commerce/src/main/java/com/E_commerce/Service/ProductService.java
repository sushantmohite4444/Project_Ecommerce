
package com.E_commerce.Service;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.E_commerce.DAO.Product_dao;
import com.E_commerce.Modal.Product;



@Service
public class ProductService {

	@Autowired
	Product_dao product_dao;
	
	
	
	public List<Product> getProducts() {


		List<Product> product =  product_dao.findAll();
//		product.add(product_dao.getById(1));
//		System.out.println(product_dao.getById(1));
//		
				System.out.println(product);
		
	
		return product;
	}



	public Product addproduct(Product product ) {
		
		return product_dao.save(product);
	}
	
	public Product getProdut(int id) {
		// TODO Auto-generated method stub
	
	return	  product_dao.findById(id).orElse(null);
		
		
		
	}



	public void deleteproduct(Integer id) {
	
		product_dao.deleteById(id);;
	}



	public List<Product> searchProduct(String keyword) {
		
		
		
		return product_dao.searchProduct(keyword);
	}

}
