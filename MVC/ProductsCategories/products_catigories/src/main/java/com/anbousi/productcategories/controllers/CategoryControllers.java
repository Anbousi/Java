package com.anbousi.productcategories.controllers;

import java.util.List;

import javax.validation.Valid;

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
public class CategoryControllers {
	
	private final ProductsCategoriesServices appService;
	
public CategoryControllers(ProductsCategoriesServices appService) {
		this.appService = appService;
	}



	@RequestMapping("/categories/new")
	public String productPage(@ModelAttribute("category") Category category) {
		return "category.jsp";
	}
	
//	New Category Form Page
	@RequestMapping(value="/catigories/new" , method=RequestMethod.POST)
    public String newCategory(@Valid @ModelAttribute("category") Category category , BindingResult result) {
		if (result.hasErrors()) {
            return "category.jsp";
        } else {
        	appService.createCategory(category);
            return "redirect:/";
        }
		
	 }
	
//	Show all Categories
	@RequestMapping(value="/categories", method=RequestMethod.GET)
    public String showCategories(Model model) {
		List<Category> categories = appService.findAllCategories();
        model.addAttribute("categories", categories);
        return "allcategories.jsp";
    }
	
	
//	Delete a Category
	@RequestMapping(value="/categories/delete/{id}", method=RequestMethod.GET)
    public String deleteProduct(Model model, @PathVariable("id") Long id) {
		appService.deleteCategoryById(id);
        return "redirect:/categories";
    }
	
//	Show a Category
	@RequestMapping(value="/categories/{id}", method=RequestMethod.GET)
    public String showProduct(Model model, @PathVariable("id") Long id , @ModelAttribute("category") Product product1) {
		Category category = appService.findCategoryById(id);
//		List<Product> products = appService.findNotAddedProducts();
		List<Product> products = appService.findByCategoriesNotContains(category);
        model.addAttribute("category", category);
        model.addAttribute("products", products);
        return "show_category.jsp";
    }
	
//	Add a Category to Product
	@RequestMapping(value="/categories/{id}", method=RequestMethod.POST)
    public String addCatageryToProduct(Model model, @PathVariable("id") Long id , @Valid @ModelAttribute("products") Category category1, BindingResult result, @RequestParam(value="products") Long proId) {
		if(proId == 0) {
			return "redirect:/categories/{id}";
		}
		appService.addCategoryToProduct(id , proId);
        return "redirect:/categories/{id}";
    }
	
//	Remove Product from Category
	@RequestMapping(value="/categories/{cid}/delete/{pid}")
    public String RemoveaCatageryFromProduct(Model model, @PathVariable("pid") Long pid , @PathVariable("cid") Long cid) {
		appService.RemoveCategoryFromProduct(pid , cid);
        return "redirect:/categories/{cid}";
    }
	
	
}

