package org.launchcode.spaday.controllers;

import org.launchcode.spaday.controllers.data.UserData;
import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;

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
        model.addAttribute("userName", user.getUserName());
        model.addAttribute("email", user.getEmail());

        if (verify.equals(user.getPassword())) {
            UserData.addUser(user);
         //   LocalDate dateCreated = LocalDate.now();
            user.setDateCreated(LocalDate.now());
            model.addAttribute("greeting", "Welcome , " + user.getUserName() + "!");
            model.addAttribute("users", UserData.getAll());
            return "user/index";
        } else {
            model.addAttribute("error", "Passwords do not match");
            return "user/add";
        }

    }

    @GetMapping("view/{id}")
    public String displayViewUserForm(Model model, @PathVariable int id) {
        User selectedUser = UserData.getById(id);
        model.addAttribute("userName", selectedUser.getUserName());
        model.addAttribute("email",selectedUser.getEmail());
        model.addAttribute("dateCreated",selectedUser.getDateCreated());
        return "user/view";
    }
}
