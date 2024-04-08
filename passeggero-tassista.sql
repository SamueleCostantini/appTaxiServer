create table taxi
(
    targataxi varchar(6) not null
        primary key
);

alter table taxi
    owner to postgres;

create table tassista
(
    role      boolean,
    idutente  integer not null
        primary key,
    email     varchar(20),
    nome      varchar(20),
    password  varchar(20),
    surname   varchar(20),
    targataxi varchar(6)
        references taxi
);

alter table tassista
    owner to postgres;

create table passeggero
(
    role     boolean,
    idutente integer not null
        primary key,
    email    varchar(20),
    nome     varchar(20),
    password varchar(20),
    surname  varchar(20)
);

alter table passeggero
    owner to postgres;





