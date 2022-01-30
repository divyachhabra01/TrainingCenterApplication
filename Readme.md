
#Training Center Application
## Description
Training Center Application contains information related to Goverment funded Training Centers.

NOTE: You don't need to create DB tables ,it will create itself once you build the Project.

## Apis
It contains the following apis:
* GET "v1/centers" : It is used to get list of all training centers.
=========================================================
  curl --location --request GET 'http://localhost:8080/v1/centers' \
  --header 'Content-Type: application/json' \
  --data-raw '{"centerCode": "kjvh56788021",
  "centerName":"test center 1",
  "studentCapacity":60,
  "address":{
  "state":"UP",
  "city":"new york",
  "detailedAddress":"XYZ road",
  "pinCode":247776
  },
  "courses":[
  {
  "courseName":"Java"

},
{
"courseName":"SpringBoot"
}
],
"contactEmail":"help@gmail.com",
"contactPhone":"8445958023"
}'
=========================================================
* POST "v1/center" : It is used to add a new training center.
=========================================================
  curl --location --request POST 'http://localhost:8080/v1/center' \
  --header 'Content-Type: application/json' \
  --data-raw '{"centerCode": "kjvh56788021",
  "centerName":"test center 1",
  "studentCapacity":60,
  "address":{
  "state":"UP",
  "city":"new york",
  "detailedAddress":"XYZ road",
  "pinCode":247776
  },
  "courses":[
  {
  "courseName":"Java"

},
{
"courseName":"SpringBoot"
}
],
"contactEmail":"help@gmail.com",
"contactPhone":"8445958023"
}'
=========================================================
## Project Structure
It contains the following files:
1. TrainingCenterController.java: It is a REST controller that provides endpoints for get and post request.

2. TrainingCenterService.java: It is a service class that contains all the business logic.

3. TrainingCenterRepository.java: It connects with the database and provides method for performing basic CRUD operations.

4. TrainingCenter.java: It is a entity class that contains complete training center information.
   
5. Address: It is a entity class that contains  information about address of training centers.

6. Course: It is a entity class that contains information related to the courses offered by each training center.
   
7. TrainingCenterDTO: It is DTO class .

Tools and Technologies Used:
1. Spring Boot
2. Hibernate
3. MySQL
4.The Project Lombok
5. Model Mapper
6. Hibernate Validator

  
 