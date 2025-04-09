INSERT INTO baza.Person (id, email, name, surname) VALUES (1, 'martin@krpan.si', 'Martin', 'Krpan');
INSERT INTO baza.Person (id, email, name, surname) VALUES (2, 'martin@krpan.si', 'Martin', 'Krpan');

INSERT INTO baza.Contact (id, title, type) VALUES (1, '051 051 051', 'telefon');
INSERT INTO baza.Contact (id, title, type) VALUES (2, 'email', 'email');
INSERT INTO baza.Contact (id, title, type) VALUES (3, '051 051 051', 'telefon');
INSERT INTO baza.Contact (id, title, type) VALUES (4, 'email', 'email');

INSERT INTO baza.Person_Contact (Person_id, contacts_id) VALUES (1, 1);
INSERT INTO baza.Person_Contact (Person_id, contacts_id) VALUES (1, 2);
INSERT INTO baza.Person_Contact (Person_id, contacts_id) VALUES (2, 3);
INSERT INTO baza.Person_Contact (Person_id, contacts_id) VALUES (2, 4);
