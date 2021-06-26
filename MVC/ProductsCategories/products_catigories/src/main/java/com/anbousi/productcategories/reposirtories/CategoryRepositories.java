package com.anbousi.productcategories.reposirtories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.anbousi.productcategories.models.Category;
import com.anbousi.productcategories.models.Product;

@Repository
public interface CategoryRepositories extends CrudRepository<Category, Long> {
	List<Category> findAll();
	List<Category> findByProductsIsNull();
	List<Category> findByProductsNotContains(Product product);
}