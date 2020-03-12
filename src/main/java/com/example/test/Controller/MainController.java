package com.example.test.Controller;

import com.example.test.Model.User;
import com.example.test.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/test")
public class MainController {

    private final UserService userService;

    @GetMapping(value = "/get/{name}")
    public User get(@PathVariable String name) {
        return userService.findByName(name);
    }

    @GetMapping(value = "/list")
    public List<User> showList() {
        return userService.findAll();
    }

}
