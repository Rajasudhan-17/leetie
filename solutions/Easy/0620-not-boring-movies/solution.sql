-- ──────────────────────────────────────────────────
-- Problem  : 620. Not Boring Movies
-- Difficulty: Easy
-- Tags     : Database
-- Link     : https://leetcode.com/problems/not-boring-movies/
-- Runtime  : 305 ms (beats 35%)
-- Memory   : 0B (beats 100%)
-- Language : mysql
-- Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
-- Synced by: leetie
-- ──────────────────────────────────────────────────

SELECT *
FROM Cinema
WHERE id % 2 = 1
  AND description <> 'boring'
ORDER BY rating DESC;