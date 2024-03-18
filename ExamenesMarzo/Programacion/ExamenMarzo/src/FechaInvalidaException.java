public class FechaInvalidaException extends Exception {
    @Override
    public String getMessage() {
        return "Fecha invalida!!! El producto ya está caducado!";
    }
}
