package com.anbousi.productcategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.anbousi.productcategories.models.Category;
import com.anbousi.productcategories.models.Product;
import com.anbousi.productcategories.reposirtories.CategoryRepositories;
import com.anbousi.productcategories.reposirtories.ProductRepositories;

@Service
public class ProductsCategoriesServices {

	private final ProductRepositories productRepositories;
	private final CategoryRepositories categoryRepositories;
	public ProductsCategoriesServices(ProductRepositories productRepositories, CategoryRepositories categoryRepositories) {
		this.productRepositories = productRepositories;
		this.categoryRepositories = categoryRepositories;
	}

	public List<Product> findAllProducts() {
		List<Product> products = productRepositories.findAll();
		return products;
	}

	// creates a Product
	public Product createProduct(Product p) {
	    return productRepositories.save(p);
	}

	// retrieves a product
	public Product findProductById(Long id) {
	    Optional<Product> optionalProduct = productRepositories.findById(id);
	    if(optionalProduct.isPresent()) {
	        return optionalProduct.get();
	    } else {
	        return null;
	    }
	}
	
	public void deleteProductById(Long id) {
		productRepositories.deleteById(id);
	}
	
	
	
	public List<Category> findNotAddedCategories() {
		List<Category> categories = categoryRepositories.findByProductsIsNull();
		return categories;
	}
	
	
//	public List<Category> findByProductsNotIn(Long id) {
//		Product p = findProductById(id);
//		List<Category> categories = productRepositories.findByProductsNotIn(p);
//		return categories;
//	}
	
	public List<Category> findByProductsNotContains(Product product) {
		return categoryRepositories.findByProductsNotContains(product);
	}
	
	public List<Product> findByCategoriesNotContains(Category category) {
		return productRepositories.findByCategoriesNotContains(category);
	}
	
	public void addProductToCategory(Long id, Long catId) {
		Product p = findProductById(id);
		Category c = findCategoryById(catId);
		List<Category> pc = p.getCategories();
		pc.add(c);
		p.setCategories(pc);
		productRepositories.save(p);
	}
	
	

	public void RemoveProductFromCategory(Long pid, Long cid) {
		Product p = findProductById(pid);
		Category c = findCategoryById(cid);
		List<Category> pc = p.getCategories();
		pc.remove(c);
		p.setCategories(pc);
		productRepositories.save(p);
	}



	//-----------------------------------------------------------------------

	public List<Category> findAllCategories() {
		List<Category> categories = categoryRepositories.findAll();
		return categories;
	}

	// creates a Category
	public Category createCategory(Category c) {
	    return categoryRepositories.save(c);
	}

	// retrieves a product
	public Category findCategoryById(Long id) {
	    Optional<Category> optionalCategory = categoryRepositories.findById(id);
	    if(optionalCategory.isPresent()) {
	        return optionalCategory.get();
	    } else {
	        return null;
	    }
	}
	
	public void deleteCategoryById(Long id) {
		categoryRepositories.deleteById(id);
	}

	public List<Product> findNotAddedProducts() {
		List<Product> products = productRepositories.findByCategoriesIsNull();
		return products;
	}

	public void addCategoryToProduct(Long id, Long proId) {
		Product p = findProductById(proId);
		Category c = findCategoryById(id);
		List<Product> pc = c.getProducts();
		pc.add(p);
		c.setProducts(pc);;
		categoryRepositories.save(c);

		
	}
	
	
	public void RemoveCategoryFromProduct(Long pid, Long cid) {
		Product p = findProductById(pid);
		Category c = findCategoryById(cid);
		List<Product> pc = c.getProducts();
		pc.remove(p);
		c.setProducts(pc);
		categoryRepositories.save(c);
	}







}
