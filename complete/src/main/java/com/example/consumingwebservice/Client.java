package com.example.consumingwebservice;

import com.example.consumingwebservice.wsdl.GetCountryResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ws.soap.client.SoapFaultClientException;

@RestController
public class Client {
    final CountryClient quoteClient;

    public Client(CountryClient quoteClient) {
        this.quoteClient = quoteClient;
    }

    @GetMapping
    public String getCurrency(@RequestParam String country) throws SoapFaultClientException {
        GetCountryResponse response = quoteClient.getCountry(country);
        System.err.println(response.getCountry().getCurrency());

        return response.getCountry().getCurrency().toString();
    }

}
