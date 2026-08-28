-- ──────────────────────────────────────────────────
-- Problem  : 608. Tree Node
-- Difficulty: Medium
-- Tags     : Database
-- Link     : https://leetcode.com/problems/tree-node/
-- Runtime  : 556 ms (beats 37%)
-- Memory   : 0B (beats 100%)
-- Language : mysql
-- Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
-- Synced by: leetie
-- ──────────────────────────────────────────────────

select id, 
            case
                 when p_id is null then 'Root'
                 when id in (select p_id from Tree) then 'Inner'
                 else 'Leaf'
            end as type
from Tree