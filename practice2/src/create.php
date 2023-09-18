<?php
include 'repository/goodsRepository.php';
include 'component/goodsTable.php';
$title = 'Создать товар';
$content = '<form action="create.php" method="post">
    <label>Название</label><input type="text" name="title" required><br>
    <label>Описание</label><input type="text" name="description" required><br>
    <label>Цена</label><input type="number" name="price" required><br>
    <input type="submit" value="Создать">';
if (isset($_POST['title']) && isset($_POST['description']) && isset($_POST['price'])) {
    $created = createGood($_POST['title'], $_POST['description'], $_POST['price']);
    $content .= $created ? "<p>Товар создан</p>" : "<p>Товар не создан</p>";
}
include 'templates/layout.php';
