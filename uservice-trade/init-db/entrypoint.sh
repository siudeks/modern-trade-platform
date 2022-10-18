MVN_OPTIONS="-Dmaven.repo.local=/.m2/repository --quiet"
# - to discuss permissions vs startability
# ./mvnw $MVN_OPTIONS clean install -pl build-tools
./mvnw $MVN_OPTIONS spring-boot:run -pl init-db
