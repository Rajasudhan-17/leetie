-- ──────────────────────────────────────────────────
-- Problem  : 619. Biggest Single Number
-- Difficulty: Easy
-- Tags     : Database
-- Link     : https://leetcode.com/problems/biggest-single-number/
-- Runtime  : 592 ms (beats 15%)
-- Memory   : 0B (beats 100%)
-- Language : mysql
-- Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
-- Synced by: leetie
-- ──────────────────────────────────────────────────

# Write your MySQL query statement below
select MAX(num) as num
from MyNumbers
where num in(select num 
            from MyNumbers 
            group by num 
            having count(*)=1);