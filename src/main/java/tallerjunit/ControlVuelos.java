package tallerjunit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.parser.ParseException;

import tallerjunit.Models.*;

public class ControlVuelos {
    private LectorArchivo lector;

    public ControlVuelos() {
        this.lector = new LectorArchivo();
    }

    /**
     * Nos devuelve todos los vuelos directos y con una
     * escala que hay entre una ciudad y otra
     * @param origen ciudad de partida
     * @param destino ciudad de llegada
     * @return todos los vuelos posibles con o sin escala entre el origen y
     * y el destino dados
     * @throws IOException si no lee bien el archivo
     * @throws ParseException si hay errores en los datos del JSON
     */

    public List<Vuelo> buscarRutas(String origen, String destino) throws IOException, ParseException {
        List<Ruta> rutas = this.lector.leer("rutas.json");

        List<Vuelo> vuelos = new ArrayList<Vuelo>();

        List<Vuelo> vuelosDirectos = buscarRutasDirectas(origen, destino, rutas);

        List<Vuelo> vuelosEscala = buscarRutasIndirectas(origen, destino, rutas);

        vuelos.addAll(vuelosEscala);
        vuelos.addAll(vuelosDirectos);

        return vuelos;
    }    

    /**
     * Busca los posibles vuelos directos entre una ciudad y otra
     * buscando entre la lista de rutas
     * @param origen ciudad de partida
     * @param destino ciudad de llegada
     * @param rutas lista de rutas
     * @return los posibles vuelos directos entre una ciudad y otra
     */
    public List<Vuelo> buscarRutasDirectas(String origen, String destino, List<Ruta> rutas) {

        List<Vuelo> vuelos = new ArrayList<Vuelo>();

        for (Ruta ruta : rutas) {
            if (ruta.getOrigen().equals(origen) && ruta.getDestino().equals(destino)) {
                Vuelo nuevoVuelo = new Vuelo(ruta.getOrigen(), ruta.getDestino(),false);
                nuevoVuelo.addRuta(ruta);
                vuelos.add(nuevoVuelo);
            }
        }

        return vuelos;
    }

    /**
     * Busca los posibles vuelos con una escala entre una ciudad y otra
     * buscando entre la lista de rutas
     * @param origen ciudad de partida
     * @param destino ciudad de llegada
     * @param rutas lista de rutas
     * @return los posibles vuelos con escala entre una ciudad y otra
     */

    public List<Vuelo> buscarRutasIndirectas(String origen, String destino, List<Ruta> rutas) {

        List<Ruta> rutasOrigen = buscarRutasOrigen(origen, rutas);
        List<Ruta> rutasDestino = buscarRutasDestino(destino, rutas);
        List<Vuelo> vuelos = new ArrayList<Vuelo>();

        for (Ruta rutaOrigen : rutasOrigen) {
            for (Ruta rutaDestino : rutasDestino) {
                if(rutaOrigen.getDestino().equals(rutaDestino.getOrigen())) {
                    Vuelo nuevoVuelo = new Vuelo(rutaOrigen.getOrigen(), rutaDestino.getDestino(), true);
                    nuevoVuelo.addRuta(rutaOrigen);
                    nuevoVuelo.addRuta(rutaDestino);
                    vuelos.add(nuevoVuelo);
                }
            }
        }

        return vuelos;
    }

    public List<Ruta> buscarRutasOrigen(String origen, List<Ruta> rutas) {
        List<Ruta> rutasOrigen = new ArrayList<Ruta>();

        for (Ruta ruta : rutas) {
            if (ruta.getOrigen().equals(origen)) {
                rutasOrigen.add(ruta);
            }
        }

        return rutasOrigen;
    }

    public List<Ruta> buscarRutasDestino(String destino, List<Ruta> rutas) {
        List<Ruta> rutasDestino = new ArrayList<Ruta>();

        for (Ruta ruta : rutas) {
            if (ruta.getDestino().equals(destino)) {
                rutasDestino.add(ruta);
            }
        }

        return rutasDestino;
    }
}
