create table if not exists category_books
(
    category_id bigint not null
        constraint fk2483nv6bc0vcpj3sgvk2i98cj
            references category,
    books_id bigint not null
        constraint uk_e6jd15dkinwffchqmdwmp79xd
            unique
        constraint fkc3d8bkcgsbim8n75391jgo6a4
            references book,
    constraint category_books_pkey
        primary key (category_id, books_id)
);

alter table category_books owner to postgres;

