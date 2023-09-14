<?php
abstract class API
{
    public $apiName = '';
    protected $method = '';
    public $requestUri = [];
    public $requestParams = [];
    public $requestJSON = [];
    protected $action = '';
    public function __construct()
    {

        //Массив GET параметров разделенных /
        $this->requestUri = explode('/', trim($_SERVER['REQUEST_URI'], '/'));
        $this->requestParams = $_REQUEST;
        $this->requestJSON = json_decode(file_get_contents('php://input'), true);

        //Определение метода запроса
        $this->method = $_SERVER['REQUEST_METHOD'];
        if ($this->method == 'POST' && array_key_exists('HTTP_X_HTTP_METHOD', $_SERVER))
            if ($_SERVER['HTTP_X_HTTP_METHOD'] == 'DELETE')
                $this->method = 'DELETE';
            else if ($_SERVER['HTTP_X_HTTP_METHOD'] == 'PUT')
                $this->method = 'PUT';
            else if ($_SERVER['HTTP_X_HTTP_METHOD'] == 'PATCH')
                $this->method = 'PATCH';
            else
                throw new Exception("Unexpected Header");
    }

    public function run()
    {
        if (array_shift($this->requestUri) !== 'api' || array_shift($this->requestUri) !== $this->apiName)
            // throw new RuntimeException('API Not Found', 404);
            return;

        $this->action = $this->getAction();

        if (method_exists($this, $this->action))
            return $this->{$this->action}();
        else
            throw new RuntimeException('Invalid Method', 405);

    }

    protected function response($data, $status = 500)
    {
        header("HTTP/1.1 " . $status . " " . $this->requestStatus($status));
        return json_encode($data);
    }

    private function requestStatus($code)
    {
        $status = array(
            200 => 'OK',
            201 => 'Created',
            204 => 'No Content',
            400 => 'Bad Request',
            404 => 'Not Found',
            405 => 'Method Not Allowed',
            500 => 'Internal Server Error',
        );
        return ($status[$code]) ? $status[$code] : $status[500];
    }

    protected function getAction()
    {
        $method = $this->method;
        switch ($method) {
            case 'GET':
                if ($this->requestUri)
                    return 'viewAction';
                else
                    return 'indexAction';
            case 'POST':
                return 'createAction';
            case 'PUT':
                return 'updateAction';
            case 'PATCH':
                return 'partialUpdateAction';
            case 'DELETE':
                return 'deleteAction';
            default:
                return null;
        }
    }

    abstract protected function indexAction();
    abstract protected function viewAction();
    abstract protected function createAction();
    abstract protected function updateAction();
    abstract protected function partialUpdateAction();
    abstract protected function deleteAction();
}