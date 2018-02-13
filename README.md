# SSPB

A coding kata

# ToDo

Add security (JWT)

# Misc

http://localhost:8080/swagger-ui.html  => for Swagger ui

http://localhost:8080/v2/api-docs 	   => for Swagger api docs as JSON

mvn package 			=> packages the jar, runs tests and creates jacoco test reports (target/site/jacoco/index.html)

mvn spring-boot::run 	=> runs the jar (spring boot application)

# Sample client calls

curl -X POST -H "Content-Type: application/json" http://localhost:8080/play -d '{"shape": "Stein", "gameMode": "Klassik"}'

curl -X POST -H "Content-Type: application/json" http://localhost:8080/play -d '{"shape": "Schere", "gameMode": "Klassik"}'

curl -X POST -H "Content-Type: application/json" http://localhost:8080/play -d '{"shape": "Papier", "gameMode": "Klassik"}'

curl -X POST -H "Content-Type: application/json" http://localhost:8080/play -d '{"shape": "Brunnen", "gameMode": "Klassik"}'

curl -X POST -H "Content-Type: application/json" http://localhost:8080/play -d '{"shape": "Brunnen", "gameMode": "Fortgeschritten"}'

curl -X POST -H "Content-Type: application/json" http://localhost:8080/play -d '{"shape": "Stein", "gameMode": "Fortgeschritten"}'

curl -X POST -H "Content-Type: application/json" http://localhost:8080/play -d '{"shape": "Handtuch", "gameMode": "Fortgeschritten"}'

curl -X POST -H "Content-Type: application/json" http://localhost:8080/play -d '{"shape": "Stein", "gameMode": "Offline"}'
