#!/bin/bash

# Create a local database
docker-compose -f docker-compose.yml up -d

# Create namespace and needed components
kubectl apply -f k8s/dev/namespace.yml
kubectl apply -f k8s/dev/externalName/mariadb-service.yml
kubectl apply -f k8s/dev/config-map.yml
kubectl apply -f k8s/dev/secrets.yml

# Build image project
mvn clean package -Dquarkus.container-image.build=true

# Deploy project in Kubernetes
kubectl apply -f target/kubernetes/minikube.yml
kubectl delete pods --all -n=project-generator-ns