create table site
(
    id    serial primary key,
    url   varchar unique not null
);

create table site_login
(
    id_site int primary key references site(id),
    login        varchar unique,
    password     varchar
);

create table site_generate(
    id serial primary key,
    url varchar not null unique,
    code varchar not null unique,
    total bigint default 0,
    id_site int references site(id)
);