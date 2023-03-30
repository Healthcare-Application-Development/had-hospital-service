__To generate new instances of hospital__
Run the following commands:

In frontend folder (__had-frontend__):
__docker build -t frontend .__

Name of image must be __frontend__.

In the backend folder(__had-hospital-service__):
__docker build -t backend .__

Name of image must be __backend__.

had-hospital-service contains the Docker Compose file

To generate instances, we do the following:

In Linux:
__CONTAINER_NAME=hospital1 docker-compose -p hospital1 up__

For more instances, change the CONTAINER_NAME as well as the value of the -p to hospital2/hospital3 etc

For Windows:

Create an .env file in the root of the folder of had-hospital-service

Add:
__CONTAINER_NAME=hospital1__

Run:
__docker-compose -p hospital1 up__

For more instances, change the value in .env file and run it again with a different -p option.

For another instance, we run:
__docker-compose -p hospital2 up__

Now there are multiple instances of the hospital instance.