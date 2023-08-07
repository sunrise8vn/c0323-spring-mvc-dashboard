package com.cg.controller;


import com.cg.model.Category;
import com.cg.model.Product;
import com.cg.service.category.ICategoryService;
import com.cg.service.product.IProductService;
import com.cg.service.product.ProductServiceImpl;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/cp/products")
public class ProductController {

//    private IProductService productService = new ProductServiceImpl();

    @Autowired
    private IProductService productService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping
    public String showListPage(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "cp/product/list";
    }


    @GetMapping("/create")
    public String showCreatePage(Model model) {

        List<Category> categories = categoryService.findAll();

        model.addAttribute("success", false);
        model.addAttribute("message", "");

        model.addAttribute("categories", categories);

        return "cp/product/create";
    }

    @GetMapping("/{productId}")
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

    @PostMapping("/create")
    public String create(@ModelAttribute Product product, Model model) {

        productService.save(product);

        model.addAttribute("success", true);
        model.addAttribute("message", "Thêm sản phẩm thành công");

        return "cp/product/create";
    }

    @PostMapping("/{productId}")
    public String update(@PathVariable Long productId, @ModelAttribute Product product, Model model) {
//        Optional<Product> productOptional = productService.findById(productId);
//
//        if (productOptional.isEmpty()) {
//            model.addAttribute("error", true);
//            model.addAttribute("message", "Sản phẩm không tồn tại");
//        }
//        else {
//            product.setId(productId);
//           productService.update(product);
//        }

        return "redirect: /cp/products";
    }

}
