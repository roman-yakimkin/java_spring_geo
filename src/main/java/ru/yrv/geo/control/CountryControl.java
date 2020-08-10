package ru.yrv.geo.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.yrv.geo.model.Country;
import ru.yrv.geo.repository.CountryRepository;

/**
 * The controller for country entity
 * @author Roman Yakimkin (r.yakimkin@yandex.ru)
 * @since 05.08.2020
 * @version 1.0
 */
@Controller
@RequestMapping("/country")
public class CountryControl {

    private final CountryRepository countryRepository;

    public CountryControl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("countries", countryRepository.findAll());
        return "country/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("item", new Country());
        model.addAttribute("title", "Add new country");
        return "country/edit";
    }

    @GetMapping("/{id}")
    public String view(@PathVariable String id, Model model) {
        String path = "country/view";
        try {
            int itemId = Integer.parseInt(id);
            model.addAttribute("item", countryRepository.findById(itemId).get());
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
            path = "redirect:/";
        }
        return path;
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable String id, Model model) {
        String path = "country/edit";
        try {
            int itemId = Integer.parseInt(id);
            model.addAttribute("title", "Edit country");
            model.addAttribute("item", countryRepository.findById(itemId).get());
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
            path = "redirect:/";
        }
        return path;
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable String id) {
        try {
            int itemId = Integer.parseInt(id);
            countryRepository.deleteById(itemId);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return "redirect:/country/list";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Country item) {
        if (countryRepository.existsById(item.getId())) {
            countryRepository.findById(item.getId()).ifPresent(
                country -> {
                    country.setName(item.getName());
                    countryRepository.save(country);
                }
            );
        } else {
            countryRepository.save(item);
        }
        return "redirect:/";
    }
}
