<?php
include 'repository/ordersRepository.php';

foreach (getAllOrders() as $order) {
  echo "<h1>Заказ №{$order['id']}</h1>";
  echo "<p>Адрес: {$order['address']}</p>";
  echo "<p>Имя заказчика: {$order['customer_name']}</p>";
  echo "<p>Статус: {$order['status']}</p>";
  echo "<p>Дата создания: {$order['created_at']}</p>";
  echo "<h2>Товары</h2>";
  echo "<table><tr><th>Название</th><th>Описание</th><th>Цена</th><th>Количество</th></tr>";
  foreach (json_decode($order['goods'], true) as $good) {
    echo "<tr><td>{$good['title']}</td><td>{$good['description']}</td><td>{$good['price']}</td><td>{$good['quantity']}</td></tr>";
  }
  echo "</table>";
}
