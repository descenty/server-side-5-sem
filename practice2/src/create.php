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
<h1>Создать товар</h1>
<form action="create.php" method="post">
    <label>Название</label><input type="text" name="title" required><br>
    <label>Описание</label><input type="text" name="description" required><br>
    <label>Цена</label><input type="number" name="price" required><br>
    <input type="submit" value="Создать">
</form>
<?php
$mysqli = new mysqli("db", "user", "password", "appDB");
if (isset($_POST['title']) && isset($_POST['description']) && isset($_POST['price'])){
    $title = $_POST['title'];
    $description = $_POST['description'];
    $price = $_POST['price'];
    $mysqli->query("INSERT INTO good (title, description, price) VALUES ('$title', '$description', '$price')");
}
?>
</body>
</html>