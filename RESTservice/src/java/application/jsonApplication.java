/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application;

/**
 *
 * @author lui
 */
public class jsonApplication
{

    Application[] applications;

    public Application[] getApplications() { return applications; }
    public void setApplications(Application[] value) { this.applications = value; }


public class Application
{
    private int id;
    private String name;
    public ActiveApplication[] activeApplications;
    private HistorialApplication[] historialApplications;

    public int getID() { return id; }
    public void setID(int value) { this.id = value; }

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }

    public ActiveApplication[] getActiveApplications() { return activeApplications; }
    public void setActiveApplications(ActiveApplication[] value) { this.activeApplications = value; }

    public HistorialApplication[] getHistorialApplications() { return historialApplications; }
    public void setHistorialApplications(HistorialApplication[] value) { this.historialApplications = value; }
}


public class ActiveApplication 
{
    private long roomIdentifier;
    private String roomName;

    private String applicationStatus;

    public long getRoomIdentifier() { return roomIdentifier; }
    public void setRoomIdentifier(long value) { this.roomIdentifier = value; }
    
    public String getRoomName() { return roomName; }
    public void setRoomName(String value) { this.roomName = value; }

    public String getApplicationStatus() { return applicationStatus; }
    public void setApplicationStatus(String value) { this.applicationStatus = value; }
}

public class HistorialApplication 
{
    public HistorialApplication(String roomName, int roomId, String status)
    {
    this.roomName = roomName;
    this.roomIdentifier = roomId;
    this.finialisedStatus = "user declined";
   
    }
    
    private int roomIdentifier;
    private String roomName;

    private String finialisedStatus;


    public int getRoomIdentifier() { return roomIdentifier; }
    public void setRoomIdentifier(int value) { this.roomIdentifier = value; }
    
    public String getRoomName() { return roomName; }
    public void setRoomName(String value) { this.roomName = value; }

    public String getFinialisedStatus() { return finialisedStatus; }
    public void setFinialisedStatus(String value) { this.finialisedStatus = value; }
    }
    
}

