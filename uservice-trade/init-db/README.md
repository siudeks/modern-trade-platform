1. Start **docker-compose up** to run just dockerized database server with all init-db scripts
2. If you would like to remove images and start from scratch, stop **docker-compose down** and start again
3. Play individual commands like:
   1. **mvn -pl init-db liquibase:help**
   2. **mvn -pl init-db liquibase:rollback -Dliquibase.rollbackTag=v0** do rollback to empty tables
   3. **mvn -pl init-db liquibase:update** to aply all changes
   4. **mvn -pl init-db liquibase:rollback -Dliquibase.rollbackCount=1** do rollback one change
34. Or, test script manually **docker-compose up --build** to  run database and migrations
