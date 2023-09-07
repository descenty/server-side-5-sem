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
<h1>Удалить товар</h1>
<form action="delete.php" method="post">
    <label>Идентификатор</label><input type="number" name="id" required><br>
    <input type="submit" value="Удалить">
</form>
<?php
$mysqli = new mysqli("db", "user", "password", "appDB");
if (isset($_POST['id'])){
    $id = $_POST['id'];
    $mysqli->query("DELETE FROM good WHERE id='$id'");
    if ($mysqli->affected_rows > 0){
        echo "<p>Товар удален</p>";
    } else {
        echo "<p>Товар не удален</p>";
    }
}
?>
</body>
</html>