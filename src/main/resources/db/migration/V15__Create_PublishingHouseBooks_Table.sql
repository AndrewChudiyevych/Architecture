create table if not exists publishing_house_books
(
    publishing_house_id bigint not null
        constraint fkicy2eu1jufixerj7ck4xlsklj
            references publishing_house,
    books_id bigint not null
        constraint uk_a9028yen3je5mgsmr11s5oxie
            unique
        constraint fk9sq2oi7j0p25x23rkjflxipyb
            references book,
    constraint publishing_house_books_pkey
        primary key (publishing_house_id, books_id)
);

alter table publishing_house_books owner to postgres;

