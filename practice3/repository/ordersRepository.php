<?php
include 'repository/db.php';

function getAllOrders() {
    global $mysqli;
    $result_orders = $mysqli->query(
      "SELECT o.id, o.address, o.customer_name, o.status, o.created_at
      JSON_ARRAYAGG(JSON_OBJECT('title', B.title, 'pages', B.number_of_pages)) AS goods g
    FROM orders o LEFT JOIN g ON o.id = g.order_id
    GROUP BY o.id");
    return $result;
}