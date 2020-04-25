package com.gagan.shoppingfrontendservice.controller;

import com.gagan.shoppingfrontendservice.model.Product;
import com.gagan.shoppingfrontendservice.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static com.gagan.shoppingfrontendservice.config.Helper.currentUser;
import static com.gagan.shoppingfrontendservice.service.ProductServiceImpl.cart;
import static com.gagan.shoppingfrontendservice.service.ProductServiceImpl.products;

/**
 * @author Gagandeep
 * @date 24-04-2020
 * @time 17:51
 */

@Controller
@RequestMapping("/ShoppingCtrl")
public class ShoppingController {

    private Logger logger = LoggerFactory.getLogger(ShoppingController.class);

    @Autowired
    private ProductService productService;

    @RequestMapping("/home")
    public ModelAndView showCatalog(Model model){
        return new ModelAndView("Home", "user", currentUser);
    }

    @RequestMapping("/productcatalog")
    public String showProducts(Model model){
        List<Product> newProducts;
                if(products==null || products.size()<=0)
                    newProducts= productService.fetchAllProducts();
        model.addAttribute("products", products);
        model.addAttribute("cart", cart);
        return "ProductCatalog";
    }

    @PostMapping("/addtocart/{id}")
    public String addItemToCart(@PathVariable Integer id, Model model){
        productService.addToCart(id, 1);
        model.addAttribute("products", products);
        model.addAttribute("cart", cart);
        model.addAttribute("message", "Item Added!!");
        return "ProductCatalog";
    }

    @PostMapping("/removefromcart/{id}")
    public String deleteItemFromCart(@PathVariable Integer id, Model model){
        productService.deleteFromCart(id);
        model.addAttribute("products", products);
        model.addAttribute("cart", cart);
        return "ProductCatalog";
    }

    @RequestMapping("/showcart")
    public String showCart(Model model){
        model.addAttribute("products", products);
        model.addAttribute("cart", cart);
        return "CartItems";
    }

    @RequestMapping("/checkout")
    public String generateBill(){
        return "redirect:/PurchaseCtrl/generatebill";
    }

}
