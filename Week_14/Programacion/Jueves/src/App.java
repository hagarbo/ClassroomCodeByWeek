import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {

        Persona[] gente = new Persona[7];

        gente[0] = new Persona("Pepe", "Botella", 45, "null", "hombre", 0, 0);
        gente[1] = new Docente("Sancho", "snchito", 50, "null", "hombre", 0, 0, "BD");
        gente[2] = new Alumno("Ana", "garcia", 20, null, "null", 0, 0, "Magisterio", "Infantil");
        gente[3] = new AlumnoInternacional("John", "Sina", 30, null, "caballo", 0, 0, "Arquitectura", "hola", "Peru");
        gente[4] = new Persona("Jaime", "null", -6, "", "mosca", 0, 0);
        gente[5] = new Alumno("Javier", null, 89, null, null, 0, 0, null, null);
        gente[6] = new Docente("Maria", null, 36, null, null, 0, 0, null);

        /*
         * for (Persona persona : gente) {
         * 
         * persona.mostrarInfo();
         * System.out.println();
         * }
         */

        Arrays.asList(gente).forEach(e -> e.mostrarInfo());
    }
}
