CREATE table users (
    id bigserial  PRIMARY KEY ,
    name varchar(100) NOT NULL,
    password varchar(80)
);

CREATE table roles (
    id serial PRIMARY KEY NOT NULL,
    name varchar(100) NOT NULL
);

create table users_roles (
    user_id bigint REFERENCES users ("id") ON UPDATE RESTRICT ON DELETE RESTRICT,
    role_id int REFERENCES roles ("id") ON UPDATE RESTRICT ON DELETE RESTRICT,
    CONSTRAINT user_roles_pk PRIMARY KEY (user_id, role_id)
);

insert into users VALUES  (2, 'user', '$2a$12$Zqs39GdGQnSdFSIAsmIWteEDROyg8IfCNS8USQbJPTKScZOLjEbaG');

insert into roles VALUES (1, 'ROLE_USER');
insert into roles VALUES (2, 'ROLE_ADMIN');

insert into users_roles VALUES (1, 2);
