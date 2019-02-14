create database recruitmentplatform;

drop table recruitmentplatform.utente;
create table recruitmentplatform.utente(
id int(11) not null auto_increment,
username varchar(128),
password varchar(128),
nome varchar(128),
cognome varchar(128),
indirizzo varchar(128),
codice_fiscale varchar(128),
telefono varchar(128),
email varchar(128),
ruolo varchar(128),
valutazione varchar(128),
commenti varchar(128),
primary key (id)
);

insert into recruitmentplatform.utente(username,password,nome,cognome,indirizzo,codice_fiscale,telefono,email,ruolo) 
value ('nicola','123456','nicola','lombardi','via benevento','f43t3453','3334567894','nicola@gmail.com','gestore');
insert into recruitmentplatform.utente(username,password,nome,cognome,indirizzo,codice_fiscale,telefono,email,ruolo) 
value ('mario','123','mario','mario','via roma','jfhfhfhf','3336677555','marioa@gmail.com','recruiter'); 
insert into recruitmentplatform.utente(username,password,nome,cognome,indirizzo,codice_fiscale,telefono,email,ruolo,valutazione,commenti) 
value ('stefano','456','stefano','schettino','via napoli','hhfksfdsfs','3333456789','stefano@gmail.com','candidato','idoneo','ottima preparazione'); 
insert into recruitmentplatform.utente(username,password,nome,cognome,indirizzo,codice_fiscale,telefono,email,ruolo) 
value ('antonio','456','antonio','molina','via venezia','antfkm76gjgkff','3436675435','antonio@gmail.com','recruiter');
insert into recruitmentplatform.utente(username,password,nome,cognome,indirizzo,codice_fiscale,telefono,email,ruolo) 
value ('carmine','456','carmine','lapo','via milano','antfkm76gjtyrf','34965775435','carmine@gmail.com','recruiter');
insert into recruitmentplatform.utente(username,password,nome,cognome,indirizzo,codice_fiscale,telefono,email,ruolo,valutazione,commenti) 
value ('giovanni','456','giovanni','landi','via torino','gnniou67j67a689f','333594989','giovanni@gmail.com','candidato','non_idoneo','pessima preparazione'); 
drop table recruitmentplatform.annunci;
create table recruitmentplatform.annunci(
id int (11) not null auto_increment,
titolo varchar(128),
luogo varchar(128),
categoria varchar(128),
contratto varchar(128),
primary key (id)
);

insert into recruitmentplatform.annunci(titolo,luogo,categoria,contratto) 
value ('programmatore','milano','ht','stage');
insert into recruitmentplatform.annunci(titolo,luogo,categoria,contratto) 
value ('programmatore','roma','ht','stage');
insert into recruitmentplatform.annunci(titolo,luogo,categoria,contratto) 
value ('programmatore','genoa','ht','stage');

drop table recruitmentplatform.candidature;
create table recruitmentplatform.candidature(
ID_Annunci int,
ID_Candidati int,
foreign key (ID_Annunci) references annunci (id) ON DELETE CASCADE,
foreign key (ID_Candidati) references utente (id) ON DELETE CASCADE
);