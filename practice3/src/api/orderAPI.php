<?php
require_once 'api/api.php';
require_once 'repository/orderRepository.php';

class OrderAPI extends API
{
    public $apiName = 'orders';

    public function indexAction()
    {
        $orders = OrderRepository::getAll();
        if ($orders) {
            return $this->response($orders, 200);
        }
        return $this->response('Data not found', 404);
    }

    public function viewAction()
    {
        $id = array_shift($this->requestUri);

        if ($id) {
            $order = OrderRepository::getById($id);
            if ($order) {
                return $this->response($order, 200);
            }
        }
        return $this->response('Order not found', 404);
    }

    public function createAction()
    {
        $data = $this->requestJSON;
        $order = new OrderCreate(
            $data['address'],
            $data['customer_name'],
            null,
            $data['goods']
        );

        $order_id = OrderRepository::create($order);

        if ($order_id) {
            return $this->response(OrderRepository::getById($order_id), 201);
        }
        return $this->response('Order creation error', 500);

    }

    public function updateAction()
    {
        $id = array_shift($this->requestUri);

        $data = $this->requestJSON;
        if (!$data || !$id || !isset($data['address']) || !isset($data['customer_name']) || !isset($data['goods'])) {
            return $this->response('Bad request', 400);
        }

        $order = new OrderCreate(
            $data['address'],
            $data['customer_name'],
            $data['status'],
            $data['goods'],
        );

        $order_id = OrderRepository::update($id, $order);

        if ($order_id) {
            return $this->response(OrderRepository::getById($order_id), 200);
        }
        return $this->response('Order update error', 500);
    }

    public function partialUpdateAction()
    {
        $id = array_shift($this->requestUri);

        $data = $this->requestJSON;
        if (!$data) {
            return $this->response('Bad request', 400);
        }
        $order = new OrderCreate(
            isset($data['address']) ? $data['address'] : null,
            isset($data['customer_name']) ? $data['customer_name'] : null,
            isset($data['status']) ? $data['status'] : null,
            isset($data['goods']) ? $data['goods'] : null,
        );

        if (OrderRepository::getById($id) === null)
            return $this->response('Order not found', 404);

        $order_id = OrderRepository::partialUpdate($id, $order);

        if ($order_id) {
            return $this->response(OrderRepository::getById($order_id), 200);
        }
        return $this->response('Order update error', 500);
    }



    public function deleteAction()
    {
        $id = array_shift($this->requestUri);

        if ($id) {
            $deleted = OrderRepository::delete($id);
            if ($deleted)
                return $this->response('Order deleted', 204);
        }
        return $this->response('Order not found', 404);
    }

}