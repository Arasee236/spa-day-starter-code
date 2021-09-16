package org.launchcode.spaday.controllers;

import org.launchcode.spaday.controllers.data.UserData;
import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping("add")
    public String displayAddUserForm(Model model) {
        model.addAttribute("title", "Add User");
        return "user/add";
    }

    @PostMapping("add")
    public String processAddUserForm(Model model, @ModelAttribute User user, String verify) {
        // add form submission handling code here
        //model.addAttribute("verify",verify);

        if (verify.equals(user.getPassword())) {
            UserData.addUser(user);
            model.addAttribute("greeting", "Welcome , " + user.getUserName() +"!");
            return "user/index";
        } else {
            model.addAttribute("error","Passwords do not match");
            return "user/add";
        }

    }

//    @GetMapping("index")
//    public String displayUserIndexForm(Model model,User user) {
//        model.addAttribute("title", "welcome");
//        model.addAttribute("Username",user.getUsername());
//        return "user/index";
//    }
}
