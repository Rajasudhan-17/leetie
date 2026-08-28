-- ──────────────────────────────────────────────────
-- Problem  : 610. Triangle Judgement
-- Difficulty: Easy
-- Tags     : Database
-- Link     : https://leetcode.com/problems/triangle-judgement/
-- Runtime  : 306 ms (beats 65%)
-- Memory   : 0B (beats 100%)
-- Language : mysql
-- Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
-- Synced by: leetie
-- ──────────────────────────────────────────────────

# Write your MySQL query statement below
select *, if(x+y>z and y+z>x and x+z>y, "Yes","No") as triangle from triangle