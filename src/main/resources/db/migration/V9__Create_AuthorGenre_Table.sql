create table if not exists author_genre
(
    author_id bigint not null
        constraint fkjwsiyuy9puhhonnwh15dcy8vx
            references author,
    genre_id bigint not null
        constraint uk_sjl0r0aarvuia8cva9syl4b1d
            unique
        constraint fklu5xvc2dh0agyi19xsnk0mo9k
            references genre,
    constraint author_genre_pkey
        primary key (author_id, genre_id)
);

alter table author_genre owner to postgres;

