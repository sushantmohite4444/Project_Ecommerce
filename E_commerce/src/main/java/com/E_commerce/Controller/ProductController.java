package com.E_commerce.Controller;


import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.E_commerce.Modal.Product;
import com.E_commerce.Service.ProductService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProductController {

	@Autowired
	ProductService productService;
	
	@GetMapping("/products")
	public ResponseEntity< List<Product>> getProduct() {

		return ResponseEntity.status(HttpStatus.OK).body(productService.getProducts())  ;
	}
	
//	@PostMapping("/product")
//	public ResponseEntity<Product>  addproduct(@RequestPart Product product,@RequestPart MultipartFile imageFile) {
//		
//		System.out.println(product);
//				try {
//					product.setImage(imageFile.getBytes());
//					
//				return ResponseEntity.status(HttpStatus.CREATED).body(productService.addproduct(product));
//				} catch (IOException e) {
//					e.printStackTrace();
//					return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//				}
//	}
	
	
//	@PutMapping("/product/{id}")
//	public ResponseEntity<Product> update(@RequestPart Product product,@RequestPart MultipartFile imageFile,@PathVariable ("id") Integer id) {
//		
////		if(!getproduct(id).equals(product) ) {
//				try {
//					product.setImage(imageFile.getBytes());
//					
//				return ResponseEntity.status(HttpStatus.CREATED).body(productService.addproduct(product));
//				} catch (IOException e) {
//					e.printStackTrace();
//					return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//				}
////		}
////		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//	}

	

//	@GetMapping("/product/{id}/image")
//	public ResponseEntity<byte[]>  getimage(@PathVariable ("id") int id) {
//		
//		
//	Product product=	 productService.getProdut(id);
//
//		return  (product.getImage() == null) ? ResponseEntity.status(HttpStatus.NOT_FOUND).build() : ResponseEntity.status(HttpStatus.OK).body(product.getImage());
//	}
	
	@GetMapping("/product/{id}")
	public ResponseEntity<Product>  getproduct(@PathVariable ("id") Integer id) {
		
		
	Product product=	 productService.getProdut(id);

		return  (product == null) ? ResponseEntity.status(HttpStatus.NOT_FOUND).build() : ResponseEntity.status(HttpStatus.OK).body(product);
	}
	
	
	
	
	@DeleteMapping("/product/{id}")
	public ResponseEntity<String> deleteproduct(@PathVariable ("id") Integer id){
		
		Product product =productService.getProdut(id);
		
		if(product !=null) {
		productService.deleteproduct(id);
		return ResponseEntity.status(HttpStatus.OK).body("Delete");
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("id not Present");
	}
	
	
//	@GetMapping("/product/search")
//	public ResponseEntity<List<Product>> search(@RequestParam String keyword){
//		
//		if(keyword== null) {
//			 ResponseEntity.status(HttpStatus.PROCESSING).build();
//			 
//		}
//		
//		
//		return ResponseEntity.status(HttpStatus.OK).body(productService.searchProduct(keyword));
//		
//	}
	
	
	
	
	
}
