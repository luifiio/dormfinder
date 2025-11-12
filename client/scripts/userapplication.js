var activeAppContainer = document.createElement("div");
activeAppContainer.id = "room-container";

var actListTitle = document.createElement("p");
actListTitle.id = "room-list-text";

var activelistcontainer = document.getElementById("activecontainer");

var applicationidentifier ; 
var titleidentifiers = [];

//
var usrname = localStorage.getItem("usrfetch")

function loadUsrApplication()
{
fetch('http://localhost:8080/RESTService/webresources/application?name='+usrname)
.then(response => response.json())
.then(json =>
    {   
        localStorage.setItem('applicationData', JSON.stringify(json)); 
       console.log(json.name)
       usrid = json.id;
        var i = 0;
        var actSize = json.activeApplications.length;
        console.log(actSize)
        const activelistcontainer = document.getElementById("activecontainer");
      
        while(i<=actSize-1)
        {   
            var activeAppContainer = document.createElement("div");
            var actListTitle = document.createElement("p");
            var statuselement = document.createElement("p");
            var declineButton = document.createElement("button");

            var br = document.createElement("br");

            var actListTitlecontent = document.createTextNode(json.activeApplications[i].roomName);
       
            var roomStatus = document.createTextNode("application status: " + json.activeApplications[i].applicationStatus);
            var declineButtonText = document.createTextNode("Decline");

            activelistcontainer.appendChild(activeAppContainer);
            activeAppContainer.appendChild(actListTitle);
            activeAppContainer.appendChild(br);
            activeAppContainer.appendChild(br);
            declineButton.appendChild(declineButtonText);

            activeAppContainer.appendChild(statuselement);
            actListTitle.appendChild(actListTitlecontent);
            statuselement.appendChild(roomStatus);
            activeAppContainer.appendChild(declineButton);


            actListTitle.id = "room-list-text";
            activeAppContainer.id = "room-container";
            activeAppContainer.dataset.index = i;

            declineButton.addEventListener('click', declineRoom);
            //activeAppContainer.addEventListener('click', eventdetailparser);
            titleidentifiers[i] = actListTitlecontent.nodeValue;


            i++;

        }

        i = 0;
        var histsize = json.historialApplications.length;
        console.log(histsize);
        console.log(json.historialApplications[i].roomName);

        const historicalcontainer = document.getElementById("historicalcontainer");

        while(i<=histsize-1)
            {   
                var histcontainer = document.createElement("div");
                var actListTitle = document.createElement("p");
                var statuselement = document.createElement("p");
                var br = document.createElement("br");

                var actListTitlecontent = document.createTextNode(json.historialApplications[i].roomName);
                var roomStatus = document.createTextNode("finalised status: " + json.historialApplications[i].finialisedStatus);

                historicalcontainer.appendChild(histcontainer);
                histcontainer.appendChild(actListTitle);
                histcontainer.appendChild(br);
                histcontainer.appendChild(br);

                histcontainer.appendChild(statuselement);
                actListTitle.appendChild(actListTitlecontent);
                statuselement.appendChild(roomStatus);

    
                actListTitle.id = "room-list-text";
                histcontainer.id = "room-container";    
    
                i++
    
            }
    })

}

function declineRoom(room)
{
    var activeAppContainer = room.target.closest('#room-container');
    var index = activeAppContainer.dataset.index;
    var roomName = titleidentifiers[index];
    console.log(roomName);

    fetch('http://localhost:8080/RESTService/webresources/removeApplication', {
        method: 'POST',
        headers: 
        {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(
        { 
        name: usrname,   
        id: usrid,
        roomName: roomName
        })
    });

    location.reload()();
}


