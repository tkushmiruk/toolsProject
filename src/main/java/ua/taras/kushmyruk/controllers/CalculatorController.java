package ua.taras.kushmyruk.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.taras.kushmyruk.service.CalculatorService;

@Controller
public class CalculatorController {
    CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/calculator")
    public String showCalculatorPage() {
        return "calculator";
    }

    @PostMapping("/calculator")
    public String calculate(@RequestParam String formula, Model model) {
        if (formula.equals("")) {
            return "calculator";
        }
        Integer result = calculatorService.calculate(formula);
        if (result != null) {
            model.addAttribute("result", String.valueOf(result));

            return "calculator";
        }


        return "calculator";
    }
}
