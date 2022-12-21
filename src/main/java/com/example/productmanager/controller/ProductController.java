package com.example.productmanager.controller;

import com.example.productmanager.domain.Product;
import com.example.productmanager.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/products/new")
    public String postForm() {
        return "products/postProductForm";
    }

    @PostMapping("/products/new")
    public String postProduct(Product product) {
        productService.join(product);
        return "redirect:/";
    }

    @GetMapping("/products")
    public String listProducts(Model model) {
        model.addAttribute("products", productService.findMembers());
        return "products/products";
    }

    @GetMapping("/products/{no}/update")
    public String updateProductForm(@PathVariable("no") Long no, Model model) {
        Product product = productService.findOne(no);
        model.addAttribute("product", product);
        return "products/productUpdateForm";
    }

    @PostMapping("/products/{no}/update")
    public String updateProduct(@PathVariable("no") Long no,
                                @ModelAttribute Product product) {
        productService.update(product);
        return "redirect:/products";
    }
    @GetMapping("/products/{no}/delete")
    public String deleteProduct(@PathVariable("no") Long no) {
        productService.delete(no);

        return "redirect:/products";
    }
}
