package edu.hagarbo.fileio;

import java.io.File;
import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        String dir = ".";
        String extension = "xml";
        File file = new File(dir);

        try {
            if (file.canRead())
                System.out.println("TENGO PERMISOS DE LECTURA ");
            if (file.canWrite())
                System.out.println("TENGO PERMISOS DE ESCRITURA");
            if (file.isDirectory()) {
                System.out.println("\n LISTADO DE ARCHIVOS \n");
                /*
                 * File[] archivos = file.listFiles(new FilenameFilter() {
                 * public boolean accept(File dir, String name) {
                 * return name.toLowerCase().endsWith("xml");
                 * }
                 * });
                 */

                File[] archivos = file.listFiles();

                Arrays.stream(archivos)
                        .map(File::getName)
                        .filter(f -> f.toLowerCase().endsWith(extension))
                        .forEach(System.out::println);

            } else
                System.out.println("No se ha seleccionado un directorio !!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // ESCRITURA EN FICHEROS

        Escribir.escribirNombres();

        // OBJETOS SERIALIZADOS

        Escribir.escribirObjeto();
        Escribir.recuperarObjeto();

    }
}
