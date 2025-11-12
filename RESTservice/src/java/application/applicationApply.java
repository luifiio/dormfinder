/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package application;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import static java.util.stream.DoubleStream.builder;
import static java.util.stream.IntStream.builder;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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
@Path("applicationapply")
public class applicationApply {

    @Context
    private UriInfo context;

  
    public applicationApply() 
    {
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void postJson(String content) throws IOException 
    {
         
            GsonBuilder builder = new GsonBuilder();
            Gson roomClass = builder.create(); 
        
            String applicationString = "";
            List <String> lines = Files.readAllLines(Paths.get("applications.json"));
            for (String line : lines)
            {
            applicationString += line;
            } 
            
            jsonApplication dObj = roomClass.fromJson(applicationString, jsonApplication.class);  // applications
            jsonApplication.Application yObj = roomClass.fromJson(content, jsonApplication.Application.class); // new user 
            System.out.println(yObj.getName());
            System.out.println(yObj.getID());

            
            Boolean usrExist = false;
            int usrIndex = 0;
            //CHECK IF USR EXISTS 
            for(int i=0; i<dObj.applications.length; i++)
            {
                if(dObj.applications[i].getName().equals(yObj.getName()))
                {
                    //USR EXISTS 
                    usrExist = true;
                    usrIndex = i;
                    break; 
                }
            }
            
            if(usrExist = true)
            {
            jsonApplication.ActiveApplication tObj [] = Arrays.copyOf(dObj.applications[usrIndex].getActiveApplications(), dObj.applications[usrIndex].getActiveApplications().length + 1);
            jsonApplication.ActiveApplication actObj = yObj.activeApplications[0];
            tObj[dObj.applications[usrIndex].getActiveApplications().length] = actObj;
            dObj.applications[usrIndex].setActiveApplications(tObj);
            
            //get usr application 
            // get active applications + 1 
            // set new active application 
            // 
            
            try (Writer writer = new FileWriter("applications.json")) 
            {
            Gson gson = new GsonBuilder().create();
            gson.toJson(dObj, writer);
            }
            }
            
            if(usrExist = true)
            {   
            jsonApplication.Application tObj [] = Arrays.copyOf(dObj.getApplications(),dObj.getApplications().length+1);    
            yObj.setID(dObj.getApplications().length + 1);
            tObj[dObj.getApplications().length] = yObj;
            dObj.setApplications(tObj); //done 
            
            try (Writer writer = new FileWriter("applications.json")) 
             {    
            Gson gson = new GsonBuilder().create();
            gson.toJson(dObj, writer);
            }
            }
        
    }

    
}
