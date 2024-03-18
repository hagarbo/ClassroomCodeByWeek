public class PrecioInvalidoException extends Exception {

    @Override
    public String getMessage() {
        return "El precio no puede ser un numero negativo!!!";
    }

}
