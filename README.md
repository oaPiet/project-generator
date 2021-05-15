# project-generator project

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
./mvnw package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/project-generator-1.0.0-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.html.

## Related guides

- RESTEasy JAX-RS ([guide](https://quarkus.io/guides/rest-json)): REST endpoint framework implementing JAX-RS and more

## Deploy in Minikube

- Install minikube: https://minikube.sigs.k8s.io/docs/start/

- Open terminal and execute the command: 
```shell script  
eval $(minikube -p minikube docker-env)
```

- Create a local database: 
```shell script
docker-compose -f docker-compose.yml up -d
```
- Install ngrok: https://ngrok.com/download

- Run this command:
```shell script
./ngrok tcp 3307 
```

![image](https://user-images.githubusercontent.com/7121937/118346388-a05cdd00-b500-11eb-91bf-06f01e4ebcf8.png)

- When you get **host** and **port** put inside this files:

_**k8s/dev/externalName/mariadb-service.yml**_

![image](https://user-images.githubusercontent.com/7121937/118346396-ace13580-b500-11eb-98e4-737ddce3ce7b.png)

_**k8s/dev/config-map.yml**_

![image](https://user-images.githubusercontent.com/7121937/118346402-b7033400-b500-11eb-9987-a7898a0f18b3.png)

[comment]: <> (- Then execute this command to get the ip from the database container: )

[comment]: <> (```shell script  )

[comment]: <> (docker inspect -f '{{range.NetworkSettings.Networks}}{{.IPAddress}}{{end}}' project-generator-db)

[comment]: <> (```)

[comment]: <> (- When you get the Ip put inside in the service **k8s/dev/mariadb-service.yml** in this section:)

[comment]: <> (![img.png]&#40;img.png&#41;)
  
- Then execute 
```shell script  
./build_project.sh
```

- Finally execute: 
```shell script  
minikube service project-generator -n project-generator-ns
```

![image](https://user-images.githubusercontent.com/7121937/118346408-bd91ab80-b500-11eb-8197-f5df019facc9.png)

- With the previous information, test the API:   

http://HOST:PORT/api/v1/user/create

**Example:** 

![image](https://user-images.githubusercontent.com/7121937/118346427-d26e3f00-b500-11eb-8761-d6edfa1f35be.png)

