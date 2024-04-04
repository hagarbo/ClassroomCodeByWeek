import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        String dir = ".";
        File file = new File(dir);
        System.out.println(file.getAbsolutePath());

        try {
            if (file.isDirectory()) {
                System.out.println("LISTADO DE ARCHIVOS::");
                File[] archivos = file.listFiles(new FilenameFilter() {
                    public boolean accept(File dir, String name) {
                        return name.toLowerCase().endsWith("java");
                    }
                });

                Arrays.stream(archivos).forEach(f -> System.out.println(f.getName()));

            } else
                System.out.println("No se ha seleccionado un directorio !!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
