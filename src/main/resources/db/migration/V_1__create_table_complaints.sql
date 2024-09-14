create table if not exists complaints
(
    product_id UUID not null,
    text varchar(250) not null,
    created_at timestamp not null,
    author varchar(250) not null,
    PRIMARY KEY (product_id, author)
);
