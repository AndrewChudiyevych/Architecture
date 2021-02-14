create table if not exists genre
(
    id bigint not null
        constraint genre_pkey
            primary key,
    name varchar(255),
    author_id bigint
        constraint fk7sodapkin98ers6ndcbvmhe09
            references author,
    book_id bigint
        constraint fktpe44vspgfxqhb3lra67nl2bm
            references book,
    category_id bigint
        constraint fkg6mr97ga4dgmqdad5sl9mhss3
            references category
);

alter table genre owner to postgres;

