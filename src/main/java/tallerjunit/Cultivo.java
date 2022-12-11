package tallerjunit;

public class Cultivo {
    public double calcularConsumo(double area, char tipo) throws Exception{

        double cantidadAgua = 0;

        if ((tipo != 't' && tipo != 'h') || area < 0) {
            throw new Exception();
        } 

        if (tipo == 't') {
            cantidadAgua = area * 0.5;
        }

        if (tipo == 'h') {
            cantidadAgua = area * 0.25;
        }

        return cantidadAgua;
    }
}
