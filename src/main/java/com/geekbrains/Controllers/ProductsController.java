package com.geekbrains.Controllers;

import com.geekbrains.Author;
import com.geekbrains.Entities.Product;
import com.geekbrains.Entities.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductsController {
    ProductRepository productRepository;

    public ProductsController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
        public String showAllProducts(Model uiModel) {
        uiModel.addAttribute("products", productRepository.getProducts());
        return "home";
    }
        @GetMapping("/new")
    public String newProduct()  {
        return "newProduct";
    }

//    @GetMapping("/addProduct")
//    public String addProduct(@RequestParam(required = false) Integer id,
//                             Model model) {
//        Product product;
//        model.addAttribute("product", product);
//        model.addAttribute("disabled", view);
//        model.addAttribute("currentPage", "products");
//
//        return "product_form";
//    }


}
