package ru.springboot.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.springboot.model.User;
import ru.springboot.userServise.UserService;


@Controller
public class Controllers {
    private final UserService userService;
    private static final String REDIRECT = "redirect:/";

    @Autowired
    public Controllers(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String users(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }
    @GetMapping("/{id}")
    public String getUser(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "user";
    }
    @GetMapping("/new")
    public String addUser(User user) {
        return "create";
    }

    @PostMapping("/new")
    public String add(@Valid User user, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "create";
        } else {
            userService.addUser(user);
            return REDIRECT;
        }
    }
    @DeleteMapping("delete/{id}")
    public String delete(@PathVariable("id") long id) {
        userService.removeUser(id);
        return REDIRECT;
    }
    @GetMapping("/edit/{id}")
    public String updateUser(@PathVariable("id") long id, Model model) {
        model.addAttribute("user",userService.getUserById(id));
        return "edit";
    }
    @PatchMapping("/edit")
    public String update(@Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "edit";
        } else {
            userService.updateUser(user);
            return REDIRECT;
        }
    }
}
