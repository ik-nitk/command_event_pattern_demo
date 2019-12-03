# Command event pattern demo

This is a simple spring based demo app which demonstrates event command pattern. This helps to build loosely coupled microservices.  
The pattern also implements command sourcing and event sourcing. Good article about command event pattern can be found [here](https://www.infoq.com/articles/microservice-event-choreographies/)

## Details

The app uses Spring pub-sub event handling for demo purpose. This could be any message based infrastructures like kafka/RabbitMQ.

* **DemoController**: Publish commands to CommandService
* **CommandService**: Forwards command to async command handler.
* **AsyncService**  : Handles the request and publish events.
* **QueryService**  : Handles events and saves events into DB.

## Usage

1) Open pom.xml in IDE. Run the DemoApplication.  
2) Index page will show a form. 
3) Input some data and press submit which will submit command.
4) The page will be redirected to a read page which will periodically polls for data processed by async service.   
