public class Docente extends Persona {

    private String materia;

    public Docente(String nombre, String apellido, int edad, String dni, String sexo, int peso, int altura,
            String materia) {
        super(nombre, apellido, edad, dni, sexo, peso, altura);
        this.materia = materia;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    @Override
    public String toString() {
        return super.toString() + "\nMateria=" + materia;
    }

}
