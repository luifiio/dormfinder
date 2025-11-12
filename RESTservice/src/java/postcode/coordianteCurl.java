/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package postcode;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author lui
 */
public class coordianteCurl 
{
 
 public BufferedReader  coordinateIn;
    
public coordinateJson convertPostcode(String postcode) throws MalformedURLException, ProtocolException, IOException
{
 
    URL url = new URL("http://api.getthedata.com/postcode/" + postcode);
    System.out.println(url);

    HttpURLConnection con = (HttpURLConnection) url.openConnection();
    con.setRequestMethod("GET");
    con.connect();
    
    coordinateIn = new BufferedReader(new InputStreamReader(con.getInputStream()));
    StringBuilder coordString = new StringBuilder();
    String line;
    while((line = coordinateIn.readLine()) != null)
    {
    coordString.append(line);
    }
    coordinateIn.close();
    
    GsonBuilder builder = new GsonBuilder();
    builder.setPrettyPrinting();
    Gson coordClass = builder.create();
    
    coordinateJson cObj = coordClass.fromJson(coordString.toString(),coordinateJson.class);
    return cObj;
}
       
}
