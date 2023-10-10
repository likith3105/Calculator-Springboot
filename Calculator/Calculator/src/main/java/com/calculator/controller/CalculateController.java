package com.calculator.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.calculator.service.CalculatorService;

@Controller
public class CalculateController {

    @Autowired
    private CalculatorService calculatorService;

    private Map<String, BiFunction<Double, Double, Double>> operationMap = new HashMap<>();

    public CalculateController() {
        // Initialize the operation map
        operationMap.put("add", (a, b) -> calculatorService.add(a, b));
        operationMap.put("subtract", (a, b) -> calculatorService.subtract(a, b));
        operationMap.put("multiply", (a, b) -> calculatorService.multiply(a, b));
        operationMap.put("divide", (a, b) -> calculatorService.divide(a, b));
        operationMap.put("modulus", (a, b) -> calculatorService.modulus(a, b));
        operationMap.put("percentage", (a, b) -> calculatorService.percentage(a, b));

    }

    @GetMapping("/")
    public String index() {
        return "abc.html";
    }

    @GetMapping("/calculate")
    public String calculate(@RequestParam String operation,
            @RequestParam double a,
            @RequestParam double b,
            Model model) {
        BiFunction<Double, Double, Double> calculatorFunction = operationMap.get(operation);
        if (calculatorFunction != null) {
            try {
                double result = calculatorFunction.apply(a, b);
                model.addAttribute("result", result);
            } catch (IllegalArgumentException e) {
                model.addAttribute("result", e.getMessage());
            }
        } else {
            model.addAttribute("result", "Invalid operation");
        }
        return "abc.html";
    }

}
