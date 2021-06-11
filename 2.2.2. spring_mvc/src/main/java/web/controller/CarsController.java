package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.CarService.CarService;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/cars")
public class CarsController {

    private CarService carService;

    @Autowired
    public CarsController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public String cars(@RequestParam(value = "count", defaultValue = "5" /*, required = false*/) Integer count, Model model) {

        model.addAttribute("listOfAllCars", carService.allCars());
        model.addAttribute("listOfAllCars", carService.carListByRequest(count));
        return "/Cars";
    }
}
