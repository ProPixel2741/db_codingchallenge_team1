package com.db.grad.javaapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.db.grad.javaapi.model.Trade;
import com.db.grad.javaapi.repository.TradesRepository;
import org.springframework.stereotype.Service;

@Service
public class TradesService {

    @Autowired
    private TradesRepository tradesRepository;

    public List<Trade> getAllTrades() {
        return tradesRepository.findAll();
    }

    public List<Trade> getAllTradesByUsername(String username) {
        return tradesRepository.findTradesByUsername(username);
    }
    public Trade getTradeById( Integer id ) {

        return tradesRepository.findById(id).get();
    }

}
