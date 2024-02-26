<?php

class UsuarioServicio implements IUsuarioServicio
{

    const USER_DOES_NOT_EXIST = "No existe usuario";
    const PWD_INCORRECT = "La contraseña no es correcta";


    private IUsuarioRepository $usuarioRepository;
    private IRolRepository $rolRepository;

    public function __construct(){
        $this->usuarioRepository = new UsuarioRepository();
        $this->rolRepository = new RolRepository();
    }


    public function getUsuarios(): array
    {
        $users = $this->usuarioRepository->findAll();

        foreach ($users as $user) {
            $user->setRoles(
                $this->rolRepository->findRolesByUserId($user->getId())
            );
        }
        
        return $users;
    }

    public function login(string $user, string $pwd, $rolId): ?Usuario
    {
        $is_valid_user = false;
        $user = $this->usuarioRepository->findUsuarioByEmail($user);

        if ($user != null 
            && password_verify($pwd, $user->getPwdhash()))
        {
            $user->setRoles($this->rolRepository->findRolesByUserId($user->getId()));
            if ($this->isUserInRole($user,$rolId))
                $is_valid_user = true;
        }
            
        return $is_valid_user? $user : null;
    }

    public function getRoles(): array
    {

        $roles = $this->rolRepository->findAll();

        return $roles;
    }

    public function getRoleById(int $roleId): ?Rol
    {

        return $this->rolRepository->read($roleId);




    }

    private function isUserInRole(Usuario $usuario, int $roleId): bool
    {
        $rolesArray = $usuario->getRoles();
        foreach ($rolesArray as $rol) {
            if ($rol->getId() === $roleId) {
                return true;
            }
        }

        return false;

    }


}

?>