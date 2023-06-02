package com.haziq.currencyexchangeservice.repositories;

import com.haziq.currencyexchangeservice.models.CurrencyExchange;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {
  CurrencyExchange findByFromAndTo(String from, String to);
}
