INSERT INTO CATEGORY (id, name) VALUES (NEXTVAL('hibernate_sequence'), 'Monumentos');
INSERT INTO CATEGORY (id, name) VALUES (NEXTVAL('hibernate_sequence'), 'Bares');
INSERT INTO CATEGORY (id, name) VALUES (NEXTVAL('hibernate_sequence'), 'Restaurantes');
INSERT INTO CATEGORY (id, name) VALUES (NEXTVAL('hibernate_sequence'), 'Calles');
INSERT INTO CATEGORY (id, name) VALUES (NEXTVAL('hibernate_sequence'), 'Museos');

INSERT INTO ROUTE (id, name) VALUES (NEXTVAL('hibernate_sequence'), 'Ruta 1');


INSERT INTO POI (id, name, date, description, location, cover_photo, photo2, photo3, category_id) VALUES (NEXTVAL('hibernate_sequence'), 'Centro Cerámica Triana', '2018-02-27', 'El Centro Cerámica Triana es un museo creado en el año 2014 por el Ayuntamiento de Sevilla, con la colaboración de la Junta de Andalucía, para conservar y promocionar la tradición cerámica de la ciudad.', '37.385656, -6.004614', 'https://upload.wikimedia.org/wikipedia/commons/thumb/7/74/Museo_de_la_Cer%C3%A1mica_de_Triana_2.jpg/420px-Museo_de_la_Cer%C3%A1mica_de_Triana_2.jpg', null, null, 5);