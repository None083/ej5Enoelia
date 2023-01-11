/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package supermercado;

/**
 *
 * @author Noelia
 */
public class Supermercado {

    public static void main(String[] args) {

        Producto p1 = new Producto("Chocolate", 1, 2.5, IVA.B);
        Producto p2 = new Producto("Harina   ", 1, 2, IVA.B);
        Producto p3 = new Producto("Azúcar   ", 1, 1.5, IVA.B);
        Producto p4 = new Producto("Huevos   ", 1, 6.75, IVA.B);
        Producto p5 = new Producto("Papel    ", 1, 1.5, IVA.A);
        Producto p6 = new Producto("Molde    ", 3, 2.75, IVA.C);
        Producto p7 = new Producto("Vainilla ", 1, 2.5, IVA.B);

        Cinta c1 = new Cinta();

        c1.aniadirProducto(p1);
        c1.aniadirProducto(p2);
        c1.aniadirProducto(p3);
        c1.aniadirProducto(p4);
        c1.aniadirProducto(p5);
        c1.aniadirProducto(p6);
        c1.aniadirProducto(p7);
        //c1.borrarProducto(p1);
        Ticket t1 = generarTicket(c1);

        System.out.println(t1);

    }

    private static Ticket generarTicket(Cinta c) {
        return c.crearTicket();
    }

}
