package com.codezone.codezonejpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codezone.codezonejpa.dao.ProductDao;
import com.codezone.codezonejpa.entity.Product;

@Service
public class ProductService {

	@Autowired
	ProductDao dao;

	/**
	 * save products 
	 * based on quantity multiply products price and set the total price
	 * @param product
	 * @return
	 */
	public Product save(Product product) {
		double qunty = product.getQuantity();
		double price = product.getProductPrice();
		price = price * qunty;
		product.setTotalPrice(price);
		Product save = dao.save(product);
		return save;
	}
	/**
	 * Get products by id
	 * @param id
	 * @return
	 */
	public Optional<Product> getById(String id) {
		long id1 = Long.parseLong(id);
		Optional<Product> product = dao.findById(id1);
		return product;
	}
	/**
	 * Get All products 
	 * @return
	 */
	public List<Product> getAllProducts() {
		return dao.findAll();
	}

}
