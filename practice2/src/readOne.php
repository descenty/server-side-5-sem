<?php
include 'service/goods_service.php';
include 'component/goodsTable.php';
$title = 'Найти товар';
$content = '<form action="readOne.php" method="post">
    <label>Идентификатор</label><input type="number" name="id" required><br>
    <input type="submit" value="Найти">';
if (isset($_POST['id'])) {
    $result = getById($_POST['id']);
    if ($result->num_rows > 0){
        $row = $result->fetch_assoc();
        $content .= goodsTable($result);
    } else {
        $content .= "<p>Товар не найден</p>";
    }
}
include 'templates/layout.php';
