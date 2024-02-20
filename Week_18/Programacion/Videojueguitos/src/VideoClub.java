import java.util.Comparator;
import java.util.HashMap;

public class VideoClub {
    final static int MAX_SERIES = 5;
    final static int MAX_JUEGOS = 5;

    private HashMap<Integer, Videojuego> juegos;
    private HashMap<Integer, Serie> series;

    public VideoClub() {
        this.juegos = new HashMap<>(5);
        this.series = new HashMap<>(5);
    }

    public void añadirJuego(Videojuego juego) {
        if (this.juegos.size() < MAX_JUEGOS)
            this.juegos.put(this.juegos.size() + 1, juego);
        else
            System.out.println("No hay capacidad para más juegos");
    }

    public void añadirSerie(Serie serie) {
        if (this.series.size() < MAX_JUEGOS)
            this.series.put(this.series.size() + 1, serie);
        else
            System.out.println("No hay capacidad para más series");
    }

    public void entregarJuego(int id) {
        Videojuego buscar = this.juegos.get(id);
        if (buscar != null)
            buscar.entregar();
    }

    public void entregarSerie(int id) {
        Serie buscar = this.series.get(id);
        if (buscar != null)
            buscar.entregar();
    }

    public int contarEntregados() {
        int juegosEntregados = (int) this.juegos.values().stream()
                .filter(e -> e.isEntregado()).count();
        int seriesEntregadas = (int) this.series.values().stream()
                .filter(e -> e.isEntregado()).count();
        return juegosEntregados + seriesEntregadas;
    }

    public Videojuego masLargo() {
        return this.juegos.values()
                .stream()
                .max(Comparator.comparing(Videojuego::getHorasEstimadas))
                .orElse(null);
    }

    public Serie masLarga() {
        return this.series.values()
                .stream()
                .max(Comparator.comparing(Serie::getNumTemporadas))
                .orElse(null);
    }
}
