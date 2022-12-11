package tallerjunit;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.hamcrest.collection.IsEmptyCollection;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tallerjunit.Models.*;

public class VuelosTest {

    private LectorArchivo lector;

    @BeforeEach
    void inicializarRutas() {
        lector = new LectorArchivo();

    }

    @Test
    void origenInexistente() throws IOException, ParseException {
        ControlVuelos control = new ControlVuelos();

        List<Vuelo> vuelos = control.buscarRutas("Washington", "Cartagena");

       assertTrue(vuelos.isEmpty());
    }

    @Test
    void destinoInexistente() throws IOException, ParseException {
        ControlVuelos control = new ControlVuelos();

        List<Vuelo> vuelos = control.buscarRutas("Manizales", "Paris");

       assertTrue(vuelos.isEmpty());
    }
    
}
