package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.model.CounterParty;
import com.db.grad.javaapi.service.CounterPartiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("/api/v1")
public class CounterPartiesController {

    @Autowired
    private CounterPartiesService counterPartiesService;

    @GetMapping("/counterparties")
    public List<CounterParty> getAllCounterParties() {
        return counterPartiesService.getAllCounterParties();
    }
    @GetMapping("/counterparties/{id}")
    public CounterParty getCounterPartyById(@PathVariable Integer id) {
        return counterPartiesService.getCounterPartyById(id);
    }
}
