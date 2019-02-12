CREATE TABLE MyMessanger.user(
   id timeuuid ,
   externalId uuid,
   email text,
   firstName text,
   lastName text,
   role text,
   isAccountNonLocked boolean,
   isAccountNonExpired boolean,
   isCredentialsNonLocked boolean,
   isEnabled boolean,
   verificationCode int,
   creationTime timestamp ,
   modificationTime timestamp,
   version int,
   PRIMARY KEY (id, externalId, email,creationTime)
   );

CREATE TABLE MyMessanger.chat(
id timeuuid,
creationTime timestamp ,
modificationTime timestamp,
version int
chat_type text,
participant<text>,
description text,
primary key(id, chat_type, participant)
)
