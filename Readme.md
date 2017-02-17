# EGA.Data.API.v3.DOWNLOADER

This is a Database Interaction Server. It (1) provides File/Dataset information (2) handles request/download ticketing, and (3) performs basic database logging

Dependency: 
* CONFIG (`https://github.com/elixir-europe/ega-data-api-v3-config`). The `'bootstrap-blank.properties'` file must be modified to point to a running configuration service, which will be able to serve the `application.properties` file for this service `ACCESS`
* EUREKA (`https://github.com/elixir-europe/ega-data-api-v3-eureka`). ACCESS service will contact the other services via EUREKA and registers itself with it.

### Documentation

DOWNLOADER primarily interacts with the databases used by the API. It sits behind the edge services, which enforce Authentication and Authorization before any call to this service is made. This service peforms no further securoty checks.

[GET] `/stats/load` (not secured by token; used by the load balancer heartbeat.)
[GET] `/datasets/{dataset_id}/files`
[GET] `/files/{file_id}`
[POST] `/request`
[DELETE] `/request`
[DELETE] `/requests/{user_email}/{request_label}`
[DELETE] `/requests/{user_email}/tickets/{ticket_uuid}`
[GET] `/requests/ticket/{ticket_uuid}`
[POST] `/log/event`
[POST] `/log/download`

### Databases

There are 5 tables necessary for this service:

* File (read-only for this service): This table contains all files held at the current location. Files are identified by the unique EGAF File ID and are placed in Dtasets with unique EGAD IDs (permissions are granted on a dataset-level) This table also contains the absolute path/URL to the archived file.

* DownloadTicket: A Request creates one download ticket per requested file. The Ticket UUID in this table is later used to download this file.
* DownloadTicketStatusCv: Code values

* DownloadLog: Logs downloads - both successes and failures

* Event: Generic table to log 'events' of interest

### Usage Examples


### Todos

 - Write Tests
- Add Database SQL files [use the entity classes as guides for now]

