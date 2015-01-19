package com.deedef.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Created by S2D on 1/18/2015.
 */

@Path("/hi")
public class Hi {

    @GET
    @Produces("text/html")
    public String hi(){
        return "<h1>Hi</h1><p>I am awesome!</p>";
    }

}
