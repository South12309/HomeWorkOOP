SELECT
    f1.name AS "фильм 1",
    s1.start_time AS "время начала",
    f1.duration AS "длительность",
    f2.name AS "фильм 2",
    s2.start_time AS "время начала",
    f2.duration AS "длительность"
FROM
    cinema.sessions s1
        JOIN cinema.films f1 ON s1.film_id = f1.id
        JOIN cinema.sessions s2 ON s1.start_time < s2.start_time AND (s1.start_time + INTERVAL '1 MINUTE' * f1.duration) > s2.start_time
        JOIN cinema.films f2 ON s2.film_id = f2.id
WHERE
        s1.start_time <> s2.start_time
ORDER BY
    s1.start_time;