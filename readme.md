# Project Setup and Execution Guide

This guide provides step-by-step instructions to build and run the project using Docker and Docker Compose.

## Prerequisites

Ensure you have the following installed:
- Docker
- Docker Compose

## Download libraries

- [Apache Commons Pool » 2.6.2](https://repo1.maven.org/maven2/org/apache/commons/commons-pool2/2.6.2/commons-pool2-2.6.2.jar)
- [Jedis » 2.9.0](https://repo1.maven.org/maven2/redis/clients/jedis/2.9.0/jedis-2.9.0.jar)
- [SLF4J API Module » 1.7.26](https://repo1.maven.org/maven2/org/slf4j/slf4j-api/1.7.26/slf4j-api-1.7.26.jar)
- [Tomcat Clustering Redis Session Manager 3.0.1.1](https://github.com/ran-jit/tomcat-cluster-redis-session-manager/releases/download/3.0.1.1/tomcat-cluster-redis-session-manager-3.0.1.1.jar)

### Download Tomcat 9
- [Tomcat 9.0.98](https://dlcdn.apache.org/tomcat/tomcat-9/v9.0.98/bin/apache-tomcat-9.0.98.zip)

This tomcat versions is the last version before **javax package** is refactor to **jakarta package**. 

## Building the Docker Image

1. Build the Docker image for the Tomcat server:

    ```sh
    docker build -t tomcat-image .
    ```

## Running the Tomcat Container

1. Remove any existing container named `poc-tomcat`:

    ```sh
    docker rm poc-tomcat
    ```

2. Run the Tomcat container:

    ```sh
    docker run --name poc-tomcat -p 8080:8080 tomcat-image
    ```

## Running the Project with Docker Compose

1. Build and start the services defined in the `docker-compose.yml` file:

    ```sh
    docker-compose up --build
    ```

## Running the Redis Container

1. Remove any existing container named `redis-container`:

    ```sh
    docker rm redis-container
    ```

2. Run the Redis container:

    ```sh
    docker run --name redis-container -p 6379:6379 -d redis:latest
    ```

## Accessing Redis CLI

1. Connect to the Redis CLI:

    ```sh
    redis-cli -h localhost -p 6379
    ```

2. List all keys:

    ```sh
    KEYS *
    ```

3. Get the value of a specific key:

    ```sh
    GET mykey
    ```

## Inspecting the Class Path

1. Inspect the class path using `jcmd`:

    ```sh
    jcmd <process_id> VM.class_hierarchy -i -s
    ```

Replace `<process_id>` with the actual process ID of your running application.

## Additional Resources

For more information, refer to the **Tomcat session Manager** for [Redis](https://redis.io/), access official [GitHub repository](https://github.com/ran-jit/tomcat-cluster-redis-session-manager).

*or*

Other option is about use **Tomcat session Manager** for [Mencached](https://memcached.org/). For more information about, access the official [GitHub repository](https://github.com/magro/memcached-session-manager)