/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package distance;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import postcode.coordinateJson;
import postcode.coordianteCurl;
import room.jsonRoom;
import room.roomCurl;
import weather.jsonWeather;

/**
 * REST Web Service
 *
 * @author lui - n1076024
 */
@Path("distanceCalc")
public class distanceCalc {

    @Context
    private UriInfo context;
    public BufferedReader distanceIn;
    /**
     * Creates a new instance of distanceCalc
     */
    public distanceCalc() 
    {
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson(@QueryParam("postcode")String postcode, @QueryParam("roomId")int roomId) throws MalformedURLException, IOException 
    {

   
    coordianteCurl crazyObj = new coordianteCurl();
    coordinateJson coolObj = crazyObj.convertPostcode(postcode); 
    
    roomCurl roomyObj  = new roomCurl();
    jsonRoom roomObj = roomyObj.parseRoomsObj();

    URL basedUrl = new URL("http://router.project-osrm.org/route/v1/driving/" + 
    coolObj.data.getLongitude() + "," + coolObj.data.getLatitude() + ";" 
    + roomObj.rooms[roomId].location.getLongitude() + "," + roomObj.rooms[roomId].location.getLattitude() + "?overview=false");
    
    System.out.println(basedUrl);
    HttpURLConnection con = (HttpURLConnection) basedUrl.openConnection();
    con.setRequestMethod("GET");
    con.connect();
    
    distanceIn = new BufferedReader(new InputStreamReader(con.getInputStream()));
    StringBuilder distanceStr = new StringBuilder();
    String line;
    while((line = distanceIn.readLine()) != null)
    {
    distanceStr.append(line);
    }
    distanceIn.close();
    
    GsonBuilder builder = new GsonBuilder();
    builder.setPrettyPrinting();
    Gson dClass = builder.create();

    jsonDistance dObj = dClass.fromJson(distanceStr.toString(), jsonDistance.class);

    return new Gson().toJson(dObj);
    }


    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) 
    {
    }

    
}
