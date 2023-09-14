<?php
include 'repository/goodsRepository.php';
include 'component/goodsTable.php';
$title = 'Редактировать товар';
$content = '<form action="update.php" method="post">
    <label>Идентификатор</label><input type="number" name="id" required><br>
    <label>Название</label><input type="text" name="title" required><br>
    <label>Описание</label><input type="text" name="description" required><br>
    <label>Цена</label><input type="number" name="price" required><br>
    <input type="submit" value="Обновить">';
if (isset($_POST['id']) && isset($_POST['title']) && isset($_POST['description']) && isset($_POST['price'])) {
    $updated = updateById($_POST['id'], $_POST['title'], $_POST['description'], $_POST['price']);
    if ($updated)
        $content .= "<p>Товар обновлен</p>";
    else
        $content .= "<p>Товар не обновлен</p>";
}
include 'templates/layout.php';