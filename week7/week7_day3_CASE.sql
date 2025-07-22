CREATE TABLE sales7 (
    employee_id INT,
    month VARCHAR(20),
    sales_amount INT
);

INSERT INTO sales7 VALUES
(1, 'June', 60000),
(2, 'March', 50000),
(3, 'June', 45000),
(4, 'May', 75000),
(5, 'May', 35000),
(6, 'March', 40000);

WITH duplicates AS (
  SELECT *,
         ROW_NUMBER() OVER (
           PARTITION BY employee_id, month, sales_amount
           ORDER BY employee_id
         ) AS row_num
  FROM sales
)
DELETE FROM sales
WHERE (employee_id, month, sales_amount) IN (
  SELECT employee_id, month, sales_amount
  FROM duplicates
  WHERE row_num > 1
);

SELECT 
    employee_id,
    sales_amount,
    month,
    CASE 
        WHEN sales_amount > 50000 THEN 'High'
        WHEN sales_amount BETWEEN 45000 AND 50000 THEN 'Medium'
        ELSE 'Low'
    END AS performance_category
FROM sales7;
