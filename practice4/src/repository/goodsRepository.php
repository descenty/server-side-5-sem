<?php
include 'repository/db.php';
function getAll() {
    global $mysqli;
    $result = $mysqli->query("SELECT * FROM good");
    return $result;
}

function getById($id) {
    global $mysqli;
    $result = $mysqli->query("SELECT * FROM good WHERE id='$id'");
    return $result;
}

function create($title, $description, $price) {
    global $mysqli;
    $mysqli->query("INSERT INTO good (title, description, price) VALUES ('$title', '$description', '$price')");
    return $mysqli->affected_rows > 0;
}

function update($id, $title, $description, $price) {
    global $mysqli;
    $mysqli->query("UPDATE good SET title='$title', description='$description', price='$price' WHERE id='$id'");
    return $mysqli->affected_rows > 0;
}

function delete($id) {
    global $mysqli;
    $mysqli->query("DELETE FROM good WHERE id='$id'");
    return $mysqli->affected_rows > 0;
}