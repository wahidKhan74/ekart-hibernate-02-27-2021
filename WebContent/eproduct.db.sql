use ekartdb;

create table eproduct ( id bigint primary key auto_increment, name varchar(100),  price bigint,createdAt timestamp default now(), modifiedAt timestamp default now() );