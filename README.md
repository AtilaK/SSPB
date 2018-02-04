# SSPB
A coding kata

# ToDo

- add tests for playcontroller
- add check for rules: Not both users can win!
- logging missing
- swagger for REST API?

# sample client calls

curl -X POST -H "Content-Type: application/json" http://localhost:8080/play -d '{"shape": "stein", "gameMode": "Klassik"}'

curl -X POST -H "Content-Type: application/json" http://localhost:8080/play -d '{"shape": "Schere", "gameMode": "Klassik"}'

curl -X POST -H "Content-Type: application/json" http://localhost:8080/play -d '{"shape": "Papier", "gameMode": "Klassik"}'

curl -X POST -H "Content-Type: application/json" http://localhost:8080/play -d '{"shape": "Brunnen", "gameMode": "Klassik"}'

curl -X POST -H "Content-Type: application/json" http://localhost:8080/play -d '{"shape": "Brunnen", "gameMode": "Fortgeschritten"}'

curl -X POST -H "Content-Type: application/json" http://localhost:8080/play -d '{"shape": "Stein", "gameMode": "Fortgeschritten"}'

curl -X POST -H "Content-Type: application/json" http://localhost:8080/play -d '{"shape": "blabla", "gameMode": "Fortgeschritten"}'

curl -X POST -H "Content-Type: application/json" http://localhost:8080/play -d '{"shape": "Stein", "gameMode": "blabla"}'

# misc

mvn package 			=> packages the jar
mvn spring-boot::run 	=> runs the jar (spring boot application)
