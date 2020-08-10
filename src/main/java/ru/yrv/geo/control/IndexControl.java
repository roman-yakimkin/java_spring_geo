package ru.yrv.geo.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.yrv.geo.repository.CountryRepository;

import java.util.List;

/**
 * The index controller class
 * @author Roman Yakimkin (r.yakimkin@yandex.ru)
 * @since 03.08.2020
 * @version 1.0
 */
@Controller
public class IndexControl {
    private final CountryRepository countryRepository;

    public IndexControl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("countries", countryRepository.findAll());
        return "index";
    }
}
