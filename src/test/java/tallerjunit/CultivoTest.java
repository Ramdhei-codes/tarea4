package tallerjunit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class CultivoTest {

    @Test
    void consumoTradicional() throws Exception{
        Cultivo cultivo = new Cultivo();

        double consumo = cultivo.calcularConsumo(50, 't');

        assertEquals(25, consumo);
    }

    @Test
    void consumoHidroponico() throws Exception{
        Cultivo cultivo = new Cultivo();

        double consumo = cultivo.calcularConsumo(50, 'h');

        assertEquals(12.5, consumo);
    }

    @Test
    void areaNegativa() throws Exception{
        Cultivo cultivo = new Cultivo();

        assertThrows(Exception.class, () -> cultivo.calcularConsumo(-50, 't')); 

        
    }

    @Test
    void tipoInexistente() throws Exception{
        Cultivo cultivo = new Cultivo();

        assertThrows(Exception.class, () -> cultivo.calcularConsumo(50, 'a')); 

        
    }
    
}
