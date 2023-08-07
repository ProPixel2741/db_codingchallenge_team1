package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.model.Trade;
import com.db.grad.javaapi.service.TradesService;

import static org.mockito.Mockito.doReturn;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class TradesControllerTest {

    @Autowired
    private TradesController tradesController;

    @MockBean
    private TradesService tradesService;

    @Test
    @DisplayName("Test getAllTrades")
    void testGetAllTrades() {
        Trade trade1 = new Trade();
        Trade trade2 = new Trade();
        doReturn(Arrays.asList(trade1, trade2)).when(tradesService).getAllTrades();

        List<Trade> trades = tradesController.getAllTrades();

        Assertions.assertEquals(2, trades.size());
    }

    @Test
    @DisplayName("Test getTradeById")
    void testGetTradeById() {
        Trade trade = new Trade();
        trade.setId(1);
        doReturn(trade).when(tradesService).getTradeById(1);

        Assertions.assertEquals(trade, tradesController.getTradeById(1));
    }
}