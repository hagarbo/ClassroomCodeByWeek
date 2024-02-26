<?php

interface INotaServicio{

    public function getNotas(): array;
    public function getNoteById($id);
    public function save(Nota $nota, array $fileInfoArray = null);
    public function deleteNoteById($id);
    public function moverFichero(string $origen, string $destino): bool;
        
}