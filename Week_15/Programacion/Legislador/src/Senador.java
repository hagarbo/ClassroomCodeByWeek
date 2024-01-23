public class Senador extends Legislador {

    public Senador(String nombre, String apellido, int edad, String dni, String sexo, int peso, int altura,
            String provinciaRepresentada, String camara, boolean nacional, int anhosResidencia) {
        super(nombre, apellido, edad, dni, sexo, peso, altura, provinciaRepresentada, camara, nacional,
                anhosResidencia);
    }

    @Override
    public String getCamaraEnQueTrabaja() {
        return "Soy un senador del " + getCamara();
    }

}
