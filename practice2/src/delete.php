<?php
include 'repository/goodsRepository.php';
include 'component/goodsTable.php';
$title = 'Удалить товар';
$content = '<form action="delete.php" method="post">
    <label>Идентификатор</label><input type="number" name="id" required><br>
    <input type="submit" value="Найти">';
if (isset($_POST['id'])) {
    $deleted = deleteById($_POST['id']);
    $content .= $deleted ? "<p>Товар удален</p>" : "<p>Товар не найден</p>";
}
include 'templates/layout.php';