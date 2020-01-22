package com.ayudenko.exchanger.service;

import com.ayudenko.exchanger.dto.ExchangeResponse;
import com.ayudenko.exchanger.exceptions.ExternalClientException;
import com.ayudenko.exchanger.exceptions.TransformationLogicException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class ExchangerService {

    private final static String API_CALL = "https://api.exchangeratesapi.io/latest?base={base}&symbols={symbols}";

    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public ExchangeResponse exchange(String from, String to) throws TransformationLogicException {
        log.debug("Starting to convert from {} to {}", from, to);

        ResponseEntity<String> exchange
                = restTemplate.exchange(API_CALL, HttpMethod.GET, null, String.class, from, to);

        if (exchange.getStatusCode().is2xxSuccessful()) {
            log.trace("Exchange is success. Status 200 from external client.");
            String body = exchange.getBody();

            if (body == null) {
                log.warn("Body is null.");
                throw new ExternalClientException("Client has responded with an empty body");
            }

            try {
                return objectMapper.readValue(body, ExchangeResponse.class);
            } catch (JsonProcessingException e) {
                log.error("The structure of incoming JSON is crashed. Logged body is {}", body);
                throw new TransformationLogicException("The structure of incoming JSON is crashed.");
            }
        }

        log.error("Client has responded with non positive status - {}", exchange.getStatusCode());
        throw new ExternalClientException("Client has responded with non positive status - " + exchange.getStatusCode());
    }

}
