create table if not exists author_books
(
    author_id bigint not null
        constraint fkfvabqdr9njwv4khjqkf1pbmma
            references author,
    books_id bigint not null
        constraint uk_fxksjqa1a5dnqf0egcdxlrcna
            unique
        constraint fkr514ej8rhei197wx3nrvp0qie
            references book,
    constraint author_books_pkey
        primary key (author_id, books_id)
);

alter table author_books owner to postgres;

