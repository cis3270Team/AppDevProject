use mysql;

create user 'cis3270'@'localhost' identified by 'project';

create database projectdb;

grant all on projectdb.* to 'cis3270'@'localhost';

use projectdb;

create table User (
  username varchar(30),
  password varchar(30),
  userType varchar(10),
  firstName varchar(30),
  lastName varchar(30),
  address varchar(100),
  city varchar(30),
  state varchar(30),
  zipCode varchar(5),
  email varchar(50),
  ssn char(9),
  securityQuestion varchar(100),
  secutityAnswer varchar(50),
  primary key (username,password)
);

create table Bus (
  busNumber integer,
  departureCity varchar(30),
  departureDate varchar(40),
  destinationCity varchar(30),
  capacity integer,
  passengerCount integer,
  primary key (busNumber)
);

create table Reservation (
  reservationNumber integer,
  dateCreated varchar(30),
  username varchar(30),
  busNumber integer,
  departureDate varchar(30),
  ticketNumber integer,
  primary key (reservationNumber),
  foreign key (username) references User(username),
  foreign key (busNumber) references Bus(busNumber)
);

create table State(
  stateCode char(2),
  stateName varchar(30),
  primary key (stateCode)
);

create table Zip(
  zipCode integer,
  city varchar(30),
  stateCode char(2),
  primary key (zipCode),
  foreign key (stateCode) references State(stateCode)
);


create table ReservationCount(resCount integer);


