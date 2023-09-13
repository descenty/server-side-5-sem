<?php
include 'repository/db.php';

function getAllGoods() {
    global $mysqli;
    $result = $mysqli->query("SELECT * FROM good");
    return $result;
}

function getGoodById($id) {
    global $mysqli;
    $result = $mysqli->query("SELECT * FROM good WHERE id='$id'");
    return $result;
}

function createGood($title, $description, $price) {
    global $mysqli;
    $mysqli->query("INSERT INTO good (title, description, price) VALUES ('$title', '$description', '$price')");
    return $mysqli->affected_rows > 0;
}

function updateGood($id, $title, $description, $price) {
    global $mysqli;
    $mysqli->query("UPDATE good SET title='$title', description='$description', price='$price' WHERE id='$id'");
    return $mysqli->affected_rows > 0;
}

function deleteGood($id) {
    global $mysqli;
    $mysqli->query("DELETE FROM good WHERE id='$id'");
    return $mysqli->affected_rows > 0;
}