package edu.hagarbo.xmlfiles;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.time.LocalDate;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

public class Util {

    public double calcularMedia(String xmlFile) {
        try {
            JAXBContext context = JAXBContext.newInstance(Almacen.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            File file = new File(xmlFile);
            Almacen almacen = (Almacen) unmarshaller.unmarshal(file);
            Double media = almacen.getProductos().stream().map(Producto::getPrecioSalida)
                    .mapToDouble(Double::parseDouble).average().orElse(0);
            return media;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public void fromTxtToXml(String txtFile, String xmlFile) {
        Almacen miAlmacen = this.readFromTxt(txtFile);
        if (miAlmacen != null) {
            this.createXml(xmlFile, miAlmacen);
        }
    }

    private void createXml(String xmlFile, Almacen almacen) {

        try {
            // Se crea el contexto
            JAXBContext context = JAXBContext.newInstance(Almacen.class);
            // Se crea el serializador
            Marshaller marshaller = context.createMarshaller();

            // Indicamos que introduzca el contenido en el documento con indentaciones
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            marshaller.marshal(almacen, new File(xmlFile));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private Almacen readFromTxt(String txtFile) {
        try (FileReader fileReader = new FileReader(txtFile)) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String cabecera = bufferedReader.readLine();
            Almacen miAlmacen = this.procesarEmpresa(cabecera);
            String linea;
            while ((linea = bufferedReader.readLine()) != null) {
                Producto producto = this.procesarProducto(linea);
                if (producto != null)
                    miAlmacen.addProduct(producto);
            }
            System.out.println(miAlmacen.toString());
            return miAlmacen;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private Almacen procesarEmpresa(String datosEmpresa) {
        try {
            String[] datos = datosEmpresa.split("/");
            String nombre = datos[0].trim(), cif = datos[1].trim(), ubicacion = datos[2].trim();
            return new Almacen(nombre, cif, ubicacion);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    private Producto procesarProducto(String datosProducto) {
        try {
            String[] datos = datosProducto.split("/");
            String nombre = datos[1].trim(), marca = datos[2].trim(), id = datos[0].trim(), precio = datos[3].trim();
            Producto producto = new Producto(id, nombre, marca, precio);
            if (datos.length == 5) {
                LocalDate caducidad = LocalDate.parse(datos[4].trim());
                producto.setFechaCaducidad(caducidad);
            }
            return producto;
        } catch (Exception e) {
            System.out.println("Error procesando producto, linea ignorada");
            System.out.println(e.getMessage());
            return null;
        }

    }
}
