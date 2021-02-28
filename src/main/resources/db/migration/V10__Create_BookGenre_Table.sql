create table if not exists book_genre
(
    book_id bigint not null
        constraint fk52evq6pdc5ypanf41bij5u218
            references book,
    genre_id bigint not null
        constraint uk_21qfbh5aqd40pc3ifun9qyia5
            unique
        constraint fk8l6ops8exmjrlr89hmfow4mmo
            references genre,
    constraint book_genre_pkey
        primary key (book_id, genre_id)
);

alter table book_genre owner to postgres;

