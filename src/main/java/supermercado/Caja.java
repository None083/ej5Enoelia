/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermercado;

import java.util.ArrayList;

/**
 *
 * @author Noelia
 */
public class Caja {

    private static int contador = 0;
    private int identificador;
    private ArrayList<Producto> cinta;

    public Caja() {
        contador++;
        this.identificador = contador;
        this.cinta = new ArrayList<>();
    }

    public void aniadirProducto(Producto p) {
        this.cinta.add(p);
    }

    public void borrarProducto(Producto p) {
        this.cinta.remove(p);
    }

    public boolean estaVacia() {
        return this.cinta.isEmpty();
    }
    
    public Ticket crearTicket(){
        return new Ticket(this.cinta);
    }

}
