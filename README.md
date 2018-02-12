# SSPB
A coding kata

# ToDo

- add security (Basic Authentication, OAuth2, JWT)

# Misc

http://localhost:8080/swagger-ui.html  => for swagger ui

http://localhost:8080/v2/api-docs 	   => for swagger api docs as JSON

mvn package 			=> packages the jar

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


