CREATE TABLE movie(

id serial PRIMARY KEY,
title varchar(255) NOT NULL,
descripion text,
release_date date,
rating numeric,
created_at timestamp,
update_at timestamp



)