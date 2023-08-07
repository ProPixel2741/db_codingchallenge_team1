package com.db.grad.javaapi.service;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.db.grad.javaapi.model.CounterParty;
import com.db.grad.javaapi.repository.CounterPartiesRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.doReturn;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CounterPartiesServiceTest {

    @Autowired
    private CounterPartiesService counterPartiesService;

    @MockBean
    private CounterPartiesRepository counterPartiesRepository;

    @Test
    @DisplayName("Test getAllCounterParties")
    public void testGetAllCounterParties() {
        CounterParty counterParty1 = new CounterParty();
        CounterParty counterParty2 = new CounterParty();

        doReturn(Arrays.asList(counterParty1, counterParty2)).when(counterPartiesRepository).findAll();

        List<CounterParty> counterParties = counterPartiesService.getAllCounterParties();

        Assertions.assertEquals(2, counterParties.size(), "EQUALS");
    }

    @Test
    @DisplayName("Test getCounterPartyById")
    public void testGetCounterPartyById() {
        CounterParty counterParty = new CounterParty();
        counterParty.setId(1);

        doReturn(Optional.of(counterParty)).when(counterPartiesRepository).findById(1);
        CounterParty returnedCounterParty = counterPartiesService.getCounterPartyById(1);

        Assertions.assertEquals(returnedCounterParty, counterPartiesRepository.findById(1).get());
    }
}
