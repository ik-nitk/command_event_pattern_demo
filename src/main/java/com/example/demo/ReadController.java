package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ReadController {

    @GetMapping("/id/{id}")
    public String read(@PathVariable Long id, Model model) {
        model.addAttribute("id", id);
        return "demo_read";
    }
}
