CREATE TABLE gradelist
(
  gradelist_id serial NOT NULL,
  gradelist_note real,
  gradelist_bemerkung character varying NOT NULL,
  gradelist_userid integer,
  gradelist_kursid integer,
  CONSTRAINT gradelist_pkey PRIMARY KEY (gradelist_id),
  CONSTRAINT gradelist_gradelist_kursid_fkey FOREIGN KEY (gradelist_kursid)
      REFERENCES course (course_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT gradelist_gradelist_userid_fkey FOREIGN KEY (gradelist_userid)
      REFERENCES users (users_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT noten CHECK (gradelist_note <= 6::double precision)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE gradelist
  OWNER TO ijcy;
