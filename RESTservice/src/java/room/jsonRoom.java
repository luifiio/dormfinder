/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package room;


/**
 *
 * @author lui
 */
public class jsonRoom {
    public Room[] rooms;

    public Room[] getRooms() { return rooms; }
    public void setRooms(Room[] value) { this.rooms = value; }

// Room.java

public class Room 
{
    private long id;
    private String name;
    private boolean availabilityFlag;
    public Location location;
    private Details details;
    private long pricePerMonthGbp;
    private String availabilityDate;
    private String[] spokenLanguages;

    public long getID() { return id; }
    public void setID(long value) { this.id = value; }

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }

    public boolean getAvailiabilityFlag() { return availabilityFlag; }
    public void setAvailiabilityFlag(boolean value) { this.availabilityFlag = value; }
    
    public Location getLocation() { return location; }
    public void setLocation(Location value) { this.location = value; }

    public Details getDetails() { return details; }
    public void setDetails(Details value) { this.details = value; }

    public long getPricePerMonthGbp() { return pricePerMonthGbp; }
    public void setPricePerMonthGbp(long value) { this.pricePerMonthGbp = value; }

    public String getAvailabilityDate() { return availabilityDate; }
    public void setAvailabilityDate(String value) { this.availabilityDate = value; }

    public String[] getSpokenLanguages() { return spokenLanguages; }
    public void setSpokenLanguages(String[] value) { this.spokenLanguages = value; }
}

public class Details 
{
    private boolean furnished;
    private String[] amenities;
    private boolean liveInLandlord;
    private long sharedWith;
    private boolean billsIncluded;
    private boolean bathroomShared;

    public boolean getFurnished() { return furnished; }
    public void setFurnished(boolean value) { this.furnished = value; }

    public String[] getAmenities() { return amenities; }
    public void setAmenities(String[] value) { this.amenities = value; }

    public boolean getLiveInLandlord() { return liveInLandlord; }
    public void setLiveInLandlord(boolean value) { this.liveInLandlord = value; }

    public long getSharedWith() { return sharedWith; }
    public void setSharedWith(long value) { this.sharedWith = value; }

    public boolean getBillsIncluded() { return billsIncluded; }
    public void setBillsIncluded(boolean value) { this.billsIncluded = value; }

    public boolean getBathroomShared() { return bathroomShared; }
    public void setBathroomShared(boolean value) { this.bathroomShared = value; }
}

// Location.java



public class Location 
{
    private String city;
    private String county;
    private String postcode;
    private String lattitude;
    private String longitude;

    public String getCity() { return city; }
    public void setCity(String value) { this.city = value; }

    public String getCounty() { return county; }
    public void setCounty(String value) { this.county = value; }

    public String getPostcode() { return postcode; }
    public void setPostcode(String value) { this.postcode = value; }

    public String getLattitude() { return lattitude; }
    public void setLattitude(String value) { this.lattitude = value; }

    public String getLongitude() { return longitude; }
    public void setLongitude(String value) { this.longitude = value; }
}

}
