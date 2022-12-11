package tallerjunit;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import org.json.simple.parser.ParseException;

import tallerjunit.Models.Vuelo;

public class PantallaVuelos {
    private ControlVuelos control;

    public PantallaVuelos(){
        this.control = new ControlVuelos();
    }

    public void mostrarVuelos() throws IOException, ParseException {
        Scanner consola = new Scanner(System.in);
        String respuesta = "S";
        while (respuesta.equals("S")) {
            System.out.println("¿Desea ver vuelos disponibles (S/N)?");
            respuesta = consola.nextLine();

            if (respuesta.equals("S")) {
                this.listarVuelosPosibles();
            }
        }
        System.out.println("Fin del programa. Muchas gracias.");
        consola.close();
    }

    private void listarVuelosPosibles() throws IOException, ParseException {
        Scanner consola = new Scanner(System.in);

        System.out.println("Ingrese el origen: ");
        String origen = "";
        origen = consola.next();

        System.out.println("Ingrese el destino: ");
        String destino = "";
        destino = consola.next();

        List<Vuelo> listaVuelosPosibles = this.control.buscarRutas(origen, destino);

        if (listaVuelosPosibles.size() == 0) {
            System.out.println("No hay vuelos entre esas ciudades");
        }

        for (Vuelo vuelo : listaVuelosPosibles) {
            System.out.println(vuelo.toString());
        }
    }
}
