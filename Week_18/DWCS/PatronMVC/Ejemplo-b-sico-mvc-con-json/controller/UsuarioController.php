<?php

class UsuarioController
{

    public string $page_title;
    public string $view;
    private IUsuarioServicio $usuarioServicio;

    private const VIEW_FOLDER = "usuario" . DIRECTORY_SEPARATOR;

    public function __construct()
    {
        $this->view = self::VIEW_FOLDER . 'list_user';
        $this->page_title = '';
        $this->usuarioServicio = new UsuarioServicio();
    }

    /* List all notes */

    public function list()
    {
        $this->page_title = 'Listado de usuarios';
        return $this->usuarioServicio->list();
    }
}
