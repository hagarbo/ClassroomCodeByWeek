package edu.hagarbo.fileio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
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

    public static void randomAccess() {
        try (RandomAccessFile randomAccessFile = new RandomAccessFile("Enunciados.txt", "rw")) {
            System.out.println("Longitud del fichero(Bytes): " + randomAccessFile.length());
            while (randomAccessFile.getFilePointer() < randomAccessFile.length()) {
                long posInicial = randomAccessFile.getFilePointer();
                System.out.println("Posicion antes de la linea:" + posInicial);
                String linea = randomAccessFile.readLine();
                long posFinal = randomAccessFile.getFilePointer();
                System.out.println("Posicion despues de la linea:" + randomAccessFile.getFilePointer());

                if (linea.contains("4)")) {
                    long length = posFinal - posInicial;
                    byte[] buffer = new byte[4096];
                    int read = -1; // will store byte reads from file.read()
                    while ((read = randomAccessFile.read(buffer)) > -1) {
                        randomAccessFile.seek(randomAccessFile.getFilePointer() - read - length);
                        randomAccessFile.write(buffer, 0, read);
                        randomAccessFile.seek(randomAccessFile.getFilePointer() + length);
                    }
                    randomAccessFile.setLength(randomAccessFile.length() - length); // truncate by length
                }
            }
            randomAccessFile.seek(randomAccessFile.length());
            randomAccessFile.writeBytes("\nUn string al final del fichero");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
