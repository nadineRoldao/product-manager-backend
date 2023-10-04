package com.nadine.productmanager.controller;

import com.nadine.productmanager.dto.CategoryDTO;
import com.nadine.productmanager.enums.ProductCategory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {

   @GetMapping("products/categories/list")
   @CrossOrigin(origins = "http://localhost:4200")
   public List<CategoryDTO> getCategories() {
       return ProductCategory.forList();
   }

}
