-- ──────────────────────────────────────────────────
-- Problem  : 586. Customer Placing the Largest Number of Orders
-- Difficulty: Easy
-- Tags     : Database
-- Link     : https://leetcode.com/problems/customer-placing-the-largest-number-of-orders/
-- Runtime  : 1027 ms (beats 5%)
-- Memory   : 0B (beats 100%)
-- Language : mysql
-- Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
-- Synced by: leetie
-- ──────────────────────────────────────────────────

SELECT customer_number
FROM Orders 
GROUP BY customer_number
ORDER BY COUNT(customer_number) DESC
LIMIT 1;