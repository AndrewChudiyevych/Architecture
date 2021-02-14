create table if not exists publishing_house
(
    id bigint not null
        constraint publishing_house_pkey
            primary key,
    description varchar(255),
    language varchar(255),
    name varchar(255)
);

alter table publishing_house owner to postgres;

