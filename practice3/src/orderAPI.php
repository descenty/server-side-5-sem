<?php

require_once 'api.php';
require_once 'repository/orderRepository.php';

class OrderAPI extends Api
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
        return $this->response('Data not found', 404);
    }

    public function createAction()
    {
        $data = $this->requestJSON;
        $order = new OrderCreate(
            $data['address'],
            $data['customer_name'],
            $data['goods'],
        );

        $order_id = OrderRepository::create($order);

        if ($order_id) {
            return $this->response(OrderRepository::getById($order_id), 201);
        }
        return $this->response('Create error', 500);

    }

    /**
     * Метод PUT
     * Обновление отдельной записи (по ее id)
     * https://domain.by/people/1 + параметры запроса name, email
     * @return string
     */
    public function updateAction()
    {
        $parse_url = parse_url($this->requestUri[0]);
        $userId = $parse_url['path'] ?? null;

        $db = (new Db())->getConnect();

        if (!$userId || !People::getById($db, $userId)) {
            return $this->response("User with id=$userId not found", 404);
        }

        $name = $this->requestParams['name'] ?? '';
        $email = $this->requestParams['email'] ?? '';

        if ($name && $email) {
            if ($user = People::update($db, $userId, $name, $email)) {
                return $this->response('Data updated.', 200);
            }
        }
        return $this->response("Update error", 400);
    }

    /**
     * Метод DELETE
     * Удаление отдельной записи (по ее id)
     * https://domain.by/people/1
     * @return string
     */
    public function deleteAction()
    {
        $parse_url = parse_url($this->requestUri[0]);
        $userId = $parse_url['path'] ?? null;

        $db = (new Db())->getConnect();

        if (!$userId || !People::getById($db, $userId)) {
            return $this->response("User with id=$userId not found", 404);
        }
        if (People::deleteById($db, $userId)) {
            return $this->response('Data deleted.', 200);
        }
        return $this->response("Delete error", 500);
    }

}