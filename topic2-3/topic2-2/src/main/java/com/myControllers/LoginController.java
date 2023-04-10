package com.myControllers;


import com.myModels.LoginModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller // for websites
@RequestMapping("/login") // default url
public class LoginController {

    @GetMapping("/")
    public String displayLoginForm(Model model){

        // attributeName: how we identify our variable in the html, object attribute, in this case we're creating a new object
        model.addAttribute("loginModel", new LoginModel()); // LoginModel class receives userName and password, check loginForm.html
        return "loginForm";
    }

    // processLogin receives as parameters LoginModel (from displayLoginForm method)
    // BindingResult takes whatever was put on the parameter and sends it to the controller to check if there was any error in the validation
    @PostMapping("/processLogin")
    public String processLogin(@Valid LoginModel loginModel, BindingResult bindingResult, Model model){
        System.out.println("error " + bindingResult.hasErrors());
        // if there is any error, return loginForm page
        if(bindingResult.hasErrors()){
            model.addAttribute("loginModel", loginModel);

            return "loginForm";
        }
        model.addAttribute("loginModel", loginModel); // loginModel comes from the parameter given in the method.
        return "loginResults";
    }

}
