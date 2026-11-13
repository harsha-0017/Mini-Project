package com.careconnect.controller;

import com.careconnect.model.Category;
import com.careconnect.service.HealthCampService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    private final HealthCampService service;

    public HomeController(HealthCampService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String home(@RequestParam(required = false) String city,
                       @RequestParam(required = false) Category category,
                       Model model) {
        model.addAttribute("camps", service.search(city, category));
        model.addAttribute("categories", Category.values());
        model.addAttribute("selectedCity", city == null ? "" : city);
        model.addAttribute("selectedCategory", category);
        model.addAttribute("campCount", service.count());
        model.addAttribute("cityCount", service.cityCount());
        return "home";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/camps/{id}")
    public String details(@org.springframework.web.bind.annotation.PathVariable Long id, Model model) {
        model.addAttribute("camp", service.get(id));
        return "details";
    }
}
