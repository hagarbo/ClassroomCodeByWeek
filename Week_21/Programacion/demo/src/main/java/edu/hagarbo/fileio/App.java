package edu.hagarbo.fileio;

import java.io.File;
import java.nio.file.Files;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
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
            // 3) Escribir un programa Java para comprobar si existe o no un archivo o
            // directorio especificado por ruta.
            if (file.exists())
                System.out.println("PIENSO LUEGO EXISTO");
            // 4) Escribir un programa Java para comprobar si un archivo o directorio tiene
            // permiso de lectura y escritura.
            if (file.canRead())
                System.out.println("TENGO PERMISOS DE LECTURA ");
            if (file.canWrite())
                System.out.println("TENGO PERMISOS DE ESCRITURA");
            // 5) Escribir un programa Java para comprobar si el nombre de una ruta dada es
            // un directorio o un archivo.
            if (file.isDirectory()) {
                System.out.println("\n LISTADO DE ARCHIVOS \n");
                /*
                 * File[] archivos = file.listFiles(new FilenameFilter() {
                 * public boolean accept(File dir, String name) {
                 * return name.toLowerCase().endsWith("xml");
                 * }
                 * });
                 */
                // 1) Escribir un programa Java para obtener una lista de todos los nombres de
                // archivos / directorios de una carpeta especificada.
                File[] archivos = file.listFiles();
                // 2) Escribir un programa Java para obtener archivos de una extensión
                // específica dentro de una carpeta proporcionada.
                Arrays.stream(archivos)
                        .map(File::getName)
                        .filter(f -> f.toLowerCase().endsWith(extension))
                        .forEach(System.out::println);

            } else
                System.out.println("No se ha seleccionado un directorio !!");

            // 6) Escribir un programa Java para obtener la última hora de modificación de
            // un archivo.
            System.out.println(
                    LocalDateTime.ofInstant(Instant.ofEpochMilli(file.lastModified()), ZoneId.systemDefault()));
            // 7) Escribir un programa Java para obtener el tamaño del archivo en bytes y
            // KB.
            System.out.println(file.length() + "bytes, " + file.length() / 1000 + "Kb");

            // 8) Programa que cree una carpeta en una ruta especificada, y dos archivos en
            // dicha carpeta. A continuación listar sus nombres y eliminar uno de ellos.
            File carpeta = new File(".", "carpeta");
            carpeta.mkdir();
            File fichero1 = new File("./carpeta/fichero1.txt");
            File fichero2 = new File("./carpeta/fichero2.txt");
            fichero1.createNewFile();
            fichero2.createNewFile();
            System.out.println(fichero1.getAbsolutePath());
            System.out.println(fichero2.getAbsolutePath());
            fichero2.delete();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // ESCRITURA EN FICHEROS

        Escribir.escribirNombres();

        // OBJETOS SERIALIZADOS

        Escribir.escribirObjeto();
        Escribir.recuperarObjeto();

        Escribir.randomAccess();

    }
}
