<?php

interface IUsuarioServicio{

    public function getUsuarios(): array;
    public function login(string $user, string $pwd, $rolId): ?Usuario;
    public function getRoles(): array;
    public function getRoleById(int $roleId): ?Rol;

}