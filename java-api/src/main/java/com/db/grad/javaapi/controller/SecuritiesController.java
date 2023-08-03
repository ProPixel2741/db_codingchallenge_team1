package com.db.grad.javaapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.db.grad.javaapi.model.Security;
import com.db.grad.javaapi.service.SecuritiesService;

@RestController
@RequestMapping("/api/v1")
public class SecuritiesController {

    @Autowired
    private SecuritiesService securitiesService;

    public SecuritiesController(SecuritiesService securitiesService) {
        this.securitiesService = securitiesService;
    }    

    @GetMapping("/securities")
    public List<Security> getAllSecurities() {
        return securitiesService.getAllSecurities();
    }

    @GetMapping("/securities/{id}")
    public Security getSecurityById(@PathVariable Integer id) {
        return securitiesService.getSecurityById(id);
    }

}
