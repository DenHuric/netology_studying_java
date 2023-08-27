CREATE TABLE PERSONS (
name varchar(255) NOT NULL, 
surname varchar(255) NOT NULL, 
age int NOT NULL, 
phone_number int, 
city_of_living (varchar),
PRIMARY KEY (name, surname, age)
);
