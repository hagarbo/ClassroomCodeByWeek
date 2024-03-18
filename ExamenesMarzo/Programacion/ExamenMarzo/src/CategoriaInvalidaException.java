public class CategoriaInvalidaException extends Exception {
    @Override
    public String getMessage() {
        return "Has introducido una categoria invalida!! Selecciona Bazar o Comestible!";
    }
}
