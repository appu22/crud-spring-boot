package com.codezone.codezonejpa.restcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codezone.codezonejpa.entity.Product;
import com.codezone.codezonejpa.service.ProductService;

@RestController
@RequestMapping("product")
public class ProductController {

	@Autowired
	ProductService productService;

	@PostMapping("/save")
	public Product save(@RequestBody Product product) {
		System.out.println(product);
		return productService.save(product);
	}

	public String update(Product product) {
		System.out.println(product);
		return "deleted success..";
	}

	public String delete(Long id) {
		System.out.println(id);
		return "deleted success..";
	}

	@GetMapping("/getAll")
	public List<Product> getAll() {
		System.out.println("get all ");
		// list return
		
		List<Product> list = productService.getAllProducts();
		return list;
	}

	@GetMapping("/{id}")
	public Optional<Product> productGetById(@PathVariable("id") String id) {
		System.out.println(id);
		return productService.getById(id);
	}

}
