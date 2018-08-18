insert into pilgerdb.account (username, password) values ('Admin1', 'secret1');
insert into pilgerdb.account (username, password) values ('Admin2', 'secret2');
insert into pilgerdb.account (username, password) values ('Admin3', 'secret3');
insert into pilgerdb.account (username, password) values ('Admin4', 'secret4');

insert into pilgerdb.elytronrole (id, rolename) values (1,  'System');
insert into pilgerdb.elytronrole (id, rolename) values (2,  'PowerUser');
insert into pilgerdb.elytronrole (id, rolename) values (3,  'Administrator');
insert into pilgerdb.elytronrole (id, rolename) values (4,  'Users');

insert into pilgerdb.elytronuser (username, elytron_role_id, comment, defaultLanguage, defaultTheme ) values ('N-U-T', 3, 'New-User-Template', 'english', 'Default');
insert into pilgerdb.elytronuser (username, elytron_role_id) values ('Admin1', 1);
insert into pilgerdb.elytronuser (username, elytron_role_id) values ('Admin2', 2);

insert into pilgerdb.person (firstname, lastname) values ('Hans-Georg', 'Glöckler1');
insert into pilgerdb.person (firstname, lastname) values ('Alfred', 'Lautwein');
insert into pilgerdb.person (firstname, lastname) values ('Viktor', 'Kessler');
insert into pilgerdb.person (firstname, lastname) values ('Markus', 'Kächele');

insert into pilgerdb.address (postbox, street, zip, city, person_id) values ('111', 'Strasse 01', '11111', 'Ulm 01', 1);
insert into pilgerdb.address (postbox, street, zip, city, person_id) values ('222', 'Strasse 02', '22222', 'Ulm 02', 1);
insert into pilgerdb.address (postbox, street, zip, city, person_id) values ('333', 'Strasse 03', '33333', 'Ulm 03', 2);
insert into pilgerdb.address (postbox, street, zip, city, person_id) values ('444', 'Strasse 04', '44444', 'Ulm 04', 2);

insert into pilgerdb.communicationtype (listPrio, communicationType) values (1, 'Telefon');
insert into pilgerdb.communicationtype (listPrio, communicationType) values (2, 'Mobil');
insert into pilgerdb.communicationtype (listPrio, communicationType) values (3, 'Fax');
insert into pilgerdb.communicationtype (listPrio, communicationType) values (4, 'Email');

insert into pilgerdb.kind (listPrio, kind) values (1, 'Privat');
insert into pilgerdb.kind (listPrio, kind) values (2, 'Geschäftlich');

insert into pilgerdb.communication (communication, COMMUNICATIONTYPE_ID, KIND_ID, person_id) values ('h.g.gloeckler@gmx.de', 4, 1, 1);
insert into pilgerdb.communication (communication, COMMUNICATIONTYPE_ID, KIND_ID, person_id) values ('viktor@gmx.de', 4, 1, 2);

insert into pilgerdb.title (listprio, title) values (0, 'Prof.');
insert into pilgerdb.title (listprio, title) values (1, 'PD');
insert into pilgerdb.title (listprio, title) values (2, 'Dr.');
insert into pilgerdb.title (listprio, title) values (3, 'Graf von');
insert into pilgerdb.title (listprio, title) values (4, 'Freiherr von');

insert into pilgerdb.settings(defaultLanguage, defaultTheme, defaultWindowWidth) values ('english', 'Default', '1200px');

