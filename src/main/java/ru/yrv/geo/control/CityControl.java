package ru.yrv.geo.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.yrv.geo.dao.CityDAO;
import ru.yrv.geo.dao.CountryDAO;
import ru.yrv.geo.model.City;
import ru.yrv.geo.model.Country;

import javax.servlet.http.HttpServletRequest;

/**
 * The controller for city entity
 * @author Roman Yakimkin (r.yakimkin@yandex.ru)
 * @since 05.08.2020
 * @version 1.0
 */

@Controller
@RequestMapping("/city")
public class CityControl {
    public final CityDAO cityDAO;
    public final CountryDAO countryDAO;

    public CityControl(CityDAO cityDAO, CountryDAO countryDAO) {
        this.cityDAO = cityDAO;
        this.countryDAO = countryDAO;
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("cities", cityDAO.getAll());
        return "city/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("item", new City());
        model.addAttribute("title", "Add new city");
        model.addAttribute("countries", countryDAO.getAll());
        return "city/edit";
    }

    @GetMapping("/{id}")
    public String view(@PathVariable String id, Model model) {
        String path = "city/view";
        try {
            int itemId = Integer.parseInt(id);
            model.addAttribute("item", cityDAO.get(itemId));
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
            path = "redirect:/";
        }
        return path;
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable String id, Model model) {
        String path = "city/edit";
        try {
            int itemId = Integer.parseInt(id);
            model.addAttribute("title", "Edit city");
            model.addAttribute("countries", countryDAO.getAll());
            model.addAttribute("item", cityDAO.get(itemId));
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
            cityDAO.delete(itemId);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return "redirect:/city/list";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute City item, HttpServletRequest req) {
        int countryId = Integer.parseInt(req.getParameter("countryId"));
        Country country = new Country();
        country.setId(countryId);
        item.setCountry(country);
        cityDAO.save(item);
        return "redirect:/";
    }
}
