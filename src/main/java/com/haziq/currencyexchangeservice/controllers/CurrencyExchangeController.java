package com.haziq.currencyexchangeservice.controllers;

import com.haziq.currencyexchangeservice.models.CurrencyExchange;
import com.haziq.currencyexchangeservice.repositories.CurrencyExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {
  @Autowired
  private Environment environment;
  @Autowired
  private CurrencyExchangeRepository repository;
  @GetMapping("/currency-exchange/from/{from}/to/{to}")
  public CurrencyExchange retrieveExchangeValue(
          @PathVariable String from,
          @PathVariable String to) {
//    CurrencyExchange currencyExchange = new CurrencyExchange(1000L, from, to, BigDecimal.valueOf(50));
    CurrencyExchange currencyExchange = repository.findByFromAndTo(from, to);
    if (currencyExchange == null){
      throw new RuntimeException("Unable to find data");
    }
    String port = environment.getProperty("local.server.port");
    currencyExchange.setEnvironment(port);
    return currencyExchange;
  }

}
