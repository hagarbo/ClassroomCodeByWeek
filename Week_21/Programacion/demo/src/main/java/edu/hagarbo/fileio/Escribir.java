package edu.hagarbo.fileio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Escribir {

    private static final String[] NOMBRES = { "Jose Juan", "Eustaquia", "Amancia", "Lorena" };
    private static final String FILENAME = "datos.txt";

    public static void escribirNombres() {
        try {
            FileWriter fWriter = new FileWriter(FILENAME);
            for (int i = 0; i < NOMBRES.length; i++) {
                fWriter.write((i + 1) + ". " + NOMBRES[i] + "\n");
            }
            fWriter.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void escribirObjeto() {
        Registro registro = new Registro("Jesus Gil", "Marbella", "666666666");
        Registro registro2 = new Registro("Julio Iglesias", "Miami", "666666666");
        ArrayList<Registro> lista = new ArrayList();
        lista.add(registro);
        lista.add(registro2);

        try (FileOutputStream salida = new FileOutputStream("serialize.bin")) {
            ObjectOutputStream objeto = new ObjectOutputStream(salida);
            objeto.writeObject(lista);
            objeto.close();
        } catch (Exception e) {
            System.out.println("ERROR");
        }
    }

    public static void recuperarObjeto() {
        try (FileInputStream entrada = new FileInputStream("serialize.bin")) {
            ObjectInputStream objeto = new ObjectInputStream(entrada);
            ArrayList<Registro> lista = (ArrayList<Registro>) objeto.readObject();
            for (Registro registro : lista) {
                System.out.println(registro.toString());
            }
            objeto.close();
        } catch (Exception e) {
            System.out.println("ERROR");
        }
    }
}
