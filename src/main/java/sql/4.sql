SELECT
    CASE
        WHEN s.start_time BETWEEN '2023-04-04 09:00:00' AND '2023-04-04 15:00:00' THEN 'с 9 до 15'
        WHEN s.start_time BETWEEN '2023-04-04 15:00:01' AND '2023-04-04 18:00:00' THEN 'с 15 до 18'
        WHEN s.start_time BETWEEN '2023-04-04 18:00:01' AND '2023-04-04 21:00:00' THEN 'с 18 до 21'
        WHEN s.start_time BETWEEN '2023-04-04 21:00:01' AND '2023-04-04 00:00:00' THEN 'с 21 до 00'
        ELSE 'неизвестный интервал'
        END AS interval,
    COUNT(DISTINCT t.id) AS visitors,
    SUM(t.price) AS revenue
FROM cinema.sessions s
         JOIN cinema.tickets t ON s.id = t.session_id
GROUP BY interval;