<?php
function getAll() {
    $mysqli = new mysqli("db", "user", "password", "appDB");
    $result = $mysqli->query("SELECT * FROM good");
    return $result;
}

function getById($id) {
    $mysqli = new mysqli("db", "user", "password", "appDB");
    $result = $mysqli->query("SELECT * FROM good WHERE id='$id'");
    return $result;
}

function create($title, $description, $price) {
    $mysqli = new mysqli("db", "user", "password", "appDB");
    $mysqli->query("INSERT INTO good (title, description, price) VALUES ('$title', '$description', '$price')");
    return $mysqli->affected_rows > 0;
}

function updateById($id, $title, $description, $price) {
    $mysqli = new mysqli("db", "user", "password", "appDB");
    $mysqli->query("UPDATE good SET title='$title', description='$description', price='$price' WHERE id='$id'");
    return $mysqli->affected_rows > 0;
}

function deleteById($id) {
    $mysqli = new mysqli("db", "user", "password", "appDB");
    $mysqli->query("DELETE FROM good WHERE id='$id'");
    return $mysqli->affected_rows > 0;
}