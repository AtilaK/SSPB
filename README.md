# SSPB
A coding kata

# ToDo

- Swagger for REST API?
- add security 

# sample client calls

curl -X POST -H "Content-Type: application/json" http://localhost:8080/play -d '{"shape": "Stein", "gameMode": "Klassik"}'

curl -X POST -H "Content-Type: application/json" http://localhost:8080/play -d '{"shape": "Schere", "gameMode": "Klassik"}'

curl -X POST -H "Content-Type: application/json" http://localhost:8080/play -d '{"shape": "Papier", "gameMode": "Klassik"}'

curl -X POST -H "Content-Type: application/json" http://localhost:8080/play -d '{"shape": "Brunnen", "gameMode": "Klassik"}'

curl -X POST -H "Content-Type: application/json" http://localhost:8080/play -d '{"shape": "Brunnen", "gameMode": "Fortgeschritten"}'

curl -X POST -H "Content-Type: application/json" http://localhost:8080/play -d '{"shape": "Stein", "gameMode": "Fortgeschritten"}'

curl -X POST -H "Content-Type: application/json" http://localhost:8080/play -d '{"shape": "Handtuch", "gameMode": "Fortgeschritten"}'

curl -X POST -H "Content-Type: application/json" http://localhost:8080/play -d '{"shape": "Stein", "gameMode": "Offline"}'

# misc

mvn package 			=> packages the jar
mvn spring-boot::run 	=> runs the jar (spring boot application)
