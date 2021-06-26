package com.anbousi.productcategories.reposirtories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.anbousi.productcategories.models.Category;
import com.anbousi.productcategories.models.Product;

public interface ProductRepositories extends CrudRepository<Product, Long> {
	List<Product> findAll();
	List<Product> findByCategoriesIsNull();
	List<Product> findByCategoriesNotContains(Category category);
}
