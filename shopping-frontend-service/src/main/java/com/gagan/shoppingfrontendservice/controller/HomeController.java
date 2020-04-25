package com.gagan.shoppingfrontendservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.gagan.shoppingfrontendservice.config.Helper.currentUser;


/**
 * @author Gagandeep
 * @date 24-04-2020
 * @time 13:31
 */

@Controller
public class HomeController {

    @RequestMapping("/")
    public String showIndex(Model model){
        model.addAttribute("hello", "Hello World");
        return "redirect:/LoginCtrl/login";
    }

    @RequestMapping("/home")
    public String showHome(Model model){
        model.addAttribute("user", currentUser);
        return "Home";
    }
}
