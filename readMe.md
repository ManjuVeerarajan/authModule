Step 1: run update maven project
Step 2: run maven clean install
Step 3: start the server
Step 4:the application runs on H2 database, so no database configuratin required
      #postman collection added which can be helpful in running the api
      #The datas are already added to respective tables through liquibase
------------------------------------------------------------------------------------------------------------------------------------------
#The application uses Repository Pattern,basic spring boot starter and hibernate libraries along with liquibase,lombok and spring security dependencies are used.
#The solution designed with associated objects which makes it easier to specify the target entity.
#Alternatives considered:Instead of H2 database, Relational databases can be used in order to handle large requests and better security. 
 Basic authorization is used for demo purposes only, we can use bearer auth for better security.
#Scalability: The solution is scalable because of the entity association used in the project makes it perform efficiently to obtain the desired output for a large scale of inputs.
------------------------------------------------------------------------------------------------------------------------------------------
