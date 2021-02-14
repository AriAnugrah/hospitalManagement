##### What program it is?

this is program about hospital management CRUD using jdbctemplate and thymeleaf. theres couple of depedency that i use in this program : 

1. mysql connector = for the database
2. jdbctemplate = for the sql query
3. thymeleaf = for html view

and other depedency that you can see in pom.xml



##### How to use

1. make mysql database and name it as "hospital" (without quote)

2. make table name "patients" (without quote)

3. make 5 field as follow :

   id, int(10), primary key

   name, varchar(100)

   alamat, varchar(100)

   golongan, int(5)

   umur, int(5)

4. make table name "room" (without quote)

5. make 5 field as follow :

   id, int(10) primary key

   roomname, varchar(100)

   code, int(10)

   bed, int(10)

   status boolean, default 1

6. now go to application properties,  and change data url database, username, password sama as your mysql setting

7. run the program, and go to localhost:8080

8. go to localhost:8080/patient_table to see list patient

9. go to localhost:8080/room_table to see list room



##### how to use(other way)

1. i'm include sql file named hospital.sql in same place as readme.md
2. you can import it to your mysql database
3. now follow step 6 next

