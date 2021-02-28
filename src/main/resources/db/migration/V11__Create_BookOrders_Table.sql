create table if not exists book_orders
(
    book_id bigint not null
        constraint fkf8u7xxf2brayoeqjmd7y40qhp
            references book,
    orders_id bigint not null
        constraint uk_12bcmgm4flxmvgqgmvyhpnhuk
            unique
        constraint fkhagavgj76u5bteykrejgd3gfo
            references orders,
    constraint book_orders_pkey
        primary key (book_id, orders_id)
);

alter table book_orders owner to postgres;

