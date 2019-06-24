package com.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * A simple index so we know the app is deployed and running
 * @author Ben Haslar
 *
 */
@Path("")
public class IndexController {
	
	@GET
    @Produces(MediaType.TEXT_HTML)
    public String Index() {
       return "<html> " + "<title>" + "NotesAPI" + "</title>"
          + "<body><h1>" + "Notes API is ready to accept REST requests." + "</body></h1>" + "</html> ";
	}
	
}
