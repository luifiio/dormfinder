// room detail scripts
var detailid ;
var tempPostcode;

function loadRoomDetail()
{
detailid = parseInt(localStorage.getItem("roomid"));
console.log(detailid);

//GET ROOM DETAILS
fetch('http://localhost:8080/RESTService/webresources/room')
.then(response => response.json())
.then(json => 
    {   
        eventidentifier = localStorage.getItem("eventparser");
        
        localStorage.setItem("roomId",json.rooms[detailid].id);
        localStorage.setItem("roomName",json.rooms[detailid].name);

        document.getElementById("room-ppm").innerHTML=json.rooms[detailid].pricePerMonthGbp;
        document.getElementById("room-availabilityDate").innerHTML=json.rooms[detailid].availabilityDate;
        for (var i = 0; i < json.rooms[detailid].spokenLanguages.length; i++) 
        {
            const languageContainer = document.getElementById("room-languages");
            const languageInQuestion = document.createTextNode(json.rooms[detailid].spokenLanguages[i] + ", ");
            var languageElement = document.createElement("span");

            languageElement.appendChild(languageInQuestion);
            languageContainer.appendChild(languageElement);
        }
        document.getElementById("room-availabilityDate").innerHTML=json.rooms[detailid].availabilityDate;
        document.getElementById("room-name").innerHTML=json.rooms[detailid].name;
        document.getElementById("room-location").innerHTML=json.rooms[detailid].location.city;
        document.getElementById("room-county").innerHTML=json.rooms[detailid].location.county;
        document.getElementById("room-postcode").innerHTML=json.rooms[detailid].location.postcode;
        tempPostcode = json.rooms[detailid].location.postcode;

        localStorage.setItem("roomLon",json.rooms[detailid].location.longitude);
        localStorage.setItem("roomLat",json.rooms[detailid].location.lattitude);
     
        //DETAILS 
        document.getElementById("room-furnished").innerHTML=json.rooms[detailid].details.furnished;

        for (var i = 0; i < json.rooms[detailid].details.amenities.length; i++) 
            {
                const amenitiecContainer = document.getElementById("room-amenities");
                const amenitieInQuestion = document.createTextNode(json.rooms[detailid].details.amenities[i]+ ", ");
                var amenitieElement = document.createElement("span");
    
                amenitieElement.appendChild(amenitieInQuestion);
                amenitiecContainer.appendChild(amenitieElement);
            }

        document.getElementById("room-count").innerHTML=json.rooms[detailid].details.sharedWith;
        document.getElementById("room-landlord").innerHTML=json.rooms[detailid].details.liveInLandlord;
        document.getElementById("room-bills").innerHTML=json.rooms[detailid].details.billsIncluded;
        document.getElementById("room-bathroom").innerHTML=json.rooms[detailid].details.bathroomShared;

        if(json.rooms[detailid].availabilityFlag == false)
        {
            document.getElementById("applyChar").innerHTML="Room is not available, much applogies !";
            document.getElementById("applyLabel").remove();
            document.getElementById("applyButton").remove();
            document.getElementById("usrapplyname").remove();
        }

    })

var tempUrl = 'http://localhost:8080/RESTService/webresources/weather?lon=' + localStorage.getItem("roomLon") + '&lat=' + localStorage.getItem("roomLat");
console.log(tempUrl);

// GET CURRENT WEATHER 
fetch('http://localhost:8080/RESTService/webresources/weather?lon=' + localStorage.getItem("roomLon") + '&lat=' + localStorage.getItem("roomLat") )
.then(response => response.json())
.then(json => 
        { 
            document.getElementById("room-weather").innerHTML=json.dataseries[0].weather + " with a wind speed off " + json.dataseries[0].wind10MMax +"mph";
        })
}

function distanceCalculation()
{
detailid = parseInt(localStorage.getItem("roomid"));
console.log(document.getElementById("usrpostcode").value)

fetch('http://localhost:8080/RESTService/webresources/distanceCalc?postcode=' + document.getElementById("usrpostcode").value + '&roomId='+detailid.toString())
.then(response => response.json())
.then(json => 
        { 
            document.getElementById("distanceCal").innerHTML=(json.routes[0].distance).toString() / 1609 + " miles from " + tempPostcode + " to " + document.getElementById("usrpostcode").value;
        })
}

function roomApply()
{
localStorage.setItem("userapply",document.getElementById("usrapplyname").value);
console.log(document.getElementById("usrapplyname").value)

fetch("http://localhost:8080/RESTService/webresources/applicationapply", 
{
    method: "POST",
    body: JSON.stringify(
    {
      id: 0,
      name: document.getElementById("usrapplyname").value,
      activeApplications:
      [
        {
            roomIdentifier: localStorage.getItem("roomId"),
            roomName: localStorage.getItem("roomName"),
            applicationStatus: "pending" 
        }
      ],
      historialApplications:
      [

      ]
    }
),
    headers: {"Content-type": "application/json"}
});

location.reload()();
}
