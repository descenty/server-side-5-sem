<?php
include 'repository/goodsRepository.php';
include 'component/goodsTable.php';
$title = 'Список товаров';
$content = goodsTable(getAll());
include 'templates/layout.php';
