create database Gym;
use Gym;
drop table if exists Users;
drop table if exists Exercises;
drop table if exists Subscription;
drop table if exists Pricing;
drop table if exists Program;
drop table if exists Complex;
drop table Users;
create table Users (
                       UserID int auto_increment primary key,
                       Login nvarchar(50) not null,
                       Password char(64) not null,
                       Role enum('ADMIN', 'COACH', 'CLIENT') not null,
                       Firstname nvarchar(50) not null,
                       Lastname nvarchar(50) not null,
                       Telephone nvarchar(50) not null,
                       Photo mediumblob);


insert into Users values
/*Admin007*/
(1, 'pomazafa', '2178a4d04eeeb4f32142812d2bb1fcb6cd556ac7', 'ADMIN', 'Duben', 'Polina','375336340558',null),
/*Coach1999*/
(2,'lesya', '1f9e03a7e14322e674bf511268660dd1469eb573','COACH','Glushakova','Alesya','375440498762',null),
/*A123*/
(3,'mmf2018','49049515566fa38e1b8e268723a3730dcf527f36','CLIENT','Goncharov','Alexandr','375290876765',null),
/*A1234*/
(4,'alesya', '49049515566fa38e1b8e268723a3730dcf527f36','CLIENT','hlushakova','alesia','375294987609',null),
(6,'coach2', '1f9e03a7e14322e674bf511268660dd1469eb573','COACH','sazonov','yauhen','375294007609',null),
(7,'coach3', '1f9e03a7e14322e674bf511268660dd1469eb573','COACH','popovich','sasha','375294980139',null);
use gym;
select Photo from Users where UserID=4;
update Users set Password='49049515566fa38e1b8e268723a3730dcf527f36' where UserID=3;

create table Exercises (
                           ExerciseID int auto_increment primary key,
                           Name nvarchar(50) not null,
                           Restrictions nvarchar(255),
                           CaloriesLost int,
                           FitnessLevel enum('STARTER', 'CASUAL', 'EXPERT') not null,
                           Description text not null);
use Gym;
insert into Exercises values
(1,'running', 'bones problems', 350,'PRO','Running will elongate your stamina'),
(3, 'pressups', 'heart deseases', 400, 'STARTER', 'Press ups wil improve your stomach muscles'),
(2, 'push ups', 'heart dystony', 200,'CASUAL','Push ups improve muscles and male you fit'),
(4,'cycling', 'heart and lung deseases', 200,'CASUAL','This exercise will improve your feet.') ;
use gym;
select * from Exercises;


create table Subscription (
                              SubscriptionID int auto_increment primary key,
                              ClientID int default '0',
                              PurchaseDate date not null,
                              ExpirationDate date not null,
                              Trial enum('WEEK','MONTH','YEAR'),
                              Price decimal not null,
                              IBM int,
                              IsCoachNeeded tinyint(4) default null,
                              IsPayed tinyint not null default '0',
                              Feedback text,
                              constraint ClientID_fk foreign key (ClientID) references Users
                                  (UserID) on delete set null);



insert into Subscription values
(1,3,'2019-07-15', '2019-07-22','WEEK', 80, 20, 1,1,'I am glad to find that amazing place'),
(2,4,'2019-07-27', '2019-08-26','MONTH', 220, 22, 1,1,null);

select * from Subscription;
create table Pricing (
                         SubscriptionType enum('WEEK+COACH', 'WEEK', 'MONTH+COACH',
                             'MONTH', 'YEAR','YEAR+COACH') primary key,
                         Price decimal not null
);

insert into Pricing values
('WEEK', 80),
('WEEK+COACH',120),
('MONTH+COACH',220),
('MONTH', 160),
('YEAR', 300),
('YEAR+COACH', 500);

create table Program (
                         ProgramID int auto_increment primary key,
                         CoachID int not null,
                         ClientID int,
                         StartDate date not null,
                         EndDate date not null,
                         Diet text not null,
                         constraint client_fk foreign key (ClientID) references Users (UserID),
                         constraint coach_fk foreign key (CoachID) references Users (UserID)
);
use gym;
insert into Program values
(2,6,3,'2019-06-02','2019-07-30','Be sure to eat before exercise (2 hours before it starts). Protein dishes and foods containing slow carbohydrates are well suited for this: cereals, flour, vegetables, etc. Carbohydrates before exercise are needed in order to load glycogen depots and provide muscles and brain with energy during training. Amino acids allow you to run anabolism. \ R \ n \ r \ nFood after exercise. The greatest need for nutrients is observed soon after training. It is best to use a carbohydrate-protein shake (gainer) immediately after the end of the training, then a heavy meal should follow no later than 1–1.5 hours after training. [3] Include foods rich in proteins and slow carbohydrates, you can eat even a small amount of fast carbohydrates (sweet). After the training, the so-called protein-carbohydrate window opens, during this time the body is positioned to assimilate a large amount of food, while the nutrients are used to restore muscles and replenish energy.'),
(3,7,4,'2019-06-02','2019-07-28','Regularly track the percentage of body fat. According to a 2015 study on 58 pairs of twins, active formation of visceral fat that is dangerous to health occurs in men when 20.6% of the total body fat is reached, and in women upon reaching 39.4%. Therefore, with the accumulation of 15-20% of fat in men, it is necessary to stop weight gain and switch to a diet for relief with a gradual decrease in the level of fat to 10%, and then you can start a new weight gain cycle. \ r \ n');


create table Complex (
                         ProgramID int not null,
                         ExerciseID int not null,
                         Days int not null,
                         WeightLoss int not null,
                         Sets int not null default '0',
                         Repeats int default '1',
                         primary key (ProgramID, ExerciseID, Days),
                         constraint complex_exercise_fk foreign key (ExerciseID)
                             references Exercises (ExerciseID),
                         constraint complex_program_fk foreign key (ProgramID)
                             references Program (ProgramID)
);

insert into Complex values

(2,2,1,1,1,1),
(2,2,2,1,1,1),
(2,2,3,1,1,1),
(2,3,1,4,10,2),
(2,4,2,10,10,2),
(2,1,1,10,10,3),
(2,2,4,10,10,3),
(2,3,2,10,10,3),
(2,4,3,10,10,2),
(3,1,1,1,1,1),
(3,1,2,2,2,1),
(3,2,1,1,1,2),
(3,3,2,11,11,3),
(3,4,1,10,10,3),
(3,3,4,10,10,2);







create database Gym;
use Gym;
drop table if exists Users;
drop table if exists Exercises;
drop table if exists Subscription;
drop table if exists Pricing;
drop table if exists Program;
drop table if exists Complex;
drop table Users;
create table Users (
                       UserID int auto_increment primary key,
                       Login nvarchar(50) not null,
                       Password char(64) not null,
                       Role enum('ADMIN', 'COACH', 'CLIENT') not null,
                       Firstname nvarchar(50) not null,
                       Lastname nvarchar(50) not null,
                       Telephone nvarchar(50) not null,
                       Photo mediumblob);


insert into Users values
/*Admin007*/
(1, 'pomazafa', '2178a4d04eeeb4f32142812d2bb1fcb6cd556ac7', 'ADMIN', 'Duben', 'Polina','375336340558',null),
/*Coach1999*/
(2,'lesya', '1f9e03a7e14322e674bf511268660dd1469eb573','COACH','Glushakova','Alesya','375440498762',null),
/*A123*/
(3,'mmf2018','49049515566fa38e1b8e268723a3730dcf527f36','CLIENT','Goncharov','Alexandr','375290876765',null),
/*A1234*/
(4,'alesya', '49049515566fa38e1b8e268723a3730dcf527f36','CLIENT','hlushakova','alesia','375294987609',null),
(6,'coach2', '1f9e03a7e14322e674bf511268660dd1469eb573','COACH','sazonov','yauhen','375294007609',null),
(7,'coach3', '1f9e03a7e14322e674bf511268660dd1469eb573','COACH','popovich','sasha','375294980139',null);
use gym;
select Photo from Users where UserID=4;
update Users set Password='49049515566fa38e1b8e268723a3730dcf527f36' where UserID=3;

create table Exercises (
                           ExerciseID int auto_increment primary key,
                           Name nvarchar(50) not null,
                           Restrictions nvarchar(255),
                           CaloriesLost int,
                           FitnessLevel enum('STARTER', 'CASUAL', 'EXPERT') not null,
                           Description text not null);
use Gym;
insert into Exercises values
(1,'running', 'bones problems', 350,'PRO','Running will elongate your stamina'),
(3, 'pressups', 'heart deseases', 400, 'STARTER', 'Press ups wil improve your stomach muscles'),
(2, 'push ups', 'heart dystony', 200,'CASUAL','Push ups improve muscles and male you fit'),
(4,'cycling', 'heart and lung deseases', 200,'CASUAL','This exercise will improve your feet.') ;
use gym;
select * from Exercises;


create table Subscription (
                              SubscriptionID int auto_increment primary key,
                              ClientID int default '0',
                              PurchaseDate date not null,
                              ExpirationDate date not null,
                              Trial enum('WEEK','MONTH','YEAR'),
                              Price decimal not null,
                              IBM int,
                              IsCoachNeeded tinyint(4) default null,
                              IsPayed tinyint not null default '0',
                              Feedback text,
                              constraint ClientID_fk foreign key (ClientID) references Users
                                  (UserID) on delete set null);



insert into Subscription values
(1,3,'2019-07-15', '2019-07-22','WEEK', 80, 20, 1,1,'I am glad to find that amazing place'),
(2,4,'2019-07-27', '2019-08-26','MONTH', 220, 22, 1,1,null);

select * from Subscription;
create table Pricing (
                         SubscriptionType enum('WEEK+COACH', 'WEEK', 'MONTH+COACH',
                             'MONTH', 'YEAR','YEAR+COACH') primary key,
                         Price decimal not null
);

insert into Pricing values
('WEEK', 80),
('WEEK+COACH',120),
('MONTH+COACH',220),
('MONTH', 160),
('YEAR', 300),
('YEAR+COACH', 500);

create table Program (
                         ProgramID int auto_increment primary key,
                         CoachID int not null,
                         ClientID int,
                         StartDate date not null,
                         EndDate date not null,
                         Diet text not null,
                         constraint client_fk foreign key (ClientID) references Users (UserID),
                         constraint coach_fk foreign key (CoachID) references Users (UserID)
);
use gym;
insert into Program values
(2,6,3,'2019-06-02','2019-07-30','Be sure to eat before exercise (2 hours before it starts). Protein dishes and foods containing slow carbohydrates are well suited for this: cereals, flour, vegetables, etc. Carbohydrates before exercise are needed in order to load glycogen depots and provide muscles and brain with energy during training. Amino acids allow you to run anabolism. \ R \ n \ r \ nFood after exercise. The greatest need for nutrients is observed soon after training. It is best to use a carbohydrate-protein shake (gainer) immediately after the end of the training, then a heavy meal should follow no later than 1–1.5 hours after training. [3] Include foods rich in proteins and slow carbohydrates, you can eat even a small amount of fast carbohydrates (sweet). After the training, the so-called protein-carbohydrate window opens, during this time the body is positioned to assimilate a large amount of food, while the nutrients are used to restore muscles and replenish energy.'),
(3,7,4,'2019-06-02','2019-07-28','Regularly track the percentage of body fat. According to a 2015 study on 58 pairs of twins, active formation of visceral fat that is dangerous to health occurs in men when 20.6% of the total body fat is reached, and in women upon reaching 39.4%. Therefore, with the accumulation of 15-20% of fat in men, it is necessary to stop weight gain and switch to a diet for relief with a gradual decrease in the level of fat to 10%, and then you can start a new weight gain cycle. \ r \ n');


create table Complex (
                         ProgramID int not null,
                         ExerciseID int not null,
                         Days int not null,
                         WeightLoss int not null,
                         Sets int not null default '0',
                         Repeats int default '1',
                         primary key (ProgramID, ExerciseID, Days),
                         constraint complex_exercise_fk foreign key (ExerciseID)
                             references Exercises (ExerciseID),
                         constraint complex_program_fk foreign key (ProgramID)
                             references Program (ProgramID)
);

insert into Complex values

(2,2,1,1,1,1),
(2,2,2,1,1,1),
(2,2,3,1,1,1),
(2,3,1,4,10,2),
(2,4,2,10,10,2),
(2,1,1,10,10,3),
(2,2,4,10,10,3),
(2,3,2,10,10,3),
(2,4,3,10,10,2),
(3,1,1,1,1,1),
(3,1,2,2,2,1),
(3,2,1,1,1,2),
(3,3,2,11,11,3),
(3,4,1,10,10,3),
(3,3,4,10,10,2);







create database Gym;
use Gym;
drop table if exists Users;
drop table if exists Exercises;
drop table if exists Subscription;
drop table if exists Pricing;
drop table if exists Program;
drop table if exists Complex;
drop table Users;
create table Users (
                       UserID int auto_increment primary key,
                       Login nvarchar(50) not null,
                       Password char(64) not null,
                       Role enum('ADMIN', 'COACH', 'CLIENT') not null,
                       Firstname nvarchar(50) not null,
                       Lastname nvarchar(50) not null,
                       Telephone nvarchar(50) not null,
                       Photo mediumblob);


insert into Users values
/*Admin007*/
(1, 'pomazafa', '2178a4d04eeeb4f32142812d2bb1fcb6cd556ac7', 'ADMIN', 'Duben', 'Polina','375336340558',null),
/*Coach1999*/
(2,'lesya', '1f9e03a7e14322e674bf511268660dd1469eb573','COACH','Glushakova','Alesya','375440498762',null),
/*A123*/
(3,'mmf2018','49049515566fa38e1b8e268723a3730dcf527f36','CLIENT','Goncharov','Alexandr','375290876765',null),
/*A1234*/
(4,'alesya', '49049515566fa38e1b8e268723a3730dcf527f36','CLIENT','hlushakova','alesia','375294987609',null),
(6,'coach2', '1f9e03a7e14322e674bf511268660dd1469eb573','COACH','sazonov','yauhen','375294007609',null),
(7,'coach3', '1f9e03a7e14322e674bf511268660dd1469eb573','COACH','popovich','sasha','375294980139',null);
use gym;
select Photo from Users where UserID=4;
update Users set Password='49049515566fa38e1b8e268723a3730dcf527f36' where UserID=3;

create table Exercises (
                           ExerciseID int auto_increment primary key,
                           Name nvarchar(50) not null,
                           Restrictions nvarchar(255),
                           CaloriesLost int,
                           FitnessLevel enum('STARTER', 'CASUAL', 'EXPERT') not null,
                           Description text not null);
use Gym;
insert into Exercises values
(1,'running', 'bones problems', 350,'PRO','Running will elongate your stamina'),
(3, 'pressups', 'heart deseases', 400, 'STARTER', 'Press ups wil improve your stomach muscles'),
(2, 'push ups', 'heart dystony', 200,'CASUAL','Push ups improve muscles and male you fit'),
(4,'cycling', 'heart and lung deseases', 200,'CASUAL','This exercise will improve your feet.') ;
use gym;
select * from Exercises;


create table Subscription (
                              SubscriptionID int auto_increment primary key,
                              ClientID int default '0',
                              PurchaseDate date not null,
                              ExpirationDate date not null,
                              Trial enum('WEEK','MONTH','YEAR'),
                              Price decimal not null,
                              IBM int,
                              IsCoachNeeded tinyint(4) default null,
                              IsPayed tinyint not null default '0',
                              Feedback text,
                              constraint ClientID_fk foreign key (ClientID) references Users
                                  (UserID) on delete set null);



insert into Subscription values
(1,3,'2019-07-15', '2019-07-22','WEEK', 80, 20, 1,1,'I am glad to find that amazing place'),
(2,4,'2019-07-27', '2019-08-26','MONTH', 220, 22, 1,1,null);

select * from Subscription;
create table Pricing (
                         SubscriptionType enum('WEEK+COACH', 'WEEK', 'MONTH+COACH',
                             'MONTH', 'YEAR','YEAR+COACH') primary key,
                         Price decimal not null
);

insert into Pricing values
('WEEK', 80),
('WEEK+COACH',120),
('MONTH+COACH',220),
('MONTH', 160),
('YEAR', 300),
('YEAR+COACH', 500);

create table Program (
                         ProgramID int auto_increment primary key,
                         CoachID int not null,
                         ClientID int,
                         StartDate date not null,
                         EndDate date not null,
                         Diet text not null,
                         constraint client_fk foreign key (ClientID) references Users (UserID),
                         constraint coach_fk foreign key (CoachID) references Users (UserID)
);
use gym;
insert into Program values
(2,6,3,'2019-06-02','2019-07-30','Be sure to eat before exercise (2 hours before it starts). Protein dishes and foods containing slow carbohydrates are well suited for this: cereals, flour, vegetables, etc. Carbohydrates before exercise are needed in order to load glycogen depots and provide muscles and brain with energy during training. Amino acids allow you to run anabolism. \ R \ n \ r \ nFood after exercise. The greatest need for nutrients is observed soon after training. It is best to use a carbohydrate-protein shake (gainer) immediately after the end of the training, then a heavy meal should follow no later than 1–1.5 hours after training. [3] Include foods rich in proteins and slow carbohydrates, you can eat even a small amount of fast carbohydrates (sweet). After the training, the so-called protein-carbohydrate window opens, during this time the body is positioned to assimilate a large amount of food, while the nutrients are used to restore muscles and replenish energy.'),
(3,7,4,'2019-06-02','2019-07-28','Regularly track the percentage of body fat. According to a 2015 study on 58 pairs of twins, active formation of visceral fat that is dangerous to health occurs in men when 20.6% of the total body fat is reached, and in women upon reaching 39.4%. Therefore, with the accumulation of 15-20% of fat in men, it is necessary to stop weight gain and switch to a diet for relief with a gradual decrease in the level of fat to 10%, and then you can start a new weight gain cycle. \ r \ n');


create table Complex (
                         ProgramID int not null,
                         ExerciseID int not null,
                         Days int not null,
                         WeightLoss int not null,
                         Sets int not null default '0',
                         Repeats int default '1',
                         primary key (ProgramID, ExerciseID, Days),
                         constraint complex_exercise_fk foreign key (ExerciseID)
                             references Exercises (ExerciseID),
                         constraint complex_program_fk foreign key (ProgramID)
                             references Program (ProgramID)
);

insert into Complex values

(2,2,1,1,1,1),
(2,2,2,1,1,1),
(2,2,3,1,1,1),
(2,3,1,4,10,2),
(2,4,2,10,10,2),
(2,1,1,10,10,3),
(2,2,4,10,10,3),
(2,3,2,10,10,3),
(2,4,3,10,10,2),
(3,1,1,1,1,1),
(3,1,2,2,2,1),
(3,2,1,1,1,2),
(3,3,2,11,11,3),
(3,4,1,10,10,3),
(3,3,4,10,10,2);







create database Gym;
use Gym;
drop table if exists Users;
drop table if exists Exercises;
drop table if exists Subscription;
drop table if exists Pricing;
drop table if exists Program;
drop table if exists Complex;
drop table Users;
create table Users (
                       UserID int auto_increment primary key,
                       Login nvarchar(50) not null,
                       Password char(64) not null,
                       Role enum('ADMIN', 'COACH', 'CLIENT') not null,
                       Firstname nvarchar(50) not null,
                       Lastname nvarchar(50) not null,
                       Telephone nvarchar(50) not null,
                       Photo mediumblob);


insert into Users values
/*Admin007*/
(1, 'pomazafa', '2178a4d04eeeb4f32142812d2bb1fcb6cd556ac7', 'ADMIN', 'Duben', 'Polina','375336340558',null),
/*Coach1999*/
(2,'lesya', '1f9e03a7e14322e674bf511268660dd1469eb573','COACH','Glushakova','Alesya','375440498762',null),
/*A123*/
(3,'mmf2018','49049515566fa38e1b8e268723a3730dcf527f36','CLIENT','Goncharov','Alexandr','375290876765',null),
/*A1234*/
(4,'alesya', '49049515566fa38e1b8e268723a3730dcf527f36','CLIENT','hlushakova','alesia','375294987609',null),
(6,'coach2', '1f9e03a7e14322e674bf511268660dd1469eb573','COACH','sazonov','yauhen','375294007609',null),
(7,'coach3', '1f9e03a7e14322e674bf511268660dd1469eb573','COACH','popovich','sasha','375294980139',null);
use gym;
select Photo from Users where UserID=4;
update Users set Password='49049515566fa38e1b8e268723a3730dcf527f36' where UserID=3;

create table Exercises (
                           ExerciseID int auto_increment primary key,
                           Name nvarchar(50) not null,
                           Restrictions nvarchar(255),
                           CaloriesLost int,
                           FitnessLevel enum('STARTER', 'CASUAL', 'EXPERT') not null,
                           Description text not null);
use Gym;
insert into Exercises values
(1,'running', 'bones problems', 350,'PRO','Running will elongate your stamina'),
(3, 'pressups', 'heart deseases', 400, 'STARTER', 'Press ups wil improve your stomach muscles'),
(2, 'push ups', 'heart dystony', 200,'CASUAL','Push ups improve muscles and male you fit'),
(4,'cycling', 'heart and lung deseases', 200,'CASUAL','This exercise will improve your feet.') ;
use gym;
select * from Exercises;


create table Subscription (
                              SubscriptionID int auto_increment primary key,
                              ClientID int default '0',
                              PurchaseDate date not null,
                              ExpirationDate date not null,
                              Trial enum('WEEK','MONTH','YEAR'),
                              Price decimal not null,
                              IBM int,
                              IsCoachNeeded tinyint(4) default null,
                              IsPayed tinyint not null default '0',
                              Feedback text,
                              constraint ClientID_fk foreign key (ClientID) references Users
                                  (UserID) on delete set null);



insert into Subscription values
(1,3,'2019-07-15', '2019-07-22','WEEK', 80, 20, 1,1,'I am glad to find that amazing place'),
(2,4,'2019-07-27', '2019-08-26','MONTH', 220, 22, 1,1,null);

select * from Subscription;
create table Pricing (
                         SubscriptionType enum('WEEK+COACH', 'WEEK', 'MONTH+COACH',
                             'MONTH', 'YEAR','YEAR+COACH') primary key,
                         Price decimal not null
);

insert into Pricing values
('WEEK', 80),
('WEEK+COACH',120),
('MONTH+COACH',220),
('MONTH', 160),
('YEAR', 300),
('YEAR+COACH', 500);

create table Program (
                         ProgramID int auto_increment primary key,
                         CoachID int not null,
                         ClientID int,
                         StartDate date not null,
                         EndDate date not null,
                         Diet text not null,
                         constraint client_fk foreign key (ClientID) references Users (UserID),
                         constraint coach_fk foreign key (CoachID) references Users (UserID)
);
use gym;
insert into Program values
(2,6,3,'2019-06-02','2019-07-30','Be sure to eat before exercise (2 hours before it starts). Protein dishes and foods containing slow carbohydrates are well suited for this: cereals, flour, vegetables, etc. Carbohydrates before exercise are needed in order to load glycogen depots and provide muscles and brain with energy during training. Amino acids allow you to run anabolism. \ R \ n \ r \ nFood after exercise. The greatest need for nutrients is observed soon after training. It is best to use a carbohydrate-protein shake (gainer) immediately after the end of the training, then a heavy meal should follow no later than 1–1.5 hours after training. [3] Include foods rich in proteins and slow carbohydrates, you can eat even a small amount of fast carbohydrates (sweet). After the training, the so-called protein-carbohydrate window opens, during this time the body is positioned to assimilate a large amount of food, while the nutrients are used to restore muscles and replenish energy.'),
(3,7,4,'2019-06-02','2019-07-28','Regularly track the percentage of body fat. According to a 2015 study on 58 pairs of twins, active formation of visceral fat that is dangerous to health occurs in men when 20.6% of the total body fat is reached, and in women upon reaching 39.4%. Therefore, with the accumulation of 15-20% of fat in men, it is necessary to stop weight gain and switch to a diet for relief with a gradual decrease in the level of fat to 10%, and then you can start a new weight gain cycle. \ r \ n');


create table Complex (
                         ProgramID int not null,
                         ExerciseID int not null,
                         Days int not null,
                         WeightLoss int not null,
                         Sets int not null default '0',
                         Repeats int default '1',
                         primary key (ProgramID, ExerciseID, Days),
                         constraint complex_exercise_fk foreign key (ExerciseID)
                             references Exercises (ExerciseID),
                         constraint complex_program_fk foreign key (ProgramID)
                             references Program (ProgramID)
);

insert into Complex values

(2,2,1,1,1,1),
(2,2,2,1,1,1),
(2,2,3,1,1,1),
(2,3,1,4,10,2),
(2,4,2,10,10,2),
(2,1,1,10,10,3),
(2,2,4,10,10,3),
(2,3,2,10,10,3),
(2,4,3,10,10,2),
(3,1,1,1,1,1),
(3,1,2,2,2,1),
(3,2,1,1,1,2),
(3,3,2,11,11,3),
(3,4,1,10,10,3),
(3,3,4,10,10,2);







create database Gym;
use Gym;
drop table if exists Users;
drop table if exists Exercises;
drop table if exists Subscription;
drop table if exists Pricing;
drop table if exists Program;
drop table if exists Complex;
drop table Users;
create table Users (
                       UserID int auto_increment primary key,
                       Login nvarchar(50) not null,
                       Password char(64) not null,
                       Role enum('ADMIN', 'COACH', 'CLIENT') not null,
                       Firstname nvarchar(50) not null,
                       Lastname nvarchar(50) not null,
                       Telephone nvarchar(50) not null,
                       Photo mediumblob);


insert into Users values
/*Admin007*/
(1, 'pomazafa', '2178a4d04eeeb4f32142812d2bb1fcb6cd556ac7', 'ADMIN', 'Duben', 'Polina','375336340558',null),
/*Coach1999*/
(2,'lesya', '1f9e03a7e14322e674bf511268660dd1469eb573','COACH','Glushakova','Alesya','375440498762',null),
/*A123*/
(3,'mmf2018','49049515566fa38e1b8e268723a3730dcf527f36','CLIENT','Goncharov','Alexandr','375290876765',null),
/*A1234*/
(4,'alesya', '49049515566fa38e1b8e268723a3730dcf527f36','CLIENT','hlushakova','alesia','375294987609',null),
(6,'coach2', '1f9e03a7e14322e674bf511268660dd1469eb573','COACH','sazonov','yauhen','375294007609',null),
(7,'coach3', '1f9e03a7e14322e674bf511268660dd1469eb573','COACH','popovich','sasha','375294980139',null);
use gym;
select Photo from Users where UserID=4;
update Users set Password='49049515566fa38e1b8e268723a3730dcf527f36' where UserID=3;

create table Exercises (
                           ExerciseID int auto_increment primary key,
                           Name nvarchar(50) not null,
                           Restrictions nvarchar(255),
                           CaloriesLost int,
                           FitnessLevel enum('STARTER', 'CASUAL', 'EXPERT') not null,
                           Description text not null);
use Gym;
insert into Exercises values
(1,'running', 'bones problems', 350,'PRO','Running will elongate your stamina'),
(3, 'pressups', 'heart deseases', 400, 'STARTER', 'Press ups wil improve your stomach muscles'),
(2, 'push ups', 'heart dystony', 200,'CASUAL','Push ups improve muscles and male you fit'),
(4,'cycling', 'heart and lung deseases', 200,'CASUAL','This exercise will improve your feet.') ;
use gym;
select * from Exercises;


create table Subscription (
                              SubscriptionID int auto_increment primary key,
                              ClientID int default '0',
                              PurchaseDate date not null,
                              ExpirationDate date not null,
                              Trial enum('WEEK','MONTH','YEAR'),
                              Price decimal not null,
                              IBM int,
                              IsCoachNeeded tinyint(4) default null,
                              IsPayed tinyint not null default '0',
                              Feedback text,
                              constraint ClientID_fk foreign key (ClientID) references Users
                                  (UserID) on delete set null);



insert into Subscription values
(1,3,'2019-07-15', '2019-07-22','WEEK', 80, 20, 1,1,'I am glad to find that amazing place'),
(2,4,'2019-07-27', '2019-08-26','MONTH', 220, 22, 1,1,null);

select * from Subscription;
create table Pricing (
                         SubscriptionType enum('WEEK+COACH', 'WEEK', 'MONTH+COACH',
                             'MONTH', 'YEAR','YEAR+COACH') primary key,
                         Price decimal not null
);

insert into Pricing values
('WEEK', 80),
('WEEK+COACH',120),
('MONTH+COACH',220),
('MONTH', 160),
('YEAR', 300),
('YEAR+COACH', 500);

create table Program (
                         ProgramID int auto_increment primary key,
                         CoachID int not null,
                         ClientID int,
                         StartDate date not null,
                         EndDate date not null,
                         Diet text not null,
                         constraint client_fk foreign key (ClientID) references Users (UserID),
                         constraint coach_fk foreign key (CoachID) references Users (UserID)
);
use gym;
insert into Program values
(2,6,3,'2019-06-02','2019-07-30','Be sure to eat before exercise (2 hours before it starts). Protein dishes and foods containing slow carbohydrates are well suited for this: cereals, flour, vegetables, etc. Carbohydrates before exercise are needed in order to load glycogen depots and provide muscles and brain with energy during training. Amino acids allow you to run anabolism. \ R \ n \ r \ nFood after exercise. The greatest need for nutrients is observed soon after training. It is best to use a carbohydrate-protein shake (gainer) immediately after the end of the training, then a heavy meal should follow no later than 1–1.5 hours after training. [3] Include foods rich in proteins and slow carbohydrates, you can eat even a small amount of fast carbohydrates (sweet). After the training, the so-called protein-carbohydrate window opens, during this time the body is positioned to assimilate a large amount of food, while the nutrients are used to restore muscles and replenish energy.'),
(3,7,4,'2019-06-02','2019-07-28','Regularly track the percentage of body fat. According to a 2015 study on 58 pairs of twins, active formation of visceral fat that is dangerous to health occurs in men when 20.6% of the total body fat is reached, and in women upon reaching 39.4%. Therefore, with the accumulation of 15-20% of fat in men, it is necessary to stop weight gain and switch to a diet for relief with a gradual decrease in the level of fat to 10%, and then you can start a new weight gain cycle. \ r \ n');


create table Complex (
                         ProgramID int not null,
                         ExerciseID int not null,
                         Days int not null,
                         WeightLoss int not null,
                         Sets int not null default '0',
                         Repeats int default '1',
                         primary key (ProgramID, ExerciseID, Days),
                         constraint complex_exercise_fk foreign key (ExerciseID)
                             references Exercises (ExerciseID),
                         constraint complex_program_fk foreign key (ProgramID)
                             references Program (ProgramID)
);

insert into Complex values

(2,2,1,1,1,1),
(2,2,2,1,1,1),
(2,2,3,1,1,1),
(2,3,1,4,10,2),
(2,4,2,10,10,2),
(2,1,1,10,10,3),
(2,2,4,10,10,3),
(2,3,2,10,10,3),
(2,4,3,10,10,2),
(3,1,1,1,1,1),
(3,1,2,2,2,1),
(3,2,1,1,1,2),
(3,3,2,11,11,3),
(3,4,1,10,10,3),
(3,3,4,10,10,2);







