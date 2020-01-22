package com.ayudenko.exchanger.dto;

import lombok.Data;

import java.util.Map;

@Data
public class ExchangeResponse {
    private String base;
    private String date;
    private Map<String, Double> rates;
}
