/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermercado;

import java.util.ArrayList;

/**
 *
 * @author noelia
 */
public class Cinta {

    private ArrayList<Producto> compra;

    public Cinta() {
        this.compra = new ArrayList<>();
    }

    public ArrayList<Producto> getCompra() {
        return compra;
    }

    public void aniadirProducto(Producto p) {
        this.compra.add(p);
    }

    public void borrarProducto(Producto p) {
        this.compra.remove(p);
    }

    public boolean estaVacia() {
        return this.compra.isEmpty();
    }

    public Ticket crearTicket() {
        return new Ticket(this);
    }

}
