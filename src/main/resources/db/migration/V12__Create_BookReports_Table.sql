create table if not exists book_reports
(
    book_id bigint not null
        constraint fkpdniy70qj7kai99sgdwxvdt48
            references book,
    reports_id bigint not null
        constraint uk_of4ii8ixup1xwg9hkoupg3dvb
            unique
        constraint fk1cphfge31dsv48af0p20lqksb
            references reports,
    constraint book_reports_pkey
        primary key (book_id, reports_id)
);

alter table book_reports owner to postgres;

