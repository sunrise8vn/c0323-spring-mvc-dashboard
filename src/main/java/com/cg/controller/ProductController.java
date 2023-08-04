package com.cg.controller;


import com.cg.model.Product;
import com.cg.service.IProductService;
import com.cg.service.ProductServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {

    private IProductService productService = new ProductServiceImpl();

    @GetMapping("/cp/products")
    public String showListPage(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "cp/product/list";
    }


    @GetMapping("/cp/products/create")
    public String showCreatePage(Model model) {
        model.addAttribute("success", false);
        model.addAttribute("message", "");
        return "cp/product/create";
    }

    @GetMapping("/cp/products/{productId}")
    public String showUpdatePage(@PathVariable Long productId, Model model) {

        Optional<Product> productOptional = productService.findById(productId);

        if (productOptional.isEmpty()) {
            model.addAttribute("error", true);
            model.addAttribute("message", "Sản phẩm không tồn tại");
        }
        else {
            model.addAttribute("error", false);
            model.addAttribute("message", "");

            model.addAttribute("product", productOptional.get());
        }

        return "cp/product/edit";
    }

    @PostMapping("/cp/products/create")
    public String create(@ModelAttribute Product product, Model model) {

        productService.add(product);

        model.addAttribute("success", true);
        model.addAttribute("message", "Thêm sản phẩm thành công");

        return "cp/product/create";
    }

    @PostMapping("/cp/products/{productId}")
    public String update(@PathVariable Long productId, @ModelAttribute Product product, Model model) {
        Optional<Product> productOptional = productService.findById(productId);

        if (productOptional.isEmpty()) {
            model.addAttribute("error", true);
            model.addAttribute("message", "Sản phẩm không tồn tại");
        }
        else {
            product.setId(productId);
           productService.update(product);
        }

        return "redirect: /cp/products";
    }

}
