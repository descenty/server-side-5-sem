<?php
class GoodCreate
{
  public ?string $title;
  public ?string $description;
  public ?float $price;
  public function __construct(?string $title, ?string $description, ?float $price)
  {
    $this->title = $title;
    $this->description = $description;
    $this->price = $price;
  }
}