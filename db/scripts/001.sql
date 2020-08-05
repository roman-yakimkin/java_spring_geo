drop table if exists country;

create table country (
    id          serial primary key not null,
    name        varchar(200) not null
);

insert into country (id, name) values
    (1, 'Russia'),
    (2, 'England'),
    (3, 'France'),
    (4, 'USA'),
    (5, 'Greece');
