package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.model.Security;
import com.db.grad.javaapi.service.SecuritiesService;

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
class SecuritiesControllerTest {

    @Autowired
    private SecuritiesController securitiesController;

    @MockBean
    private SecuritiesService securitiesService;

    @Test
    @DisplayName("Test getAllSecurities")
    public void testGetAllSecurities() {
        Security security1 = new Security();
        Security security2 = new Security();
        doReturn(Arrays.asList(security1, security2)).when(securitiesService).getAllSecurities();

        List<Security> securities = securitiesController.getAllSecurities();

        Assertions.assertEquals(2, securities.size());
    }

    @Test
    @DisplayName("Test getSecurityById")
    public void testGetSecurityById() {
        Security security = new Security();
        security.setId(1);
        doReturn(security).when(securitiesService).getSecurityById(1);

        Assertions.assertEquals(security, securitiesController.getSecurityById(1));
    }
}