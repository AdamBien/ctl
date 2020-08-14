package ctl.configuration.boundary;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.metrics.annotation.Counted;

import ctl.configuration.control.ConfigurationReader;

@Path("configurations")
public class ConfigurationResource {

    @Inject
    ConfigurationReader reader;

    @GET
    @Counted
    @Path("{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public String configuration(@PathParam("name") String name) {
        return this.reader.contentForFile(name);
    }
}