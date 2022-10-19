# modern-trade-platform
Hello World trade application

## Naming convention for ...
### Root folders
- libs-java - reusable code to reuse in uservices, deployed to external maven repository
- service-* - folder with a local stack service, designed to be run by root docker-compose
- uservice-* - seperated µservice designed to be compiled, developed and run separately. It may contains init-db subproject to apply database migration
### Other folders
- .api.rpc - definition of gRpc api, exposed in known-localtion for other services/.
- .api.events - (not existing yet) proposed name for place of avro api, exposed in known-localtion for other services/.
### Other files
- Dockerfile.local - image definition used just fo local development process, not to build final images

## How to run acceptance tests
### By developers:
- run local stack of services **docker-compose up** or, to recompile and run **docker-compose up --build**
- TBD: open and run test project
- TBD: Review result of gherkin reports

## Avoid clas of ports:
Rule: Use scope 18*** to simplify our management of ports
### Business Api Gateway
- dapr app id: uservice-trade
- HTTP: 18010
- GRPC: 18011
### TradeService
- dapr app id: uservice-trade
- HTTP: 18120
- GRPC: 18121
