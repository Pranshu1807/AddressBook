SET SQL_SAFE_UPDATES = 0;


/*Creating Database*/
Create Database AddressBookService;
SHOW DATABASES;


/* Creating Address Book Table*/
use  AddressBookService;
CREATE TABLE AddressBook (
contact_id INT PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    address VARCHAR(50),
    city VARCHAR(50),
    state VARCHAR(50),
    zip VARCHAR(50),
    phone_number varchar(10),
    email varchar(50)
);


/* Inserting contacts in Address Book */
insert into  AddressBook(contact_id,first_name,last_name,address,city,state,zip,phone_number,email) 
values(1,'Pranshu','Srivastava','Senani Nagar','Pratapgarh','UP','230001','9580281173','pranshusrivastava000@gmailcom');
insert into  AddressBook(contact_id,first_name,last_name,address,city,state,zip,phone_number,email) 
values(2,'Ajay','Singh','XYZ','Lucknow','UP','230321','9514511273','random1@gmailcom');
insert into  AddressBook(contact_id,first_name,last_name,address,city,state,zip,phone_number,email) 
values(3,'Rahul','Sharma','ABC DEF','Bhopal','MP','2301241','9128012413','random2@gmailcom');
insert into  AddressBook(contact_id,first_name,last_name,address,city,state,zip,phone_number,email) 
values(4,'Raj','Yadav','ABCDEF','Pratapgarh','MP','230001','8238112423','random3@gmailcom');
insert into  AddressBook(contact_id,first_name,last_name,address,city,state,zip,phone_number,email) 
values(5,'Ayush','Yadav','ABCDEF2','Allahabad','UP','230001','8238112423','random4@gmailcom');
insert into  AddressBook(contact_id,first_name,last_name,address,city,state,zip,phone_number,email) 
values(6,'Abhinav','Verma','ABCDEF3','Pratapgarh','UP','230001','8238112423','random5@gmailcom');
insert into  AddressBook(contact_id,first_name,last_name,address,city,state,zip,phone_number,email) 
values(7,'Yash','Singh','ABCDEF4','Bhopal','MP','230001','8238112423','random6@gmailcom');

select * from AddressBook;


/*Editing existing contact using name*/
update AddressBook
set
	address="DEFABC",
    email="randomxyz1@gmail.com"
where first_name="Rahul";


/* Deleting a person using person's name*/
delete from AddressBook
where first_name="Ajay";


/* Retrieve Person belonging to a City or State */
select * from AddressBook where city="Pratapgarh";
select * from AddressBook where state="UP";
select * from AddressBook where state="MP";


/*Ability to understand the size of address book by City and State*/
SELECT city, COUNT(*) AS city_count
FROM AddressBook
GROUP BY city;
SELECT state, COUNT(*) AS state_count
FROM AddressBook
GROUP BY state;


/*Ability to retrieve entries sorted alphabetically by Person’s name for a given city*/
SELECT * from AddressBook
where city="Pratapgarh"
ORDER BY first_name;


/*Ability to identify each Address Book with name and Type*/



