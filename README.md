# modern-trade-platform
Hello World trade application

## Naming convention for ...
### Root folders
- service-* - folder with a local stack service, designed to be run by root docker-compose
- uservice-* - seperated µservice designed to be compiled, developed and run separately. It may contains init-db subproject to apply database migration
### Other elements
- Dockerfile.local - image definition used just fo local development process, not to build final images

## How to run acceptance tests
### By developers:
- run local stack of services **docker-compose up** or, to recompile and run **docker-compose up --build**
- TBD: open and run uservices
- TBD: open and run test project
- Review result of gherkin reports
