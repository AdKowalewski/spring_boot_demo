package com.example.controller;

import com.example.dto.UpdateUserDto;
import com.example.mappers.UserMapper;
import com.example.model.User;
import com.example.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/users") //kolejność adnotacji nie ma znaczenia
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("users", userService.findAll());
        return "index";
    }

    @GetMapping("/{userId}")
    public String updateForm(Model model, @PathVariable("userId") Long id) {
        UpdateUserDto dto = UserMapper.INSTANCE.toDto(userService.findWithAddresses(id));
        model.addAttribute("dto", dto);
        return "updateUser";
    }

    @PostMapping("/{userId}")
    public ModelAndView submitUpdateForm(@ModelAttribute("dto") UpdateUserDto dto,
                                         @PathVariable("userId") Long userId /*,
                                         Model model*/) {
        //model.addAttribute("users", userService.findAll());
        return new ModelAndView("redirect:/users"/*, model.asMap()*/);
    }
}
