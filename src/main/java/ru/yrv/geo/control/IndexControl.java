package ru.yrv.geo.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.yrv.geo.dao.CountryDAO;
import ru.yrv.geo.model.Country;

import java.util.List;

/**
 * The index controller class
 * @author Roman Yakimkin (r.yakimkin@yandex.ru)
 * @since 03.08.2020
 * @version 1.0
 */
@Controller
public class IndexControl {
    private final CountryDAO countryDAO;

    public IndexControl(CountryDAO countryDAO) {
        this.countryDAO = countryDAO;
    }

    @GetMapping("/")
    public String index(Model model) {
        List<Country> countries = countryDAO.getAll();
        model.addAttribute("countries", countryDAO.getAll());
        return "index";
    }
}
