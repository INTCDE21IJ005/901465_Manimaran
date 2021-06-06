DROP SCHEMA IF EXISTS cts;
create schema cts;
use cts

insert into menuitems(id,name,price,active,date_of_launch,category,free_delivery)
values
(100,"Sandwich",10000,true,"2017-12-17","maincourse",true),
(101,"Burger",10000,true,"2017-12-17","maincourse",true),
(102,"Pizza",10000,true,"2017-12-17","maincourse",true),
(103,"Fries",10000,true,"2017-12-17","starter",true),
(104,"Brownies",10000,true,"2017-12-17","starter",true);
