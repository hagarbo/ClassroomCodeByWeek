public class Alumno extends Persona {

    private String escuela;
    private String grado;

    public Alumno(String nombre, String apellido, int edad, String dni, String sexo, int peso, int altura,
            String escuela, String grado) {
        super(nombre, apellido, edad, dni, sexo, peso, altura);
        this.escuela = escuela;
        this.grado = grado;
    }

    public String getEscuela() {
        return escuela;
    }

    public void setEscuela(String escuela) {
        this.escuela = escuela;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    @Override
    public String toString() {
        return super.toString() + "\nEscuela=" + escuela + "\nGrado=" + grado;
    }

}
