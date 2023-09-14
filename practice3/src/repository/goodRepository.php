<?php
include 'repository/db.php';
include 'dto/goodCreate.php';

class GoodRepository
{
    public static function getAll(): array
    {
        global $mysqli;

        $result = $mysqli->query(
            'SELECT * FROM goods'
        )->fetch_all(MYSQLI_ASSOC);
        return array_map(function ($good) {
            $good["id"] = intval($good["id"]);
            return $good;
        }, $result);
    }

    public static function getById(int $id): ?array
    {
        global $mysqli;

        $result = $mysqli->query(
            "SELECT * FROM goods WHERE id='$id'"
        )->fetch_assoc();

        if ($result) {
            $result["id"] = intval($result["id"]);
            return $result;
        }
        return null;
    }

    public static function create(GoodCreate $good): ?int
    {
        global $mysqli;

        $mysqli->query(
            "INSERT INTO goods (title, description, price) VALUES ('$good->title', '$good->description', '$good->price')"
        );

        return $mysqli->insert_id;
    }

    public static function update(int $id, GoodCreate $good): ?int
    {
        global $mysqli;

        $mysqli->query("INSERT INTO goods (id, title, description, price) VALUES ('$id', '$good->title', '$good->description', '$good->price') ON DUPLICATE KEY UPDATE title='$good->title', description='$good->description', price='$good->price'");

        return $id;
    }

    public static function partialUpdate(int $id, GoodCreate $good): ?int
    {
        global $mysqli;

        if ($good->title)
            $mysqli->query(
                "UPDATE goods SET title='$good->title' WHERE id='$id'"
            );
        if ($good->description)
            $mysqli->query(
                "UPDATE goods SET description='$good->description' WHERE id='$id'"
            );

        if ($good->price)
            $mysqli->query(
                "UPDATE goods SET price='$good->price' WHERE id='$id'"
            );

        return $id;
    }

    public static function delete(int $id): bool
    {
        global $mysqli;

        $mysqli->query(
            "DELETE FROM goods WHERE id='$id'"
        );

        return $mysqli->affected_rows > 0;
    }
}