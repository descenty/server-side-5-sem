<?php
include 'repository/db.php';

function getAllOrders()
{
  global $mysqli;
  $result_orders = $mysqli->query(
    "SELECT orders.id, orders.address, orders.customer_name, orders.status, orders.created_at
    JSON_ARRAYAGG(JSON_OBJECT(goods.id)) as goods
  FROM orders LEFT JOIN ordered_goods ON orders.id = ordered_goods.order_id
  GROUP BY orders.id"
  );
  return $result_orders->fetch_all(MYSQLI_ASSOC);
}
