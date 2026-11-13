package com.careconnect.controller;

import com.careconnect.model.Category;
import com.careconnect.model.HealthCamp;
import com.careconnect.service.HealthCampService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/organizer")
public class CampController {
    private final HealthCampService service;

    public CampController(HealthCampService service) {
        this.service = service;
    }

    @GetMapping("/camps")
    public String dashboard(Model model) {
        model.addAttribute("camps", service.search(null, null));
        return "dashboard";
    }

    @GetMapping("/camps/new")
    public String newCamp(Model model) {
        model.addAttribute("camp", new HealthCamp());
        model.addAttribute("categories", Category.values());
        return "camp-form";
    }

    @PostMapping("/camps")
    public String create(@Valid @ModelAttribute("camp") HealthCamp camp,
                         BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("categories", Category.values());
            return "camp-form";
        }
        service.save(camp);
        return "redirect:/";
    }
}
