<?php
include 'repository/db.php';
include 'dto/orderCreate.php';

class OrderRepository
{
  public static function getAll(): array
  {
    global $mysqli;

    $result = $mysqli->query(
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
    )->fetch_all(MYSQLI_ASSOC);
    return array_map(function ($order) {
      $order["id"] = intval($order["id"]);
      $order['goods'] = json_decode($order['goods'], true);
      return $order;
    }, $result);
  }


  public static function getById(int $id): ?array
  {
    global $mysqli;

    $result = $mysqli->query(
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
    )->fetch_assoc();

    if ($result) {
      $result["id"] = intval($result["id"]);
      $result['goods'] = json_decode($result['goods'], true);
      return $result;
    }
    return null;
  }

  public static function create(OrderCreate $order): ?int
  {
    global $mysqli;

    $mysqli->query("INSERT INTO orders (address, customer_name) VALUES ('$order->address', '$order->customer_name')");
    $order_id = $mysqli->insert_id;
    foreach ($order->goods as $good) {
      $good_id = $good['id'];
      $quantity = $good['quantity'];
      $mysqli->query("INSERT INTO ordered_goods (order_id, good_id, quantity) VALUES ('$order_id', '$good_id', '$quantity')");
    }
    return $order_id;
  }

  public static function update($id, $address, $customer_name, $status, $goods): bool
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

  public static function partialUpdate($id, $address, $customer_name, $status): bool
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
    return $mysqli->affected_rows > 0;
  }

  public static function delete($id): bool
  {
    global $mysqli;
    $mysqli->query("DELETE FROM orders WHERE id='$id'");
    return $mysqli->affected_rows > 0;
  }
}