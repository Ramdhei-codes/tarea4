package tallerjunit;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import tallerjunit.Models.Ruta;

public class LectorArchivo {
    public List<Ruta> leer(String ruta) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        List<Ruta> listaRutas = new ArrayList<Ruta>();

        FileReader lector = new FileReader(ruta);

        Object objRutas = parser.parse(lector);

        JSONArray rutas = (JSONArray) objRutas;

        for (int i = 0; i < rutas.size(); i++) {
            JSONObject rutaActual = (JSONObject) rutas.get(i);

            String origen = (String) rutaActual.get("origen");
            String destino = (String) rutaActual.get("destino");
            double duracion = ((Number) rutaActual.get("duracion")).doubleValue();
            double precio = ((Number) rutaActual.get("precio")).doubleValue();

            listaRutas.add(new Ruta(origen, destino, duracion, precio));
        }

        return listaRutas;
    }
}
