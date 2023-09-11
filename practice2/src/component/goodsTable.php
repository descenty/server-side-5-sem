<?php
function goodsTable($goods)
{
    $table = '<table><tr><th>Идентификатор</th><th>Название</th><th>Цена</th></tr>';
    foreach ($goods as $good) {
        $table .= "<tr><td>{$good['id']}</td><td>{$good['title']}</td><td>{$good['price']}</td></tr>";
    }
    return $table . '</table>';
}
