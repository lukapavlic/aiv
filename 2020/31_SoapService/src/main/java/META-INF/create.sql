DROP TABLE IF EXISTS Oseba;
DROP TABLE IF EXISTS Posta;

create table Oseba (id  serial not null, datumVpisa timestamp, email varchar(255), ime varchar(255), priimek varchar(255), bivalisce_koda varchar(255), primary key (id))
create table Posta (koda varchar(255) not null, naziv varchar(255), primary key (koda))

alter table if exists Oseba add constraint FK87o4bp1alvda2c0gijgq7elgm foreign key (bivalisce_koda) references Posta