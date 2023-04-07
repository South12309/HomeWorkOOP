SELECT
    f1.name as "фильм 1",
    s1.start_time as "время начала",
    f1.duration as "длительность",
    s2.start_time as "время начала второго фильма",
    EXTRACT(EPOCH FROM (s2.start_time - (s1.start_time + INTERVAL '1 MINUTE' * f1.duration)))/60 as "длительность перерыва"
FROM
    cinema.sessions s1
        JOIN
    cinema.films f1
    ON
            s1.film_id = f1.id
        JOIN
    cinema.sessions s2
    ON
                s1.start_time < s2.start_time
            AND s2.start_time - (s1.start_time + INTERVAL '1 MINUTE' * f1.duration) >= INTERVAL '30 minutes'
            AND s1.id < s2.id
            AND s1.id = (SELECT MAX(id) FROM cinema.sessions WHERE id < s2.id)
ORDER BY
    "длительность перерыва" DESC;
