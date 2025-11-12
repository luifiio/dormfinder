/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application;

/**
 *
 * @author lui
 */
public class applicationDetail
{
    
    private long id;
    private String name;
    private ActiveApplication[] activeApplications;
    private HistorialApplication[] historialApplications;

    public long getID() { return id; }
    public void setID(long value) { this.id = value; }

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }

    public ActiveApplication[] getActiveApplications() { return activeApplications; }
    public void setActiveApplications(ActiveApplication[] value) { this.activeApplications = value; }

    public HistorialApplication[] getHistorialApplications() { return historialApplications; }
    public void setHistorialApplications(HistorialApplication[] value) { this.historialApplications = value; }



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
    private long roomIdentifier;
    private String roomName;
    private String finialisedStatus;

    public long getRoomIdentifier() { return roomIdentifier; }
    public void setRoomIdentifier(long value) { this.roomIdentifier = value; }

    public String getRoomName() { return roomName; }
    public void setRoomName(String value) { this.roomName = value; }

    public String getFinialisedStatus() { return finialisedStatus; }
    public void setFinialisedStatus(String value) { this.finialisedStatus = value; }
}

}