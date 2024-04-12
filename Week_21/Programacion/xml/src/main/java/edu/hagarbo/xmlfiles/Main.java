package edu.hagarbo.xmlfiles;

public class Main {
    public static void main(String[] args) {
        Util util = new Util();
        util.fromTxtToXml("datos.txt", "datos.xml");
        System.out.println("Media de los precios = " + util.calcularMedia("datos.xml"));
    }
}
