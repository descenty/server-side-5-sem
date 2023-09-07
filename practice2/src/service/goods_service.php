<?php
function get_all_goods() {
    $mysqli = new mysqli("db", "user", "password", "appDB");
    $result = $mysqli->query("SELECT * FROM good");
    return $result;
}

function get_good_by_id($id) {
    $mysqli = new mysqli("db", "user", "password", "appDB");
    $result = $mysqli->query("SELECT * FROM good WHERE id='$id'");
    return $result;
}

function create_good($title, $description, $price) {
    $mysqli = new mysqli("db", "user", "password", "appDB");
    $mysqli->query("INSERT INTO good (title, description, price) VALUES ('$title', '$description', '$price')");
    return $mysqli->affected_rows > 0;
}

function update_good($id, $title, $description, $price) {
    $mysqli = new mysqli("db", "user", "password", "appDB");
    $mysqli->query("UPDATE good SET title='$title', description='$description', price='$price' WHERE id='$id'");
    return $mysqli->affected_rows > 0;
}

function delete_good($id) {
    $mysqli = new mysqli("db", "user", "password", "appDB");
    $mysqli->query("DELETE FROM good WHERE id='$id'");
    return $mysqli->affected_rows > 0;
}