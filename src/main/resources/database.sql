CREATE table role (
    id BIGSERIAL PRIMARY KEY NOT NULL,
    name varchar(100) NOT NULL
);

create table user_role (
    user_id bigint REFERENCES "user" ("id") ON UPDATE RESTRICT ON DELETE RESTRICT,
    role_id bigint REFERENCES "role" ("id") ON UPDATE RESTRICT ON DELETE RESTRICT,
--     UNIQUE (user_id, role_id)
    CONSTRAINT user_roles_pk PRIMARY KEY (user_id, role_id)
);

insert into "user" VALUES  (1, 'user', 'MTIzNDU2', 'm@m.com');

insert into role VALUES (1, 'ROLE_USER');
insert into role VALUES (2, 'ROLE_ADMIN');

insert into user_role VALUES (1, 2);
