<?php
require_once 'api/orderAPI.php';
require_once 'api/goodAPI.php';

header("Access-Control-Allow-Orgin: *");
header("Access-Control-Allow-Methods: *");
header("Content-Type: application/json");

try {
    $orderAPI = new OrderAPI();
    echo $orderAPI->run();
    $goodAPI = new GoodAPI();
    echo $goodAPI->run();
} catch (Exception $e) {
    echo json_encode(array('error' => $e->getMessage()));
}