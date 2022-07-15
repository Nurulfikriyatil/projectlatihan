package com.prosigmaka.projectlatihan.controller;

import com.prosigmaka.projectlatihan.model.LoginDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @PostMapping("/login")
    public LoginDto login(@RequestBody LoginDto loginDto) {
        return loginDto;

    }
}
