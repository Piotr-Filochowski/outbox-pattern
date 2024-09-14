create table if not exists complaints
(
    product_id UUID not null,
    text varchar(250) not null,
    created_at timestamp not null,
    author varchar(250) not null,
    county varchar(250) not null,
    counter integer not null,
    PRIMARY KEY (product_id, author)
);

COMMENT ON COLUMN complaints.counter IS 'Counts duplicates of complaints';

