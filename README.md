TRADER FACTORY

This project's goal is to provide a simple tool in the form of a web application,
which gives advices about stock markets based on machine learning algorithms used
for pattern detection. The patterns that I'll be looking for are japanese candlesticks.

About the project's architecture and techcnology stack
It will use a backend in Java Spring Framework and microservices. Each microservice will
be a Spring Boot. The backend will use a Spring Security.

For gateway, I'll use Spring Cloud with Netflix Zull library and Spring Cloud with Netflix 
Eureka for service discovery.

The database technology chosen is PostgreSQL, backed up with ElasticSearch in parallel
for faster queries. The PostgreSQL database is responsible for the CRUD operations and 
bulk inserts, these inserts will be done periodically by a Spring Batch job. ElasticSearch
will be used just for querying the database.

A Noje.js Rest API will be used to fetch data from Google Finance, node cron will be the 
scheduler.

On the Frontend Angular 2 and React will be used to create a rich user interface.




