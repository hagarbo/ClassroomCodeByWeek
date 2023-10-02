public class Main {
    public static void main(String args[]){

        Empleado empleado = new Empleado("Jose Luis Moreno","56987453H","empleado");
        Empleado jefe = new Empleado("Diana Garrido","56987453H","coordinador");

        System.out.println(empleado.getSalario());
        System.out.println("Salario del jefe: "+jefe.getSalario());

        jefe.setSalario(jefe.getSalario()+500);
        System.out.println("El jefe se ha subido el salario a: "+jefe.getSalario());


    }
}
