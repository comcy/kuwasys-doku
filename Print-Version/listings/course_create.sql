CREATE TABLE course
(
  course_name character varying NOT NULL,
  course_kurslehrer integer,
  course_faecherverbund character varying NOT NULL,
  course_termin integer NOT NULL,
  course_beschreibung character varying,
  course_id serial NOT NULL,
  course_schuljahr integer,
  course_tertial integer,
  course_teilnehmerzahl integer,
  course_pflichtkurs boolean DEFAULT false,
  course_sport boolean,
  CONSTRAINT course_pkey PRIMARY KEY (course_id),
  CONSTRAINT course_course_kurslehrer_fkey FOREIGN KEY (course_kurslehrer)
      REFERENCES users (users_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE course
  OWNER TO ijcy;
