DROP TABLE IF EXISTS temp_movie_stats;
CREATE TEMPORARY TABLE IF NOT EXISTS temp_movie_stats AS
SELECT
    f.name,
    SUM(visitors_per_showtime) AS total_visitors,
    ROUND(AVG(visitors_per_showtime), 2) AS average_visitors_per_showtime,
    SUM(revenue) AS total_revenue
FROM cinema.films f
         JOIN (
    SELECT
        s.film_id,
        SUM(t.price) AS revenue,
        COUNT(t.id) AS visitors_per_showtime
    FROM cinema.sessions s
             LEFT JOIN cinema.tickets t ON s.id = t.session_id
    GROUP BY s.film_id, s.id
) AS s ON f.id = s.film_id
GROUP BY f.name
ORDER BY total_revenue DESC;

SELECT name, total_visitors, average_visitors_per_showtime, total_revenue
FROM temp_movie_stats
UNION
SELECT 'итого', SUM(total_visitors), ROUND(AVG(average_visitors_per_showtime), 2), SUM(total_revenue)
FROM temp_movie_stats;