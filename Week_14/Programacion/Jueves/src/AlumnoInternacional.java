public class AlumnoInternacional extends Alumno {

    private String pais;

    public AlumnoInternacional(String nombre, String apellido, int edad, String dni, String sexo, int peso, int altura,
            String escuela, String grado, String pais) {
        super(nombre, apellido, edad, dni, sexo, peso, altura, escuela, grado);
        this.pais = pais;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

}
