package com.db.grad.javaapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db.grad.javaapi.model.Security;
import com.db.grad.javaapi.repository.SecuritiesRepository;

@Service
public class SecuritiesService {

    @Autowired
    private SecuritiesRepository securitiesRepository;
    
    public List<Security> getAllSecurities() {
        return securitiesRepository.findAll();
    }

    public Security getSecurityById(Integer id) {

        return securitiesRepository.findById(id).get();
    }

}
