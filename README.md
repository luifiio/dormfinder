# dormfinder

full-stack web application for student accommodation search and management, developed as part of a 3rd year university web development module.

dormfinder connects students with available accommodation through an intuitive interface featuring comprehensive search functionality, application tracking, and location-based services.

## bits

- **dynamic room listings** - Browse available accommodations with detailed information including location, amenities, pricing, and availability
- **advanced search & filtering** - Filter rooms by price range, furnishing status, shared facilities, and bill inclusion
- **application management** - Apply for rooms, track application status (pending/accepted/declined), and view application history
- **location services** - Calculate distances from postcodes to properties using external geocoding APIs
- **weather integration** - View local weather information for each property location
- **responsive design** - Seamless browsing experience across desktop and mobile devices


### server
- **java** - RESTful web service implementation
- **JAX-RS** - REST API endpoints
- **gson** - JSON serialization/deserialization
- **Apache Tomcat** - application server

### client
- **javaScript** - Dynamic client-side functionality ie dom manipulation
- **fetch API** - asynchronous data retrieval for json

### data
- **JSON** - file-based data persistence for rooms and applications

### external APIs
- **postcodes.io** - Postcode to coordinate conversion
- **weather API** - Local weather data retrieval


## project struct

```
dormfinder/
├── server/                    # Java REST API backend
│   ├── RESTService/
│   │   ├── room/             # Room management endpoints
│   │   ├── application/      # Application tracking endpoints
│   │   ├── distance/         # Distance calculation service
│   │   └── weather/          # Weather data service
│   └── resources/
│       ├── rooms.json        # Room data storage
│       └── applications.json # Application data storage
│
└── client/                    # Frontend web application
    ├── index.html            # Landing page
    ├── rooms.html            # Room listings
    ├── room-detail.html      # Detailed room view
    ├── applications.html     # User application tracking
    └── scripts/              # Client-side JavaScript
        ├── room-search.js
        ├── roomdetail.js
        ├── userapplication.js
        └── usr-search.js
```

1. **dependencies**
   - Java JDK 8+
   - Apache Tomcat 9+ or GlassFish 5+
   - NetBeans IDE (recommended)

2. **build/deploy**
   ```bash
   # open project in NetBeans
   # build project (Clean & Build)
   # deploy to application server
   # server will run on http://localhost:8080
   ```

3. **API endpoints**
   - `GET /RESTService/webresources/room` - Get all rooms
   - `GET /RESTService/webresources/room/{id}` - Get room by ID
   - `POST /RESTService/webresources/room` - Add new room
   - `GET /RESTService/webresources/application?name={username}` - Get user applications
   - `POST /RESTService/webresources/applicationapply` - Submit application
   - `POST /RESTService/webresources/removeApplication` - Remove application
   - `GET /RESTService/webresources/distanceCalc?postcode={code}&roomId={id}` - Calculate distance
   - `GET /RESTService/webresources/weather?postcode={code}` - Get weather data

### client

1. **Serve Static Files**
   ```bash
   # using Python HTTP server
   cd client
   python -m http.server 8000
   
   # Or use Live Server in vs code
   ```

2. **access client**
   - Open `http://localhost:8000` in browser

## Usage

1. **Browse Rooms** - View all available accommodations with filtering options
2. **Search** - Filter by price, amenities, location, and other criteria
3. **View Details** - Click on rooms for comprehensive information
4. **Check Distance** - Enter your postcode to calculate distance to property
5. **Apply** - Submit applications for rooms you're interested in
6. **Track Applications** - Monitor status of your applications in the applications page

## notes

- **rESTful Design** - Follows REST principles with appropriate HTTP methods
- **stateless Architecture** - No server-side session management
- **error Handling** - Comprehensive error checking on both client and server
- **external API Integration** - Demonstrates service-oriented architecture
