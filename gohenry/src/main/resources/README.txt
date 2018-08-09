README.txt
==========

1. Run the schema.txt on the H2 database
2. Compile and run the code there will be JUnit failures
3. Use postman to put this data in the database(POST) http://localhost:8080/parents
{  
   "id":1,
   "title":"Mrs",
   "firstName":"Jane",
   "lastName":"Doe",
   "emailAddress":"jane.doe@gohenry.co.uk",
   "dateOfBirth":"1990-06-03",
   "gender":"female",
   "secondName":"",
   "children":[  
      {  
         "id":2,
         "firstName":"Janet",
         "lastName":"Doe",
         "emailAddress":"janet.doe@gohenry.co.uk",
         "dateOfBirth":"2010-05-22",
         "gender":"female",
         "secondName":""
      },
      {  
         "id":3,
         "firstName":"Jason",
         "lastName":"Doe",
         "emailAddress":"jason.doe@gohenry.co.uk",
         "dateOfBirth":"2008-12-05",
         "gender":"male",
         "secondName":""
      }
   ]
}
4. Run the JUnit tests again all should be well.