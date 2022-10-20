# Quality

- Checkstyle
- TestContainers
- Archunit
- Database upgrades with rollbacks

## Working with single services
- run local stack
- test local database migrations
- run service from vscode

## Known issues
- sudo chown -R $USER . (when Failed to clean project)

## Architectural decisions (simplified version):
- Use spring to run single uservices
- Use grpc to communicate between 
- ? use Gherkin to apply acceptance tests for the whole solution
- ? expose Gateway as reusable OpenFeign interfaces to avoid duplication of client/server contracts
