-- create table OnHold (id int not null primary key auto_increment,userId int not null,flightId int not null, foreign key (userId) references users(id), foreign key (flightId) references flight(id));
-- create table UserHistory (id int not null primary key, onHoldId int not null, isBought boolean default false, foreign key (onHoldId) references onhold(id));
-- create table notification (id int not null primary key, userId int not null, notifType varchar(255), notifTo varchar(255), foreign key (userId) references users(id));
-- create table Flight (id int not null primary key AUTO_INCREMENT, flightName varchar(255), flightTime timestamp, totalSeat int, availableSeat int);
-- create table users (id int not null primary key auto_increment, username varchar(255), pass varchar(255), email varchar(255), createdAt timestamp default current_timestamp, updatedAt timestamp default current_timestamp);

-- alter table airlines.users add email varchar(255) not null default "Not set";
-- insert into airlines.flight (flightName, flightTime, totalSeat, availableSeat) values ("TEST1", "2024-09-05", 100, 50);
-- alter table airlines.flight add destination varchar(255) not null default "Not set";
