
<?php 

final class UnaClase
{

    public const CONSTANTE_PUBLICA = "<p>Hola, soy una constante publica</p>";

    protected const CONSTANTE_PROTEGIDA = "<p>Hola, soy una constante protegida</p>";
    private const CONSTANTE_PRIVADA = "<p>Hola, soy una constante privada</p>";

    public function foo(){
        echo self::CONSTANTE_PUBLICA;
        echo self::CONSTANTE_PROTEGIDA;
        echo self::CONSTANTE_PRIVADA;
    }
    
}
