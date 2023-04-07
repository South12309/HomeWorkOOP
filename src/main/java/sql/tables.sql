create table cinema.films
(
    id             bigserial primary key,
    name           varchar(255),
    duration       int
);

create table cinema.sessions
(
    id              bigserial primary key,
    film_id         bigint references cinema.films (id),
    start_time      timestamp
);

create table cinema.tickets
(
    id             bigserial primary key,
    session_id     bigint references cinema.sessions (id),
    number		   varchar(20),
    price          numeric(8, 2)
);

insert into cinema.films (name, duration) values
                                              ('film1', 60),
                                              ('film2', 90),
                                              ('film3', 120),
                                              ('film4', 60),
                                              ('film5', 60);

insert into cinema.sessions (film_id, start_time) values
                                                     (1, '2023-04-04 14:00:00'),
                                                     (1, '2023-04-04 16:00:00'),
                                                     (2, '2023-04-04 13:30:00'),
                                                     (2, '2023-04-04 17:30:00'),
                                                     (3, '2023-04-04 16:00:00'),
                                                     (4, '2023-04-04 19:00:00'),
                                                     (5, '2023-04-04 21:00:00');

insert into cinema.tickets (session_id, number, price) VALUES
                                                           (1, '42424', 350),
                                                           (2, '42554', 450),
                                                           (1, '42453424', 350),
                                                           (3, '4245424', 350),
                                                           (5, '42425424', 350),
                                                           (4, '4245424', 350),
                                                           (4, '42254424', 350),
                                                           (5, '42445224', 350),
                                                           (6, '4243424', 350),
                                                           (7, '4253424', 350),
                                                           (7, '4224424', 350);
