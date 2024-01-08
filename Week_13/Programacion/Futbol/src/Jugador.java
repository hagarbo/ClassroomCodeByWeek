public class Jugador {

    private Equipo equipo;
    private DatosPersona datosJugador;

    public Jugador(Equipo equipo, DatosPersona datosJugador) {
        this.equipo = equipo;
        this.datosJugador = datosJugador;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public DatosPersona getDatosJugador() {
        return datosJugador;
    }

    public void setDatosJugador(DatosPersona datosJugador) {
        this.datosJugador = datosJugador;
    }

}
