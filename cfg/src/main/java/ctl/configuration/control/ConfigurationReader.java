package ctl.configuration.control;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.WebApplicationException;

@ApplicationScoped
public class ConfigurationReader {


    public String contentForFile(String name){
        var inputStream = this.getClass().getResourceAsStream("/"+name);
        try (var buffer = new BufferedReader(new InputStreamReader(inputStream))) {
            return buffer.lines().collect(Collectors.joining("\n"));
        }catch(Exception ex){
            throw new WebApplicationException("Cannot read resource: " + name,ex);
        }

    }
    
}