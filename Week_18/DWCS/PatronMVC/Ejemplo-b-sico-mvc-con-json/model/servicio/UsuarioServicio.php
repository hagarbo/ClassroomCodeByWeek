<?php

final class UsuarioServicio implements IUsuarioServicio
{

    private IUsuarioRepository $repository;

    public function __construct()
    {
        $this->repository = new UsuarioRepository();
    }

    function listar(): array
    {
        return $this->repository->getUsuarios();
    }
}
