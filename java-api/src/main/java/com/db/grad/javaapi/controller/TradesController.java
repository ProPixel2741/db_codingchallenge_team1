package com.db.grad.javaapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.db.grad.javaapi.service.TradesService;
import com.db.grad.javaapi.model.Trade;

@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("/api/v1")
public class TradesController {

    @Autowired
    private TradesService tradesService;

    @GetMapping("/trades")
    public List<Trade> getAllTrades() {
        return tradesService.getAllTrades();
    }

    @GetMapping("/trades/user/{username}")
    public List<Trade> getTradesByUsername(@PathVariable String username) {
        return tradesService.getAllTradesByUsername(username);
    }

    @GetMapping("/trades/{id}")
    public Trade getTradeById(@PathVariable Integer id) {
        return tradesService.getTradeById(id);
    }

}
