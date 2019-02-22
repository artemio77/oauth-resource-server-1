CREATE KEYSPACE application
  WITH REPLICATION = {
  'class' : 'SimpleStrategy',
  'replication_factor' : 1
  };


CREATE TABLE application.user
(
  id                     timeuuid,
  email                  text,
  firstName              text,
  lastName               text,
  role                   text,
  isAccountNonLocked     boolean,
  isAccountNonExpired    boolean,
  isCredentialsNonLocked boolean,
  isEnabled              boolean,
  verificationCode       int,
  creationTime           timestamp,
  modificationTime       timestamp,
  version                int,
  PRIMARY KEY (id, email, creationTime)
);

CREATE TABLE application.chat
(
  id               timeuuid,
  creationTime     timestamp,
  modificationTime timestamp,
  version          int,
  chat_type        text,
  participant      frozen<list<uuid>>,
  description      text,
  primary key (id, chat_type, participant)
);
CREATE TABLE application.contact
(
  id               timeuuid,
  creationTime     timestamp,
  modificationTime timestamp,
  version          int,
  participant      frozen<list<uuid>>,
  approved         boolean,
  primary key (id, participant)
);
CREATE TABLE application.message
(
  id               timeuuid,
  creationTime     timestamp,
  modificationTime timestamp,
  version          int,
  message_type     text,
  chat             uuid,
  primary key (id)
);


