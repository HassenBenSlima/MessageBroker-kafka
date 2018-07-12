# spring-boot-kafka

## Description :
ce projet est une  application simple dont laquel on utilise spring kafka .



## Environment :
* java 8
* apche kafka 2.12-1.1.0
* zookeeper 3.3.1
* angular 

## comment istaller kafka :
1. telecharcher kafka et zookeeper
	* `reference: https://www.apache.org/dyn/closer.cgi?path=/kafka/1.1.0/kafka_2.11-1.1.0.tgz`
2. extraire le fichier kafka_2.11-1.1.0.tgz 
3. démarrer le seveur kafka et zookeeper
	`.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties`
    `.\bin\windows\kafka-server-start.bat .\config\server.properties`
	
4. démarrer l'application 
*'partie back end':		
	* `mvn spring-boot:run`
*'partie front end':	
	*  `npm install`
	* `ng serve --open`
	
* cela va être ouvrir sur `http://localhost:4200`

le reference qui a nous guidée:
`http://javasampleapproach.com/java-integration/distributed-system/start-spring-apache-kafka-application-springboot`