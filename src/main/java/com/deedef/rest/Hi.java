package com.deedef.rest;

import jconnection.Queries;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 * Created by S2D on 1/18/2015.
 */

@Path("/hi")
public class Hi {

    @GET
    @Produces("text/plain")
    public String hi(){
        return "Hi, I am awesome!";
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

    @Path("/id/{id}")
    @GET
    @Produces("text/html")
    public Response description(@PathParam("id") int id){
        String result = "";
        JSONArray array = new JSONArray();
        JSONObject object = new JSONObject();

        try{
            Queries q = new Queries();
            array = q.getDesc(id);
        }
        catch(Exception e){
            e.printStackTrace();
            return Response.status(500).entity("Server was not able to process your request").build();
        }

        object = array.getJSONObject(0);

        result = "<table border='1'>" +
                "<thead>" +
                "<tr>" +
                "<th>Description</th>" +
                "</tr>" +
                "</thead>" +
                "<tbody>";
        result += "<tr>";
        result += "<td>" + object.getString("desc") + "</td>";
        result += "</tr>";
        result += "</tbody></table>";

        return Response.ok(result).build();
    }

    @GET
    @Produces("text/html")
    public Response nameAndLocation(@QueryParam("id") int id){
        String result = "";
        JSONArray array = new JSONArray();
        JSONObject object = new JSONObject();

        try{
            Queries q = new Queries();
            array = q.getNameAndLocation(id);
        }
        catch(Exception e){
            e.printStackTrace();
            return Response.status(500).entity("Server was not able to process your request").build();
        }

        object = array.getJSONObject(0);

        result = "<table border='1'>" +
                "<thead>" +
                "<tr>" +
                "<th>Name</th><th>Location</th>" +
                "</tr>" +
                "</thead>" +
                "<tbody>";
        result += "<tr>";
        result += "<td>" + object.getString("name") + "</td>";
        result += "<td>" + object.getString("location") + "</td>";
        result += "</tr>";
        result += "</tbody></table>";

        return Response.ok(result).build();
    }
}
