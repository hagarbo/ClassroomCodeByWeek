<?php

class NotaController
{
    //TODO: 5- Sustituye en NotaController.php la constante TITULO_NOTA_PERMITIDO por la cadena de texto personalizada que te proporcionó la docente.
    private const TITULO_NOTA_PERMITIDO = "ZFA";
    public string $page_title;
    public string $view;
    private INotaServicio $notaServicio;

    private const VIEW_FOLDER = "nota" . DIRECTORY_SEPARATOR;

    public function __construct()
    {
        $this->view = self::VIEW_FOLDER . 'list_note';
        $this->page_title = '';
        $this->notaServicio = new NotaServicio();
    }

    /* List all notes */

    public function list()
    {
        $this->page_title = 'Listado de notas';
        return $this->notaServicio->getNotas();
    }




    public function create()
    {

        if (isset ($_POST["title"], $_POST["completed"], $_POST["createdAt"], $_POST["updatedAt"])) {
            if ($this->validateTitle(trim($_POST["title"]))) {
                $createdAt = DateTimeImmutable::createFromFormat('Y-m-d\TH:i:sO', $_POST["createdAt"]);
                $updatedAt = DateTimeImmutable::createFromFormat('Y-m-d\TH:i:sO', $_POST["updatedAt"]);
                $nota = new Nota(null, $_POST["title"], $_POST["completed"], $createdAt, $updatedAt);

                $notaGuardada = $this->notaServicio->save($nota);

                return json_encode($notaGuardada);
            } else {
                http_response_code(400);
                $response["error"] = "No se permite ese título";
                return json_encode($response);
            }


        } else {
            http_response_code(400);
            $response["error"] = true;
            return json_encode($response);
        }
    }

    private function validateTitle($title): bool
    {
        return (isset($title) && $title === self::TITULO_NOTA_PERMITIDO) ? true : false;
    }


}

?>