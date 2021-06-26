package com.anbousi.productcategories.controllers;

import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.anbousi.productcategories.models.Category;
import com.anbousi.productcategories.models.Product;
import com.anbousi.productcategories.services.ProductsCategoriesServices;

@Controller
public class ProductControllers {
private final ProductsCategoriesServices appService;
	
	public ProductControllers(ProductsCategoriesServices appService) {
		this.appService = appService;
	}


	@RequestMapping("/products/new")
	public String productPage(@ModelAttribute("product") Product product) {
		return "product.jsp";
	}
	
//	New Product Form Page
	@RequestMapping(value="/products/new" , method=RequestMethod.POST)
    public String newProduct(@Valid @ModelAttribute("product") Product product , BindingResult result) {
		if (result.hasErrors()) {
            return "product.jsp";
        } else {
        	appService.createProduct(product);
            return "redirect:/";
        }
	}
	

//	Show all Products
	@RequestMapping(value="/products", method=RequestMethod.GET)
    public String showProducts(Model model) {
		List<Product> products = appService.findAllProducts();
        model.addAttribute("products", products);
        return "allproducts.jsp";
    }
	
//	Delete a Product
	@RequestMapping(value="/products/delete/{id}", method=RequestMethod.GET)
    public String deleteProduct(Model model, @PathVariable("id") Long id) {
		appService.deleteProductById(id);
        return "redirect:/products";
    }
	
//	Show a Product
	@RequestMapping(value="/products/{id}", method=RequestMethod.GET)
    public String showProduct(Model model, @PathVariable("id") Long id , @ModelAttribute("category") Product product1) {
		Product product = appService.findProductById(id);
//		List<Category> categories = appService.findNotAddedCategories();
		List<Category> categories = appService.findByProductsNotContains(product);
        model.addAttribute("product", product);
        model.addAttribute("categories", categories);
        return "show_product.jsp";
    }
	
//	Add a Product to Category
	@RequestMapping(value="/products/{id}", method=RequestMethod.POST)
    public String addProductToCatagery(Model model, @PathVariable("id") Long id , @Valid @ModelAttribute("category") Product product1, BindingResult result, @RequestParam(value="categories") Long catId) {
		if(catId == 0) {
			return "redirect:/products/{id}";
		}
		appService.addProductToCategory(id , catId);
        return "redirect:/products/{id}";
    }
	
//	Remove Category of a Product
	@RequestMapping(value="/products/{pid}/delete/{cid}")
    public String RemoveaProductFromCatagery(Model model, @PathVariable("pid") Long pid , @PathVariable("cid") Long cid, @Valid @ModelAttribute("category") Product product1, BindingResult result) {
		appService.RemoveProductFromCategory(pid , cid);
        return "redirect:/products/{pid}";
    }
	
	

}
