


Okay!

This application is made to understand and try out Okta2.0 with OpenId Connect Via Okta Provider. Both UI and Java apps are configured with Okta. On clicking the login button , UI application takes to Okta login screens. Then once logged in , Call back url will take it back to the application. We get a authorization token during this process. This token will be send to all the request to Resource Server which is Java - Matrix API. For each of these request, Spring security verifies/ Authenticates using the client id and secret kept in the application yaml/props (which is obviously a bad approch) . So once verified , take it to the controller. Here we have used RepositoryRestResource , hence the repo itself creates the REST end points necessary , others are added in Controller too.

Used Open API UI - which provides Swagger URL ( shows only end points in Controller though, end points made with @RepositoryResource ) will not be available. @RepositoryEventHandler used to add the user to the Note automatically , refer AddUsertoNotes class. Used grant type : Authorization Grant




NODE / NPM / ANGULAR VERSION Setup

node --version
v14.15.4

npm --version
6.14.10

npm install -g @angular/cli


Angular CLI: 11.0.6
Node: 14.15.4
OS: win32 x64

Angular:
...
Ivy Workspace:

Package                      Version
------------------------------------------------------
@angular-devkit/architect    0.1100.6 (cli-only)
@angular-devkit/core         11.0.6 (cli-only)
@angular-devkit/schematics   11.0.6 (cli-only)
@schematics/angular          11.0.6 (cli-only)
@schematics/update           0.1100.6 (cli-only)


ANGULAR COMMANDS



ng new Matrix
? Do you want to enforce stricter type checking and stricter bundle budgets in the workspace?
  This setting helps improve maintainability and catch bugs ahead of time.
  For more information, see https://angular.io/strict Yes
? Would you like to add Angular routing? Yes
? Which stylesheet format would you like to use? CSS


ng serve 

ng add @oktadev/schematics --issuer=$issuer --clientId=<YourClient ID > \ --issuer <Your domainname/oauth2/default>


npm i -D angular-crud@1.0.0
mkdir -p src/app/note 
After model.json made 
ng g angular-crud:crud-module note
// Incase getting error : https://stackoverflow.com/questions/62917001/cannot-find-module-schematics-angular-utility-project


