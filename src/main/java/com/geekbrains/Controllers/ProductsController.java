package com.geekbrains.Controllers;

import com.geekbrains.Entities.Product;
import com.geekbrains.Entities.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String newProduct() {
        return "newProduct";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getForm(@RequestParam Integer id, @RequestParam String name, @RequestParam Double cost) {
        productRepository.addProduct(new Product(id, name, cost));
        return "redirect:/products";
    }
}
