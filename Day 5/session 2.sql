1)# You are using MYSQL
select city,Length(city) as Length 
from station
order by Length(city) desc limit 1;

3)# You are using MYSQL
select sell_date as date,count(product) as no_of_products
from orders
group by sell_date;

4)# You are using MYSQL
SELECT DISTINCT s.buyer_id
FROM sales s
INNER JOIN product p ON s.product_id = p.product_id
WHERE p.product_name = 'S8'
AND s.buyer_id NOT IN (
    SELECT s2.buyer_id
    FROM sales s2
    INNER JOIN product p2 ON s2.product_id = p2.product_id
    WHERE p2.product_name = 'iPhone'
);
