CREATE TABLE users
(
  users_id serial NOT NULL,
  users_nachname character varying NOT NULL,
  users_vorname character varying NOT NULL,
  users_geburtstag character varying NOT NULL,
  users_konfession character varying NOT NULL,
  users_klasse character varying,
  users_username character varying NOT NULL,
  users_passwort character varying NOT NULL,
  users_rolle character varying,
  CONSTRAINT users_pkey PRIMARY KEY (users_id),
  CONSTRAINT users_users_username_key UNIQUE (users_username)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE users
  OWNER TO ijcy;
