create table if not exists author
(
    id bigint not null
        constraint author_pkey
            primary key,
    description varchar(255),
    name varchar(255),
    surname varchar(255)
);

alter table author owner to postgres;

