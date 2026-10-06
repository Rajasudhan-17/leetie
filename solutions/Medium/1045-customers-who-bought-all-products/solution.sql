-- ──────────────────────────────────────────────────
-- Problem  : 1045. Customers Who Bought All Products
-- Difficulty: Medium
-- Tags     : Database
-- Link     : https://leetcode.com/problems/customers-who-bought-all-products/
-- Runtime  : 696 ms (beats 27%)
-- Memory   : 0B (beats 100%)
-- Language : mysql
-- Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
-- Synced by: leetie
-- ──────────────────────────────────────────────────

SELECT customer_id
FROM Customer
GROUP BY customer_id
HAVING COUNT(DISTINCT product_key) = (SELECT COUNT(*) FROM Product);