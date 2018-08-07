package com.fpoly.lab6.entity.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.fpoly.lab6.entity.Product;

@Repository
public class ProductRepository {

	public List<Product> getProductList() {
		List<Product> ds = new ArrayList<>();
		ds.add(new Product(1, "Iphone X", 120, new BigDecimal(50000000)));
		ds.add(new Product(2, "Xiaomi Redmi Note 5", 454, new BigDecimal(3599000)));
		ds.add(new Product(3, "Samsung galaxy s100", 30, new BigDecimal(15989987)));
		ds.add(new Product(4, "Thẻ nhớ microSD Kingston 16GB", 500, new BigDecimal(20000)));
		ds.add(new Product(5, "Asus zenphone 9", 1243, new BigDecimal(523233)));
		return ds;
	}
	
	public Product getProduct(int id) {
		List<Product> list = getProductList();
		Product p;
		for(Product x : list) {
			if(x.getId() == id) {
				p = x;
				return p;
			}
		}
		return null;
	}
}
