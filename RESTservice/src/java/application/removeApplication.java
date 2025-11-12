/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package application;

import application.jsonApplication.HistorialApplication;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import static org.glassfish.jersey.internal.util.Pretty.array;
import java.util.Arrays;
import org.apache.commons.lang3.ArrayUtils;
import room.jsonRoom;
/**
 * REST Web Service
 *
 * @author lui
 */
@Path("removeApplication")
public class removeApplication {

    @Context
    private UriInfo context;

    public removeApplication() 
    {

    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void postJson(String content) throws IOException 
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
    
    jsonApplication aObj = roomClass.fromJson(applicationString, jsonApplication.class); //import application.json 
    jsonDecline dObj = roomClass.fromJson(content, jsonDecline.class); //import jsonDecline 
    

    
    int namepos = 0;
    int roompos = 0;
    System.out.println(aObj.getApplications().length);

    //identity name pos 
    for(int i = 0; i < aObj.getApplications().length; i++)
    {
        if(dObj.getName().equals(aObj.applications[i].getName()))
        {
            namepos = i;
            System.out.println(namepos);
            break;
        }
    }
    
    jsonApplication.ActiveApplication shii [] = aObj.applications[namepos].getActiveApplications();
    jsonApplication.HistorialApplication histAr[] = aObj.applications[namepos].getHistorialApplications(); //for historical applicaitons
    
 
   //identity act apply pos 
   for(int i = 0; i < aObj.applications[namepos].getActiveApplications().length; i++)
   {
       if(dObj.getRoomName().equals(shii[i].getRoomName()))
       {
       roompos = i;
       break;
       }
   }
   //identified user & application to remove 
   System.out.println(namepos);
   System.out.println(roompos);

    //remove active application
    
   jsonApplication.ActiveApplication okay = shii[roompos];
   System.out.println(aObj.applications[namepos].getActiveApplications().length);
   
   jsonApplication.ActiveApplication arrayInQ [] = ArrayUtils.remove(aObj.applications[namepos].getActiveApplications(), roompos);
   System.out.println(arrayInQ.length);
   
    //update application obj
   aObj.applications[namepos].setActiveApplications(arrayInQ);
    
    //append to historical 
    jsonApplication.HistorialApplication hObj [] = Arrays.copyOf(aObj.applications[namepos].getHistorialApplications(),aObj.applications[namepos].getHistorialApplications().length+1);
    System.out.println(hObj.length);
    
    jsonApplication.HistorialApplication yObj = roomClass.fromJson(content, jsonApplication.HistorialApplication.class);
    System.out.println(yObj.getRoomName());
    yObj.setFinialisedStatus("usr declined");
    hObj[aObj.applications[namepos].getHistorialApplications().length] = yObj;
    
    aObj.applications[namepos].setHistorialApplications(hObj);
   
    try (Writer writer = new FileWriter("applications.json")) 
       {
            Gson gson = new GsonBuilder().create();
            gson.toJson(aObj, writer);
       }
    }
}
