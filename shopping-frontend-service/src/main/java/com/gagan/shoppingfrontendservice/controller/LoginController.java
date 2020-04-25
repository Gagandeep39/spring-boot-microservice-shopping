package com.gagan.shoppingfrontendservice.controller;

import com.gagan.shoppingfrontendservice.exception.CustomerNotFoundException;
import com.gagan.shoppingfrontendservice.model.Customer;
import com.gagan.shoppingfrontendservice.model.User;
import com.gagan.shoppingfrontendservice.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

import static com.gagan.shoppingfrontendservice.config.Helper.currentUser;

/**
 * @author Gagandeep
 * @date 24-04-2020
 * @time 13:30
 */

@Controller
@RequestMapping("/LoginCtrl")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/login")
    public String showLoginPage(Model model){
        model.addAttribute("user", new User());
        return "LoginPage";
    }

    @PostMapping("/validate")
    public String validate(@Valid User user, BindingResult bindingResult, Model model) throws CustomerNotFoundException {
        Customer customer;
        if (bindingResult.hasErrors()) {
            return "LoginPage";
        }else {
            customer = loginService.validateLogin(user);
            currentUser = customer;
            model.addAttribute("user", currentUser);
            return "redirect:/LoginCtrl/home";
        }
    }

    @GetMapping("/home")
    public String homeScreen(){
        return "redirect:/home";
    }

    @GetMapping("/logout")
    public String logOut(Model model){
        currentUser = new Customer();
        return "redirect:/LoginCtrl/login";
    }
}
