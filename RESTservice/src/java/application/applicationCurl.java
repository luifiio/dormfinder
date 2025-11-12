/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package application;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import room.jsonRoom;

/**
 * REST Web Service
 *
 * @author lui
 */
@Path("application")
public class applicationCurl {

    @Context
    private UriInfo context;


    public applicationCurl() 
    {
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson(@QueryParam("name")String name) throws IOException 
    {
        
    GsonBuilder builder = new GsonBuilder();
    builder.setPrettyPrinting();
    Gson roomClass = builder.create(); 
    String applicationString = "";
    List <String> lines = Files.readAllLines(Paths.get("applications.json"));
    for (String line : lines)
    {
    applicationString += line;
    }
    jsonApplication aObj = roomClass.fromJson(applicationString, jsonApplication.class);

    int i = 0;

    while(!aObj.applications[i].getName().equals(name))
    {
    i++;    
    }
    
    Gson usrson = new Gson();
    String usrinq = usrson.toJson(aObj.applications[i]);
    applicationDetail dObj = roomClass.fromJson(usrinq,applicationDetail.class);

    return new Gson().toJson(dObj);
    }
 

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
