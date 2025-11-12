/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package room;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


/**
 * REST Web Service
 *
 * @author lui
 */
@Path("room")
public class roomCurl {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of roomCurl
     */
    public roomCurl() 
    {
    }
    
    public jsonRoom parseRoomsObj() throws IOException
    {
    GsonBuilder builder = new GsonBuilder();
    builder.setPrettyPrinting();
    Gson roomClass = builder.create(); 
    
    String jsonString = "";
    List <String> lines = Files.readAllLines(Paths.get("rooms.json"));
    for (String line : lines)
    {
    jsonString += line;
    }
    jsonRoom roomObj = roomClass.fromJson(jsonString, jsonRoom.class);

    return roomObj;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    
    public String getJson() throws IOException 
    {
    GsonBuilder builder = new GsonBuilder();
    builder.setPrettyPrinting();
    Gson roomClass = builder.create(); 
    
    String jsonString = "";
    List <String> lines = Files.readAllLines(Paths.get("rooms.json"));
    for (String line : lines)
    {
    jsonString += line;
    }
    jsonRoom roomObj = roomClass.fromJson(jsonString, jsonRoom.class);

    return new Gson().toJson(roomObj);
    }

    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) 
    {
    }
}
