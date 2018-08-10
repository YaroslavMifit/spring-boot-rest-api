package com.demo.controller;

import com.demo.Application;
import com.demo.model.Client;
import com.demo.service.ClientService;
import com.google.common.collect.ImmutableList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ClientControllerIT {

    @Autowired
    ClientService controller;

    RestTemplate restTemplate = new RestTemplate();

    @Test
    public void getClients() throws Exception {
        ResponseEntity<Collection<Client>> responseEntity =
                restTemplate.exchange("http://localhost:8080/demo/clients", HttpMethod.GET, null,
                        new ParameterizedTypeReference<Collection<Client>>() {
                        });

        Collection<Client> actualList = responseEntity.getBody();
        //validate
        assertThat(actualList.size(), is(controller.getAll().size()));

        List<Long> actualIds = actualList.stream()
                .map(client -> client.getId())
                .collect(collectingAndThen(toList(), ImmutableList::copyOf));

        List<Long> list = new ArrayList<>();
        for (long i = 1; i <= actualList.size(); i++) {
            list.add(i);
        }


        assertThat(actualIds, is(list));
    }

    @Test
    public void getClient() {
    }

    @Test
    public void addClient() {
    }

    @Test
    public void updateClient() {
    }

    @Test
    public void deleteClient() {
    }
}