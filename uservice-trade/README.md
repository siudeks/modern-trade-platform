# Quality

- Checkstyle
- TestContainers
- Archunit
- Database upgrades with rollbacks

## Working with single services
- run local stack
- test local database migrations
- run service from vscode

## Knownw issues
- sudo chown -R $USER . (when Failed to clean project)

## Architectural decisions (simplified version):
- Use spring to run single uservices
- Use grpc to communicate between 
- ? use Gherking to aply acceptance tests for the shole solution
- ? expose Gateway as reusable OpenFeign interfaces to avoid duplication of client/server contracts
