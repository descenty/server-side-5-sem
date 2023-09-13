<?php
require_once 'orderAPI.php';
 
try {
    $api = new OrderAPI();
    echo $api->run();
} catch (Exception $e) {
    echo json_encode(Array('error' => $e->getMessage()));
}
