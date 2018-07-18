DROP TABLE IF EXISTS public.test_user;

CREATE TABLE public.test_user
(
  user_id serial PRIMARY KEY, 
  user_name character varying(100) NOT NULL,
  user_phone character varying(100) NOT NULL  
);

INSERT INTO public.test_user (user_name, user_phone) VALUES
	('Mike',  '222-22-22'),
	('Tim',   '333-33-33'),
	('Bob',   '444-44-44'),
	('Kity',  '555-55-55');
