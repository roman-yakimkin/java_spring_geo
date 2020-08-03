package ru.yrv.geo.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * The index controller class
 * @author Roman Yakimkin (r.yakimkin@yandex.ru)
 * @since 03.08.2020
 * @version 1.0
 */
@Controller
public class IndexControl {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("name", "New geo project");
        return "index";
    }
}
