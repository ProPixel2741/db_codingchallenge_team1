package com.db.grad.javaapi.service;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.db.grad.javaapi.model.Security;
import com.db.grad.javaapi.repository.SecuritiesRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.doReturn;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SecuritiesServiceTest {

    @Autowired
    private SecuritiesService securitiesService;

    @MockBean
    private SecuritiesRepository securitiesRepository;

    @Test
    @DisplayName("Test getAllSecurities")
    public void testGetAllSecurities() {
        Security security1 = new Security();
        Security security2 = new Security();

        doReturn(Arrays.asList(security1, security2)).when(securitiesRepository).findAll();

        List<Security> securities = securitiesService.getAllSecurities();

        Assertions.assertEquals(2, securities.size(), "EQUALS");
    }

    @Test
    @DisplayName("Test getSecurityById")
    public void testGetSecurityById() {
        Security security = new Security();
        security.setId(1);
        
        doReturn(Optional.of(security)).when(securitiesRepository).findById(1);
        Security returnedSecurity = securitiesService.getSecurityById(1);

        Assertions.assertEquals(returnedSecurity, securitiesRepository.findById(1).get());
    }
}
