package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.model.CounterParty;
import com.db.grad.javaapi.service.CounterPartiesService;

import static org.mockito.Mockito.doReturn;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class CounterPartiesControllerTest {

    @Autowired
    private CounterPartiesController counterPartiesController;

    @MockBean
    private CounterPartiesService counterPartiesService;

    @Test
    @DisplayName("Test getAllCounterParties")
    public void testGetAllCounterParties() {
        CounterParty counterParty1 = new CounterParty();
        CounterParty counterParty2 = new CounterParty();
        doReturn(Arrays.asList(counterParty1, counterParty2)).when(counterPartiesService).getAllCounterParties();

        List<CounterParty> counterParties = counterPartiesController.getAllCounterParties();

        Assertions.assertEquals(2, counterParties.size());
    }

    @Test
    @DisplayName("Test getCounterPartyById")
    public void testGetCounterPartyById() {
        CounterParty counterParty = new CounterParty();
        counterParty.setId(1);
        doReturn(counterParty).when(counterPartiesService).getCounterPartyById(1);

        Assertions.assertEquals(counterParty, counterPartiesController.getCounterPartyById(1));
    }
}