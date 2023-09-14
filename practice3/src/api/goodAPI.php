<?php
require_once 'api/api.php';
require_once 'repository/goodRepository.php';

class GoodAPI extends API
{
    public $apiName = 'goods';

    public function indexAction()
    {
        $goods = GoodRepository::getAll();
        if ($goods) {
            return $this->response($goods, 200);
        }
        return $this->response('Data not found', 404);
    }

    public function viewAction()
    {
        $id = array_shift($this->requestUri);

        if ($id) {
            $good = GoodRepository::getById($id);
            if ($good)
                return $this->response($good, 200);
        }
        return $this->response('Good not found', 404);
    }

    public function createAction()
    {
        $data = $this->requestJSON;
        $good = new GoodCreate(
            $data['title'],
            $data['description'],
            $data['price']
        );

        $good_id = GoodRepository::create($good);

        if ($good_id)
            return $this->response(GoodRepository::getById($good_id), 201);
        return $this->response('Good creation error', 500);

    }

    public function updateAction()
    {
        $id = array_shift($this->requestUri);

        $data = $this->requestJSON;
        if (!$data || !isset($data['title']) || !isset($data['description']) || !isset($data['price'])) {
            return $this->response('Bad request', 400);
        }

        $good = new GoodCreate(
            $data['title'],
            $data['description'],
            $data['price']
        );

        $good_id = GoodRepository::update($id, $good);

        if ($good_id)
            return $this->response(GoodRepository::getById($good_id), 200);
        return $this->response('Good update error', 500);
    }

    public function partialUpdateAction()
    {
        $id = array_shift($this->requestUri);

        $data = $this->requestJSON;
        if (!$data || !$id) {
            return $this->response('Bad request', 400);
        }

        $good = GoodRepository::getById($id);

        if (!$good) {
            return $this->response('Good not found', 404);
        }

        $good = new GoodCreate(
            $data['title'] ?? $good['title'],
            $data['description'] ?? $good['description'],
            $data['price'] ?? $good['price']
        );

        $good_id = GoodRepository::update($id, $good);

        if ($good_id) {
            return $this->response(GoodRepository::getById($good_id), 200);
        }
        return $this->response('Good update error', 500);
    }

    public function deleteAction()
    {
        $id = array_shift($this->requestUri);

        if ($id) {
            $deleted = GoodRepository::delete($id);
            if ($deleted)
                return $this->response('Good deleted', 204);
        }

        return $this->response('Good not found', 404);
    }
}