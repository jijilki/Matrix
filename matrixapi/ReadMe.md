Okay! 

This application is made to understand and try out Okta2.0 with OpenId Connect Via Okta Provider. 
Both UI and Java apps are configured with Okta. On clicking the login button , UI application takes to Okta login screens. 
Then once logged in , Call back url will take it back to the application. We get a authorization token during this process.
This token will be send to all the request to Resource Server which is Java - Matrix API. 
For each of these request, Spring security verifies/ Authenticates using the client id and secret kept in the application yaml/props
(which is obviously a bad approch) . So once verified , take it to the controller.
Here we have used RepositoryRestResource , hence the repo itself creates the REST end points necessary , others are added in Controller too.

Used Open API UI - which provides Swagger URL ( shows only end points in Controller though, end points made with @RepositoryResource ) will not be available.
@RepositoryEventHandler used to add the user to the Note automatically , refer AddUsertoNotes class.
Used  grant type : Authorization Grant



