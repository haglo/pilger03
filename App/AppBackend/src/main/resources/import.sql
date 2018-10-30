insert into pilgerdb.account (uuid, username, password) values (uuid(), 'Admin1', '$2a$10$Al3jAZHUr/uEBKER3D0MnO/gjJn3OtfOjWihKjyf8jNIsuPyYchcm');
insert into pilgerdb.account (uuid, username, password) values (uuid(), 'Admin2', '$2a$10$lL/TPkN701P4KsV3LeBUOO/kquf3O/euqM1.bS6XnF0V.TBadYaVK');
insert into pilgerdb.account (uuid, username, password) values (uuid(), 'Admin3', '$2a$10$.25Z2HJMNBBeADfKSJHqaOwCDBFNQMRyr9nGL//ZjCtq0AUu0dmNe');
insert into pilgerdb.account (uuid, username, password) values (uuid(), 'Admin4', '$2a$10$RGKIm3pG/dzL.yqeUy0iauEaQTRmARHMbSq9A8PrrJFK9AMJnug0y');

insert into pilgerdb.elytronrole (id, uuid, rolename) values (1,  uuid(), 'System');
insert into pilgerdb.elytronrole (id, uuid, rolename) values (2,  uuid(), 'Poweruser');
insert into pilgerdb.elytronrole (id, uuid, rolename) values (3,  uuid(), 'Administrator');
insert into pilgerdb.elytronrole (id, uuid, rolename) values (4,  uuid(), 'User');
insert into pilgerdb.elytronrole (id, uuid, rolename) values (5,  uuid(), 'Guest');

insert into pilgerdb.elytronuser (uuid, username, password, comment, defaultLanguage, defaultTheme, elytron_role_id) values (uuid(), 'N-U-T',  'secret01', 'New-User-Template',  'english', 'Default', 3);
insert into pilgerdb.elytronuser (uuid, username, password, comment, defaultLanguage, defaultTheme, elytron_role_id) values (uuid(), 'Admin1', 'secret01', 'First User', 'german', 'Default', 1);
insert into pilgerdb.elytronuser (uuid, username, password, comment, defaultLanguage, defaultTheme, elytron_role_id) values (uuid(), 'Admin2', 'secret01', 'Second User', 'english', 'Medjugorje', 3);

insert into pilgerdb.person (uuid, firstname, lastname) values (uuid(), 'Hans-Georg', 'Glöckler1');
insert into pilgerdb.person (uuid, firstname, lastname) values (uuid(), 'Alfred', 'Lautwein');
insert into pilgerdb.person (uuid, firstname, lastname) values (uuid(), 'Viktor', 'Kessler');
insert into pilgerdb.person (uuid, firstname, lastname) values (uuid(), 'Markus', 'Kächele');

insert into pilgerdb.address (uuid, postbox, street, zip, city, person_id) values (uuid(), '111', 'Strasse 01', '11111', 'Ulm 01', 1);
insert into pilgerdb.address (uuid, postbox, street, zip, city, person_id) values (uuid(), '222', 'Strasse 02', '22222', 'Ulm 02', 1);
insert into pilgerdb.address (uuid, postbox, street, zip, city, person_id) values (uuid(), '333', 'Strasse 03', '33333', 'Ulm 03', 2);
insert into pilgerdb.address (uuid, postbox, street, zip, city, person_id) values (uuid(), '444', 'Strasse 04', '44444', 'Ulm 04', 2);

insert into pilgerdb.communicationtype (uuid, listPrio, communicationType) values (uuid(), 1, 'Telefon');
insert into pilgerdb.communicationtype (uuid, listPrio, communicationType) values (uuid(), 2, 'Mobil');
insert into pilgerdb.communicationtype (uuid, listPrio, communicationType) values (uuid(), 3, 'Fax');
insert into pilgerdb.communicationtype (uuid, listPrio, communicationType) values (uuid(), 4, 'Email');

insert into pilgerdb.kind (uuid, listPrio, kind) values (uuid(), 1, 'Privat');
insert into pilgerdb.kind (uuid, listPrio, kind) values (uuid(), 2, 'Geschäftlich');

insert into pilgerdb.communication (uuid, communication, COMMUNICATIONTYPE_ID, KIND_ID, person_id) values (uuid(), 'h.g.gloeckler@gmx.de', 4, 1, 1);
insert into pilgerdb.communication (uuid, communication, COMMUNICATIONTYPE_ID, KIND_ID, person_id) values (uuid(), 'viktor@gmx.de', 4, 1, 2);

insert into pilgerdb.title (uuid, listprio, title) values (uuid(), 0, 'Prof.');
insert into pilgerdb.title (uuid, listprio, title) values (uuid(), 1, 'PD');
insert into pilgerdb.title (uuid, listprio, title) values (uuid(), 2, 'Dr.');
insert into pilgerdb.title (uuid, listprio, title) values (uuid(), 3, 'Graf von');
insert into pilgerdb.title (uuid, listprio, title) values (uuid(), 4, 'Freiherr von');

insert into pilgerdb.settings(uuid, defaultWindowWidth) values (uuid(), '1200px');

