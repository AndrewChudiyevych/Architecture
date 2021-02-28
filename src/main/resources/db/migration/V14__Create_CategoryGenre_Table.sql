create table if not exists category_genre
(
    category_id bigint not null
        constraint fkahfad0ijn84t8oy30qunaq6o8
            references category,
    genre_id bigint not null
        constraint uk_ai1dj7nked1cjjln6oawosh83
            unique
        constraint fkrgnqwloum9y7994kkv5tb7myi
            references genre,
    constraint category_genre_pkey
        primary key (category_id, genre_id)
);

alter table category_genre owner to postgres;

