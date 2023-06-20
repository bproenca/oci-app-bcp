#!/bin/bash
tag="v2"

echo "## Package JAR"
./mvnw clean package

echo "## RMI $tag"
docker rmi bproenca/oci-app-bcp:$tag

echo "## Build docker image"
docker build -f Dockerfile -t bproenca/oci-app-bcp:$tag .
