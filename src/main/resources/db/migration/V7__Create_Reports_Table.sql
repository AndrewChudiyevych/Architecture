create table if not exists reports
(
    id bigint not null
        constraint reports_pkey
            primary key,
    report varchar(255),
    score integer not null,
    book_id bigint
        constraint fkfvidf1w7ciolnjcifqsnblcov
            references book
);

alter table reports owner to postgres;

