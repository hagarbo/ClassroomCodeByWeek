public class Persona {

    private String nombre;
    private String apellido;
    private int edad;
    private String dni;
    private String sexo;
    private int peso;
    private int altura;

    public Persona(String nombre, String apellido, int edad, String dni, String sexo, int peso, int altura) {
        if (isValidAge(edad))
            this.edad = edad;
        else
            return;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        if (isValidGender(sexo))
            this.sexo = sexo;
        else
            this.sexo = "";
        this.peso = peso;
        this.altura = altura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = isValidAge(edad) ? edad : this.edad;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    private boolean isValidAge(int age) {
        return (edad < 17 && edad > 67);
    }

    private boolean isValidGender(String gender) {
        return gender.equalsIgnoreCase("hombre") || gender.equalsIgnoreCase("mujer");
    }

    @Override
    public String toString() {
        return "*****Persona******\nNombre=" + nombre + "\nApellido=" + apellido + "\nEdad=" + edad + "\nDni=" + dni
                + "\nSexo="
                + sexo + "\nPeso=" + peso + "\nAltura=" + altura;
    }

    public void mostrarInfo() {
        System.out.println(this.toString());
    }

}