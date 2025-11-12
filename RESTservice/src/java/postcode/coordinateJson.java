/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package postcode;

/**
 *
 * @author lui
 */
public class coordinateJson 
{
    private String status;
    private String matchType;
    private String input;
    public Data data;
    private String[] copyright;

    public String getStatus() { return status; }
    public void setStatus(String value) { this.status = value; }

    public String getMatchType() { return matchType; }
    public void setMatchType(String value) { this.matchType = value; }

    public String getInput() { return input; }
    public void setInput(String value) { this.input = value; }

    public Data getData() { return data; }
    public void setData(Data value) { this.data = value; }

    public String[] getCopyright() { return copyright; }
    public void setCopyright(String[] value) { this.copyright = value; }


public class Data 
{
    private String postcode;
    private String status;
    private String usertype;
    private long easting;
    private long northing;
    private long positionalQualityIndicator;
    private String country;
    private String latitude;
    private String longitude;
    private String postcodeNoSpace;
    private String postcodeFixedWidthSeven;
    private String postcodeFixedWidthEight;
    private String postcodeArea;
    private String postcodeDistrict;
    private String postcodeSector;
    private String outcode;
    private String incode;

    public String getPostcode() { return postcode; }
    public void setPostcode(String value) { this.postcode = value; }

    public String getStatus() { return status; }
    public void setStatus(String value) { this.status = value; }

    public String getUsertype() { return usertype; }
    public void setUsertype(String value) { this.usertype = value; }

    public long getEasting() { return easting; }
    public void setEasting(long value) { this.easting = value; }

    public long getNorthing() { return northing; }
    public void setNorthing(long value) { this.northing = value; }

    public long getPositionalQualityIndicator() { return positionalQualityIndicator; }
    public void setPositionalQualityIndicator(long value) { this.positionalQualityIndicator = value; }

    public String getCountry() { return country; }
    public void setCountry(String value) { this.country = value; }

    public String getLatitude() { return latitude; }
    public void setLatitude(String value) { this.latitude = value; }

    public String getLongitude() { return longitude; }
    public void setLongitude(String value) { this.longitude = value; }

    public String getPostcodeNoSpace() { return postcodeNoSpace; }
    public void setPostcodeNoSpace(String value) { this.postcodeNoSpace = value; }

    public String getPostcodeFixedWidthSeven() { return postcodeFixedWidthSeven; }
    public void setPostcodeFixedWidthSeven(String value) { this.postcodeFixedWidthSeven = value; }

    public String getPostcodeFixedWidthEight() { return postcodeFixedWidthEight; }
    public void setPostcodeFixedWidthEight(String value) { this.postcodeFixedWidthEight = value; }

    public String getPostcodeArea() { return postcodeArea; }
    public void setPostcodeArea(String value) { this.postcodeArea = value; }

    public String getPostcodeDistrict() { return postcodeDistrict; }
    public void setPostcodeDistrict(String value) { this.postcodeDistrict = value; }

    public String getPostcodeSector() { return postcodeSector; }
    public void setPostcodeSector(String value) { this.postcodeSector = value; }

    public String getOutcode() { return outcode; }
    public void setOutcode(String value) { this.outcode = value; }

    public String getIncode() { return incode; }
    public void setIncode(String value) { this.incode = value; }
}
    
}
