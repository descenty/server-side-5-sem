<?php
include 'service/goods_service.php';
include 'component/goodsTable.php';
$title = 'Список товаров';
$content = goodsTable(getAll());
include 'templates/layout.php';
