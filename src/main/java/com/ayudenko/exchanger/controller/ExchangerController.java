package com.ayudenko.exchanger.controller;

import com.ayudenko.exchanger.service.ExchangerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExchangerController {

    private final ExchangerService exchangerService;

    public ExchangerController(ExchangerService exchangerService) {
        this.exchangerService = exchangerService;
    }

    @GetMapping("/api/exchange/{currency}")
    public void exchange(@PathVariable String currency, List<String> to) {

    }

}
