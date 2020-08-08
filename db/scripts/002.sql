drop table if exists city;

create table city (
    id            serial not null primary key,
    country_id    int not null references country(id),
    name          varchar(200)
);

insert into city (country_id, name) values
    (1, 'Moscow'), (1, 'Saint Petersburg'), (1, 'Taganrog'),
    (2, 'London'), (2, 'Liverpool'), (2, 'Bristol'),
    (3, 'Paris'), (3, 'Lyon'), (3, 'Bordeaux'),
    (4, 'New York'), (4, 'Los Angeles'), (4, 'New Orleans'),
    (5, 'Athens'), (5, 'Sparta'), (5, 'Knoss');