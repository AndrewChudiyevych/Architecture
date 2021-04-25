create table if not exists book
(
    id bigint not null
        constraint book_pkey
            primary key,
    book_name varchar(255),
    date_of_airing varchar(255),
    in_stock boolean not null,
    language varchar(255),
    pages integer not null,
    price numeric(19,2),
    author_id bigint
        constraint fkklnrv3weler2ftkweewlky958
            references author,
    category_id bigint
        constraint fkam9riv8y6rjwkua1gapdfew4j
            references category,
    publishing_house_id bigint
        constraint fkljoqq01hogerbaa4odx0wkgiu
            references publishing_house
);

alter table book owner to postgres;

