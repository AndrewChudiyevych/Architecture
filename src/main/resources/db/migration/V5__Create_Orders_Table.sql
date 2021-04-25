create table if not exists orders
(
    id bigint not null
        constraint orders_pkey
            primary key,
    order_date varchar(255),
    status varchar(255),
    kode_id bigint
        constraint fk8sk1fmjcrvqteuq73cp1nwntu
            references book
);

alter table orders owner to postgres;

