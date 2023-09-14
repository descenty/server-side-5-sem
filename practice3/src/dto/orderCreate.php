<?php
class OrderCreate
{
  public ?string $address;
  public ?string $customer_name;
  public ?string $status;
  public ?array $goods;
  public function __construct(?string $address, ?string $customer_name, ?string $status, ?array $goods)
  {
    $this->address = $address;
    $this->customer_name = $customer_name;
    $this->status = $status;
    $this->goods = $goods;
  }
}