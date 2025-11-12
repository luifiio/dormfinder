/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package weather;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
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


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.net.Socket;
import java.util.Arrays;
import javax.ws.rs.QueryParam;
import weather.jsonWeather.Datasery;

/**
 * REST Web Service
 *
 * @author lui - n1076024
 */
@Path("weather")
public class weatherCurl 
{
    public BufferedReader weatherIn;
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of weatherCurl
     */
    public weatherCurl() 
    {
        
    }
    //receive request -> open socket -> serialise request -> curl from api -> get request -> desearialise -> back to json -> send on getJSON request 

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson(@QueryParam("lon")String lon, @QueryParam("lat")String lat) throws MalformedURLException, IOException 
    {   
    System.out.println(lon);
    System.out.println(lat);

    URL url = new URL("https://www.7timer.info/bin/civillight.php?lon=" + lon+ "&lat=" + lat + "&unit=metric&output=json");

    HttpURLConnection con = (HttpURLConnection) url.openConnection();
    System.out.println(url);
    con.setRequestMethod("GET");
    con.connect();
    weatherIn = new BufferedReader(new InputStreamReader(con.getInputStream()));
    StringBuilder weatherStr = new StringBuilder();
    String line;
    while((line = weatherIn.readLine()) != null)
    {
    weatherStr.append(line);
    }
    weatherIn.close();
    
    GsonBuilder builder = new GsonBuilder();
    builder.setPrettyPrinting();
    Gson wClass = builder.create();

    jsonWeather wObj = wClass.fromJson(weatherStr.toString(), jsonWeather.class);
     
    return new Gson().toJson(wObj);
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) 
    {
        
    }
}
