<html lang="ru">
<head>
<title>Товары</title>
    <link rel="stylesheet" href="style.css" type="text/css"/>
</head>
<body>
<?php
include 'components/navigation.php';
echo createNavigation();
?>
<h1>Обновить товар</h1>
<form action="update.php" method="post">
    <label>Идентификатор</label><input type="number" name="id" required><br>
    <label>Название</label><input type="text" name="title" required><br>
    <label>Описание</label><input type="text" name="description" required><br>
    <label>Цена</label><input type="number" name="price" required><br>
    <input type="submit" value="Обновить">
</form>
<?php
$mysqli = new mysqli("db", "user", "password", "appDB");
if (isset($_POST['id']) && isset($_POST['title']) && isset($_POST['description']) && isset($_POST['price'])){
    $id = $_POST['id'];
    $title = $_POST['title'];
    $description = $_POST['description'];
    $price = $_POST['price'];
    $mysqli->query("UPDATE good SET title='$title', description='$description', price='$price' WHERE id='$id'");
    if ($mysqli->affected_rows > 0){
        echo "<p>Товар обновлен</p>";
    } else {
        echo "<p>Товар не обновлен</p>";
    }
}
?>
</body>
</html>