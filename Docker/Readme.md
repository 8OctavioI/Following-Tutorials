This project is done by following the Docker Course by DomeTrain. 



Progress:

1. Installing Docker Desktop: Done.
2. Running Docker Hello-World Container: Done.

    docker run hello-world


3. Running A simple Website off an apache server: Done.

    Create Dockerfile {<h4>

        FROM httpd

        RUN rm -rf /usr/local/apache2/htdocs/*

        RUN chmod u+x /usr/local/apache2/htdocs/

        COPY . /usr/local/apache2/htdocs/

    }</h4>

    docker build -t [image-name] .

    docker run -d -p 80:80 --name [container-name] [image-name]


4. Running a simple node.js server: Done.

    Create Dockerfile {<h4>

        FROM node

        COPY . .

        EXPOSE 80

        CMD ["node", "server.js"]

    }</h4>

    docker build -t [image-name] .
    
    docker run -d -p 80:80 --name [container-name] [image-name]


5. Running a simple PHP server: Done. 

    Create Dockerfile {<h4>

        FROM php:8.2-apache

        RUN chmod u+x /var/www/html

        COPY ./application/* /var/www/html

    }</h4>

    docker build -t [image-name] .

    docker run -d -p 80:80 --rm --name [container-name] [image-name]

6. Running a simple MySQL database: Done.

    docker run -d -p 3306:3306 -e MYSQL_ROOT_PASSWORD=[root-password] --name [container-name] mysql


7. Accessing the contents of MySQL server running on one container from PHP running on a different container: Done.

    docker run -d -p 3306:3306 -e MYSQL_ROOT_PASSWORD=[root-password] --name [container-name] mysql

    Create Dockerfile {<h4>

        FROM php:8.2-apache

        COPY . /var/www/html

        RUN docker-php-ext-install mysqli  

    }</h4>

    docker build -t [image-name] .

    docker run -d -p 80:80 --name [container-name] [image-name]

8. Connecting to the same network to use container names instead of IP addressess to communicate: Done.

    docker network ls

    docker network create [network-name]

    docker run -d -p 3306:3306 --network [network-name] --name [container-name] -e MYSQL_ROOT_PASSWORD=1234  mysql

    Replace IP address with [container-name] in PHP file. The container name acts as a DNS name for the IP address on the same network. 

    docker build -t [image-name-2] .

    docker run -d -p 80:80 --rm --network [network-name] --name php-instance [image-name-2]

9. Using Copy and Execute commands on an existing container: Done.
    
    Create the PHP and MySQL instances from previous setup. 

    Update the MySQL instance by copying a sql file from system to container and running it in container:

        docker exec [mysql-instance] mysql -u root -p appdb -e "USE appdb;"

        docker exec [mysql-instance] mysql -u root -p appdb -e "CREATE TABLE Course(CourseID int,   CourseName varchar(1000),Rating numeric(2,1));"

        docker exec [mysql-instance] mysql -u root -p appdb -e "INSERT INTO Course(CourseID,CourseName,Rating) VALUES(1, 'Docker and Kubernetes',4.5);"

    Reload site to view changes. 

10. Using Bind Mount to mount a folder on the base system to a folder on the container: Done.

    docker run -d -p 80:80 --mount type=bind,source=[source-path],target=[destination-path] --name [container-name] [image-name]

    ex: docker run -d -p 80:80 --mount type=bind,source=/home/project/Projects/Docker/6.\ PHP\ application\ with\ bind\ mounts,target=/var/www/html --name php-instance php:8.2-apache

    Now Update the files in host system and the files in the container will reflect that. 

    Note: Can be used in development stages, but is not recommended during deployment.

11. Using volumes for persistent storage: 
    
    Note: This can be used in deployment to share storage between containers. 

    docker volume create [volume-name]

    Note: For MySQL images, any file that is put in /docker-entrypoint-initdb.d/ will be executed on image creation. 

    Create Dockerfile {

        FROM mysql as base

        ENV MYSQL_ROOT_PASSWORD=[root-password]

        ENV MYSQL_DATABASE=[database-name]

        COPY 01.sql /docker-entrypoint-initdb.d/

    }

    docker build -t [image-name] .

    docker run -d -p 3306:3306 --name [container-name] --rm -v [volume-name]:[target-location-path] [image-name]

    Update the database as you wish. 

    Delete container and create new one, and as long as the volume is mounted the data will persist. 

12. Using Docker Compose: Done.

    Build all necessary images. 

    Create Docker compose file.

    docker-compose.yaml {

            services:

              [app-name]:

                container_name: [container-name]

                image: [image-name]

                ports: 

                  -  "[port1]:[port2]"

              [service-2-name]:

                container-name: [container-name-2]

                image: [image-name-2]

                ports:

                  -  "[port1]:[port2]"

                  
    }

    docker compose up -d : To run all necessary containers.

    docker compose down  : To stop and remove all services. 

        
13. Using Docker Compose with Networks and Volumes: 

    Create network

    Create Volume

    Create Docker Compose File {

        services:

        phpapp:

            container_name: php-instance

            image: phpapp:v1

            build: "./5. PHP and MySQL on 2 different containers/application/"

            depends_on:

            - mysqlapp

            networks:

            - app-network

            ports:

            - "80:80"

        mysqlapp:

            container_name: mysql-instance

            image: mysqlapp:v1

            build: "./7. MySQL database with persistent storage/"

            volumes:

            - type: volume

                source: mysql-data

                target: /var/lib/mysql

            networks:

            - app-network

            ports:

            - "3306:3306"

            environment:

            - MYSQL_ROOT_PASSWORD=1234

            - MYSQL_DATABASE=appdb


        networks:

        app-network:

            name: "app-network"

            external: true


        volumes:

        mysql-data:

            name: "mysql-data"

            external: true

            
                

    }

    docker compose up -d

    docker compose down


9. Other important commands:

        docker ps -a : Lists all available containers

        docker network ls : Lists all available networks

        docker images : Lists all available images



        docker stop [container-name] : Stops a running container

        docker kill [container-name]

        docker rm [container-name] : This removes the container

        
        docker network rm [network-name] : Deletes the specified network

        docker network prune : Deletes unused networks

        docker volume ls : List all volumes

        docker volume prune : Remove all unused volumes
        

        docker rmi [image-name] : Deletes specified image

        docker cp [source-path] [container-name]:[destination-path] : Use this command to copy files from system to container after creation of container

        docker exec -it [container-name] [command] : Execute a command in running container. it flag stands for interactive mode

        docker compose ps -a : Lists all running services. 