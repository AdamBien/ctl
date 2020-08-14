package ctl.reports.boundary;

import javax.inject.Inject;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.metrics.annotation.Counted;

import ctl.reports.control.ReportGenerator;

@Path("/reports")
public class ReportsResource {

    @Inject
    ReportGenerator generator;


    //test with curl -H"Accept:application/json" http://localhost:8282/reports/duke.json
    @GET
    @Counted
    @Path("{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public JsonObject reports(@PathParam("name") String name) {
        return this.generator.generateReport(name);
    }
}