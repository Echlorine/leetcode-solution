CREATE PROCEDURE PivotProducts()
BEGIN
	# Write your MySQL query statement below.
    SET group_concat_max_len = 10240;
    WITH temp AS (
        SELECT DISTINCT store FROM Products
        ORDER BY store
    )
    
    SELECT CONCAT('SELECT product_id, ',
    GROUP_CONCAT('MAX(CASE WHEN store = \'',store,'\' THEN price END) AS ',store),
    ' FROM Products GROUP BY product_id'
    ) INTO @sql FROM temp;

    PREPARE statement FROM @sql;
    EXECUTE statement;
END