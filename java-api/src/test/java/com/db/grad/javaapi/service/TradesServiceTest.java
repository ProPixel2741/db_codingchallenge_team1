package com.db.grad.javaapi.service;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.db.grad.javaapi.model.Trade;
import com.db.grad.javaapi.repository.TradesRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.doReturn;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TradesServiceTest {

    @Autowired
    private TradesService tradesService;

    @MockBean
    private TradesRepository tradesRepository;

    @Test
    @DisplayName("Test getAllTrades")
    public void testGetAllTrades() {
        Trade trade1 = new Trade();
        Trade trade2 = new Trade();

        doReturn(Arrays.asList(trade1, trade2)).when(tradesRepository).findAll();

        List<Trade> trades = tradesService.getAllTrades();

        Assertions.assertEquals(2, trades.size(), "EQUALS");
    }

    @Test
    @DisplayName("Test getTradeById")
    public void testGetTradeById() {
        Trade trade = new Trade();
        trade.setId(1);

        doReturn(Optional.of(trade)).when(tradesRepository).findById(1);
        Trade returnedTrade = tradesService.getTradeById(1);

        Assertions.assertEquals(returnedTrade, tradesRepository.findById(1).get());
    }
}
