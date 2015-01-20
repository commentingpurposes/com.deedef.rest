package com.deedef.rest;

import jconnection.Queries;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

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

    @Path("/everything")
    @GET
    @Produces("text/html")
    public Response everything() throws Exception{

        String result = "";
        JSONArray array = new JSONArray();
        JSONObject object = new JSONObject();

        try{
            Queries q = new Queries();
            array = q.getEverything();
        }
        catch(Exception e){
            e.printStackTrace();
            return Response.status(500).entity("Server was not able to process your request").build();
        }

        result = "<table border='1'>" +
                "<thead>" +
                "<tr>" +
                "<th>Name</th><th>Location</th><th>Year</th><th>Description</th>" +
                "</tr>" +
                "</thead>" +
                "<tbody>";

        for(int i = 0; i < array.length(); i++){
            object = array.getJSONObject(i);
            result += "<tr>";
            result += "<td>" + object.getString("name") + "</td>";
            result += "<td>" + object.getString("location") + "</td>";
            result += "<td>" + object.getInt("year") + "</td>";
            result += "<td>" + object.getString("desc") + "</td>";
            result += "</tr>";
        }

        result += "</tbody></table>";

        return Response.ok(result).build();
    }
}
