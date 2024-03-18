import java.time.LocalDate;

public class Validaciones {

    public static void validarPrecio(double precio) throws PrecioInvalidoException {
        if (precio < 0.0)
            throw new PrecioInvalidoException();
    }

    public static void validarFecha(LocalDate fecha) throws FechaInvalidaException {
        LocalDate hoy = LocalDate.now();
        if (hoy.isAfter(fecha))
            throw new FechaInvalidaException();
    }

    public static void validarCategoria(String categoria) throws CategoriaInvalidaException {
        if (!categoria.equalsIgnoreCase("Comestible") && !categoria.equalsIgnoreCase("Bazar"))
            throw new CategoriaInvalidaException();
    }
}
