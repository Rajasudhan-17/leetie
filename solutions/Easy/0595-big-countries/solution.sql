-- ──────────────────────────────────────────────────
-- Problem  : 595. Big Countries
-- Difficulty: Easy
-- Tags     : Database
-- Link     : https://leetcode.com/problems/big-countries/
-- Runtime  : 431 ms (beats 9%)
-- Memory   : 0B (beats 100%)
-- Language : mysql
-- Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
-- Synced by: leetie
-- ──────────────────────────────────────────────────

SELECT name, population, area
FROM World
WHERE area >= 3000000
   OR population >= 25000000;