## Titre du projet
  
Système messagerie et notification.

## Commencer

Vous pouvez télécharger le zip ou bien  utiliser  git :
git clone `https://github.com/HassenBenSlima/MessageBroker-kafka.git`


## Exigences
* Java 8
* Maven 
* [Kafka 2.12-1.1.0](https://kafka.apache.org/0102/documentation.html)
* [Zookeeper 3.4](https://zookeeper.apache.org/doc/r3.4.12/)
* Angular 1.7.4

## Conditions préalables 

vous devez Installer 

* Apache kafka (2.12-1.1.0) ( Courtier et l'agent de messages )
* ZooKeeper  (3.4) ( API  pour la synchronisation de    processus  distribuéssur de grands systèmes) 
* Environnement java (java 8 )
* Angular 1.7.4 (pour la partie frontend)  
* Bootstrap 3.3.7 (pour la partie frontend)  
* Spring Boot plugin
 

## Installation :

	1.  télécharger kafka et zookeeper :

	 * `https://www.apache.org/dyn/closer.cgi?path=/kafka/1.1.0/kafka_2.11-1.1.0.tgz`

	 2. extraire le dossier kafka_2.11-1.1.0.tgz 

	 3. démarrer le seveur kafka et zookeeper
	* .\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
    * .\bin\windows\kafka-server-start.bat .\config\server.properties
	
## Exécution de  l'application 

* `partie back end`:		
	* `mvn spring-boot:run`
* `partie front end`:	
	* `npm install`
	* `ng serve --open`  ou  bien
    * `ng serve ` + tapez  `http://localhost:4200` sur   votre  navigateur
	
## Auteurs :
 
 `Anis Hakim`
 
 `Hassen Benslima`
 
## Remerciements :

 Nous tenons  à remercier toute l'équipe Java de la société Spark-IT qui  nous a  donné 
 l'opportunité d'enrichir  nos compétences.
 

