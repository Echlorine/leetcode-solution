CREATE PROCEDURE UnpivotProducts()
BEGIN
	# Write your MySQL query statement below.
    SET group_concat_max_len = 10240;
    WITH all_column as (
        SELECT column_name col FROM information_schema.columns 
        WHERE table_schema = DATABASE() AND table_name = 'Products' AND column_name <> 'product_id'
    )
    SELECT GROUP_CONCAT(
        'SELECT product_id, \'', col, '\' store, ', col, ' price FROM Products WHERE ',
        col, ' IS NOT NULL '
        SEPARATOR 'UNION '
    ) INTO @sql FROM all_column;
    PREPARE statement FROM @sql;
    EXECUTE statement;
END