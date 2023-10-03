public class Main {
    public static void main(String[] args) {

        System.out.println("****** VAMOS A IMPRIMIR LAS TABLAS DE MULTIPLICAR **********");
        for (int i=1;i<10;i++){
            System.out.println("******* Esta es la tabla del "+i);
            for (int j=0;j<10;j++){
                System.out.println("> "+i+"*"+j+"="+i*j);
            }
            System.out.println("********************************");
        }
    }
}