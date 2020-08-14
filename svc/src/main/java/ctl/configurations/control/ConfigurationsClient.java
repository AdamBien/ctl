package ctl.configurations.control;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("configurations")
@RegisterRestClient(configKey = "cfg")
public interface ConfigurationsClient {
   
    
    @GET
    @Path("{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public String configuration(@PathParam("name") String name);
   
}