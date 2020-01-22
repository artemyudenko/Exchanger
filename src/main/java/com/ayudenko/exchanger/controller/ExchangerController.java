package com.ayudenko.exchanger.controller;

import com.ayudenko.exchanger.dto.ExchangeResponse;
import com.ayudenko.exchanger.exceptions.TransformationLogicException;
import com.ayudenko.exchanger.service.ExchangerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
public class ExchangerController {

    private final ExchangerService exchangerService;

    @Autowired
    public ExchangerController(ExchangerService exchangerService) {
        this.exchangerService = exchangerService;
    }

    @GetMapping("/api/exchange/{currency}")
    public ExchangeResponse exchange(@PathVariable @Valid @NotNull String currency, List<String> to) throws TransformationLogicException {
        String sTo = listOfParamsToString(to);
        return exchangerService.exchange(currency, sTo);
    }

    private String listOfParamsToString(List<String> list) {
        StringBuilder stringBuilder = new StringBuilder();

        for (String s : list) {
            stringBuilder.append(s);
        }

        return stringBuilder.toString();
    }

}
