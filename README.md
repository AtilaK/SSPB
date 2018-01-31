# SSPB
A coding kata

mvn package 			=> packages the jar
mvn spring-boot::run 	=> runs the jar (spring boot application)

to start in debug       => right click on main class of the application 


sample client call

curl -X POST -H "Content-Type: application/json" http://localhost:8080/play -d '{"shape": "stein", "gameMode": "klassik"}'

curl -X POST -H "Content-Type: application/json" http://localhost:8080/play -d '{"shape": "schere", "gameMode": "klassik"}'

curl -X POST -H "Content-Type: application/json" http://localhost:8080/play -d '{"shape": "papier", "gameMode": "klassik"}'

curl -X POST -H "Content-Type: application/json" http://localhost:8080/play -d '{"shape": "brunnen", "gameMode": "klassik"}'

curl -X POST -H "Content-Type: application/json" http://localhost:8080/play -d '{"shape": "brunnen", "gameMode": "fortgeschritten"}'

curl -X POST -H "Content-Type: application/json" http://localhost:8080/play -d '{"shape": "stein", "gameMode": "fortgeschritten"}'

curl -X POST -H "Content-Type: application/json" http://localhost:8080/play -d '{"shape": "blabla", "gameMode": "fortgeschritten"}'

curl -X POST -H "Content-Type: application/json" http://localhost:8080/play -d '{"shape": "stein", "gameMode": "blabla"}'
