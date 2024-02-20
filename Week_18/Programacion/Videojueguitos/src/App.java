public class App {
    public static void main(String[] args) throws Exception {

        VideoClub videoClub = new VideoClub();

        videoClub.añadirJuego(new Videojuego());
        videoClub.añadirJuego(new Videojuego("Doom", 50));
        videoClub.añadirJuego(new Videojuego("Honkai SR", 200));
        videoClub.añadirJuego(new Videojuego("Fantasia Final 7", 300));
        videoClub.añadirJuego(new Videojuego("Tetris", 30));
        videoClub.añadirJuego(new Videojuego("Tetris", 30));

        videoClub.añadirSerie(new Serie());
        videoClub.añadirSerie(new Serie("Los Soprano", "Martin J.F."));
        videoClub.añadirSerie(new Serie("Juego de trompos", 5, "Comedia", "Yo"));
        videoClub.añadirSerie(new Serie("Lost", "Joe J.F."));
        videoClub.añadirSerie(new Serie("The Office", 7, "Comedia", "Michael Scott"));
        videoClub.añadirSerie(new Serie());

        System.out.println("Series y juegos entregados: " + videoClub.contarEntregados());

        System.out.println("Entregando 2 juegos y 1 serie");

        videoClub.entregarJuego(1);
        videoClub.entregarJuego(5);
        videoClub.entregarSerie(3);

        System.out.println("Series y juegos entregados: " + videoClub.contarEntregados());

        System.out.println("Serie con mas temporadas: " + videoClub.masLarga().toString());
        System.out.println("Juego con mas horas: " + videoClub.masLargo().toString());

        try {
            int error = 6 / 0;
        } catch (ArithmeticException e) {
            System.out.println("No se puede dividir por cero");
            e.printStackTrace();
            // throw new IndexOutOfBoundsException("No se puede dividir por cero");
        }

    }
}
