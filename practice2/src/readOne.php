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
<h1>Поиск товара по идентификатору</h1>
<form action="read_one.php" method="post">
    <label>Идентификатор</label><input type="number" name="id" required><br>
    <input type="submit" value="Найти">
</form>
<table>
<?php
$mysqli = new mysqli("db", "user", "password", "appDB");
if (isset($_POST['id'])){
    $id = $_POST['id'];
    $result = $mysqli->query("SELECT * FROM good WHERE id='$id'");
    if ($result->num_rows > 0){
        $row = $result->fetch_assoc();
        echo "<tr><th>Идентификатор</th><th>Название</th><th>Описание</th><th>Цена</th></tr>";
        echo "<tr><td>{$row['id']}</td><td>{$row['title']}</td><td>{$row['description']}</td><td>{$row['price']}</td></tr>";
    } else {
        echo "<p>Товар не найден</p>";
    }
}
?>
</table>
</body>
</html>