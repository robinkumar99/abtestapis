package com.skido.abtests.controller;

import com.skido.abtests.appbeans.ABTestData;
import com.skido.abtests.appbeans.AppResource;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
public class ConsumeWebService {
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/template/resources")
    public AppResource getABTestResource() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<AppResource> entity = new HttpEntity<AppResource>(headers);

        return restTemplate.exchange(
                "http://localhost:9990/resources", HttpMethod.GET, entity, AppResource.class).getBody();
    }

    @RequestMapping(value = "/template/resources/{id}", method = RequestMethod.PUT)
    public String updateABTestData(@PathVariable("id") String id, @RequestBody ABTestData abtestdata) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<ABTestData> entity = new HttpEntity<ABTestData>(abtestdata,headers);

        return restTemplate.exchange(
                "http://localhost:9990/resources/"+id, HttpMethod.PUT, entity, String.class).getBody();
    }

    /**
     @RequestMapping(value = "/template/resources", method = RequestMethod.POST)
     public String createABTestData(@RequestBody Product product) {
     HttpHeaders headers = new HttpHeaders();
     headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
     HttpEntity<Product> entity = new HttpEntity<Product>(product,headers);

     return restTemplate.exchange(
     "http://localhost:8080/products", HttpMethod.POST, entity, String.class).getBody();
     }**/
}
