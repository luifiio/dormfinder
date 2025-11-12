
var roomcontainer = document.createElement("div");
roomcontainer.id = "room-container";

var roomtitle = document.createElement("p");
roomtitle.id = "room-list-text";

var roomslistcontainer = document.getElementById("rooms-container");

var eventidentifier ; 
var titleidentifiers = [];
//



function loadroomlist()
{
fetch('http://localhost:8080/RESTService/webresources/room')
.then(response => response.json())
.then(json =>
    {
        var i = 0;
        var roomssize = json.rooms.length;
        const roomslistcontainer = document.getElementById("rooms-container");

        while(i<=roomssize)
        {   

            var roomcontainer = document.createElement("div");
            var roomtitle = document.createElement("p");
            
            var roomtitlecontent = document.createTextNode(json.rooms[i].name);

            roomslistcontainer.appendChild(roomcontainer);
            roomcontainer.appendChild(roomtitle);
            roomtitle.appendChild(roomtitlecontent);

        

            roomtitle.id = "room-list-text";
            roomcontainer.id = "room-container";
            roomcontainer.dataset.index = i; 


            roomcontainer.addEventListener('click', roomidparser);
            titleidentifiers[i] = roomtitlecontent.nodeValue;


            i++

        }
    })

}
function roomidparser(event) {
    var roomcontainer = event.currentTarget;
    var index = roomcontainer.dataset.index;
    var roomidentifier = titleidentifiers[index];

    localStorage.setItem("roomid", index);
    console.log(index);
    window.location.href = "room-detail.html";
}

//EVENT LIST SCRIPTS
