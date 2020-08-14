package ctl.reports.control;

import java.io.StringReader;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import ctl.configurations.control.ConfigurationsClient;

@RequestScoped
public class ReportGenerator {
    
    @Inject
    @RestClient
    ConfigurationsClient client;

	public JsonObject generateReport(String name) {
        var serialized = client.configuration(name);
        try(var reader = Json.createReader(new StringReader(serialized))){
            return reader.readObject();
        }
	}

    
    
  
}