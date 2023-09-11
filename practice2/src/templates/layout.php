<html lang='ru'>

<head>
    <title><?= $title; ?></title>
    <link rel='stylesheet' href='style.css' type='text/css' />
</head>

<body>
    <?php
    include 'component/navigation.php';
    echo navigation();
    ?>
    <h1><?= $title; ?></h1>
    <?= $content; ?>
</body>

</html>