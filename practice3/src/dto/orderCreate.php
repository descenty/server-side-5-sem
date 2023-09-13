<?php 

class OrderCreate
{
  public int $id;
  public string $address;
  public string $customer_name;
  public array $goods;

  public function __construct($address, $customer_name, $goods)
  {
    $this->address = $address;
    $this->customer_name = $customer_name;
    $this->goods = $goods;
  }

}