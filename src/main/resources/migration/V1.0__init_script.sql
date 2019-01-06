CREATE TABLE public.user_accounts
(
  id                         bigserial PRIMARY KEY         NOT NULL,
  creation_time              timestamp without time zone   NOT NULL,
  email                      character varying(100) UNIQUE NOT NULL,
  first_name                 character varying(100)        NOT NULL,
  last_name                  character varying(100)        NOT NULL,
  modification_time          timestamp without time zone   NOT NULL,
  password                   character varying(255),
  role                       character varying(20)         NOT NULL,
  sign_in_provider           character varying(20),
  version                    bigint                        NOT NULL
);





