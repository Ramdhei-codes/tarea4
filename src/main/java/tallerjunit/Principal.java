package tallerjunit;

import java.io.IOException;

import org.json.simple.parser.ParseException;

public class Principal {
    public static void main(String[] args) {
        PantallaVuelos pantalla = new PantallaVuelos();

        try {
            pantalla.mostrarVuelos();
        } catch (ParseException exception) {
            System.out.println("Error al leer los datos del archivo");
        } catch(IOException exception){
            System.out.println("Archivo no válido");
        }
        
    }
}
