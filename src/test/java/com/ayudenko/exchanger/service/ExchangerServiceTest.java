package com.ayudenko.exchanger.service;

import com.ayudenko.exchanger.dto.ExchangeResponse;
import com.ayudenko.exchanger.exceptions.TransformationLogicException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ExchangerServiceTest {

    private ExchangerService exchangerService = new ExchangerService();

    @Test
    public void test() throws TransformationLogicException {
        ExchangeResponse usd = exchangerService.exchange("USD", "GBP,PLN");

        assertNotNull(usd);
        assertNotNull(usd.getBase());
        assertNotNull(usd.getDate());
        assertNotNull(usd.getRates());
    }

}
