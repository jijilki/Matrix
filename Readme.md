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


