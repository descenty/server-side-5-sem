<?php
include 'repository/db.php';

function getAllOrders()
{
  global $mysqli;
  return $mysqli->query(
    'SELECT orders.id, orders.address, orders.customer_name, orders.status, orders.created_at,
    JSON_ARRAYAGG(JSON_OBJECT(
      "id", ordered_goods.id,
      "title", goods.title,
      "description", goods.description,
      "price", goods.price,
      "quantity", ordered_goods.quantity)) as goods
    FROM orders
    LEFT JOIN ordered_goods ON orders.id = ordered_goods.order_id
    LEFT JOIN goods on ordered_goods.good_id = goods.id
    GROUP BY orders.id'
  );
}

function getOrderById($id)
{
  global $mysqli;
  return $mysqli->query(
    "SELECT orders.id, orders.address, orders.customer_name, orders.status, orders.created_at,
    JSON_ARRAYAGG(JSON_OBJECT(
      'id', ordered_goods.id,
      'title', goods.title,
      'description', goods.description,
      'price', goods.price,
      'quantity', ordered_goods.quantity)) as goods
    FROM orders
    LEFT JOIN ordered_goods ON orders.id = ordered_goods.order_id
    LEFT JOIN goods on ordered_goods.good_id = goods.id
    WHERE orders.id='$id'
    GROUP BY orders.id"
  );
}

function createOrder($address, $customer_name, $status, $goods)
{
  global $mysqli;
  $mysqli->query("INSERT INTO orders (address, customer_name, status) VALUES ('$address', '$customer_name', '$status')");
  $order_id = $mysqli->insert_id;
  foreach ($goods as $good) {
    $good_id = $good['id'];
    $quantity = $good['quantity'];
    $mysqli->query("INSERT INTO ordered_goods (order_id, good_id, quantity) VALUES ('$order_id', '$good_id', '$quantity')");
  }
  return $mysqli->affected_rows > 0;
}

function updateOrder($id, $address, $customer_name, $status, $goods)
{
  global $mysqli;
  $mysqli->query("UPDATE orders SET address='$address', customer_name='$customer_name', status='$status' WHERE id='$id'");
  $mysqli->query("DELETE FROM ordered_goods WHERE order_id='$id'");
  foreach ($goods as $good) {
    $good_id = $good['id'];
    $quantity = $good['quantity'];
    $mysqli->query("INSERT INTO ordered_goods (order_id, good_id, quantity) VALUES ('$id', '$good_id', '$quantity')");
  }
  return $mysqli->affected_rows > 0;
}

function partialUpdateOrder($id, $address, $customer_name, $status)
{
  global $mysqli;
  if ($address) {
    $mysqli->query("UPDATE orders SET address='$address' WHERE id='$id'");
  }
  if ($customer_name) {
    $mysqli->query("UPDATE orders SET customer_name='$customer_name' WHERE id='$id'");
  }
  if ($status) {
    $mysqli->query("UPDATE orders SET status='$status' WHERE id='$id'");
  }
}

function deleteOrder($id)
{
  global $mysqli;
  $mysqli->query("DELETE FROM orders WHERE id='$id'");
  return $mysqli->affected_rows > 0;
}
