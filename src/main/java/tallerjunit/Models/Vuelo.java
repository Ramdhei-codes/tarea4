package tallerjunit.Models;

import java.util.ArrayList;
import java.util.List;

public class Vuelo {
    private String origen;
    private String destino;
    private List<Ruta> rutas;
    private boolean escala;

    public Vuelo(String origen, String destino,boolean escala){
        this.escala = escala;
        this.origen = origen;
        this.destino = destino;
        this.rutas = new ArrayList<Ruta>();
    }

    
    public List<Ruta> getRutas() {
        return rutas;
    }
    public boolean getEscala()
    {
        return this.escala;
    }

    public void addRuta(Ruta ruta){
        this.rutas.add(ruta);
    }

    public void setEscala(boolean escala) {
        this.escala = escala;
    }

    public void setRutas(List<Ruta> rutas) {
        this.rutas = rutas;
    }

    public double calcularPrecio() {
        double precio = 0;

        for (Ruta ruta : this.rutas) {
            precio += ruta.getPrecio();
        }

        return precio;
    }

    public double calcularDuracion() {
        double duracion = 0;

        for (Ruta ruta : this.rutas) {
            duracion += ruta.getDuracion();
        }

        return duracion;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return String.format("Origen: %15s Destino: %15s Duración: %5f Precio: %8f Escala: %5s", origen, destino, calcularDuracion(), calcularPrecio(), escala);
    }
}
