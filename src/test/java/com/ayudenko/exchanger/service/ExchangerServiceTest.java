package com.ayudenko.exchanger.service;

import com.ayudenko.exchanger.exceptions.TransformationLogicException;
import org.junit.jupiter.api.Test;

public class ExchangerServiceTest {

    private ExchangerService exchangerService = new ExchangerService();

    @Test
    public void test() throws TransformationLogicException {
        exchangerService.exchange("USD", "GBP,PLN");
    }

}
