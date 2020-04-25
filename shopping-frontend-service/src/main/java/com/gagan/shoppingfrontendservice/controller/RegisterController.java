package com.gagan.shoppingfrontendservice.controller;

import com.gagan.shoppingfrontendservice.model.Customer;
import com.gagan.shoppingfrontendservice.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * @author Gagandeep
 * @date 25-04-2020
 * @time 02:09
 */
@Controller
@RequestMapping("/RegisterCtrl")
public class RegisterController {

    @Autowired
    private LoginService service;

    @RequestMapping("/register")
    public String showRegistrationPage(Model model){
        model.addAttribute("customer", new Customer());
        return "RegistrationPage";
    }

    @PostMapping("/validate")
    public String validate(@Valid Customer customer, BindingResult result, Model model){
        if (result.hasErrors())
            return "RegistrationPage";
        else {
            service.registerUser(customer);
            return "redirect:/LoginCtrl/login";
        }
    }
}
