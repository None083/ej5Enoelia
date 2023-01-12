/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermercado;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author Noelia
 */
public class Ticket {

    private LocalDateTime fecha;
    private Cinta compra;
    private double totalAPagar;

    // Constructor
    public Ticket(Cinta cinta) {
        this.compra = cinta;
        this.fecha = LocalDateTime.now();
        // For each para calcular el total a pagar de los productos con sus ivas
        for (Producto p : cinta.getCompra()) {
            double precioSinIva = p.precio() * p.cantidad();
            double impuestoDelProducto = (precioSinIva * p.iva().getIva()) / 100;
            this.totalAPagar += precioSinIva + impuestoDelProducto;
        }
    }

    // En el to string voy montando el ticket con string en bloque
    @Override
    public String toString() {
        String ticket = """
                        ------------------------------------------------------------------
                                              Supermercados Copito
                        
                        Fecha: %s       Hora: %s
                        ------------------------------------------------------------------
                        Producto     Precio Cantidad IVA Precio sin IVA
                        ------------------------------------------------------------------
                        """.formatted(this.fecha.format(
                DateTimeFormatter.ofPattern("d/M/uuuu")),
                this.fecha.format(DateTimeFormatter.ofPattern("H:m")));

        // For each para ir añadiendo cada producto de la cinta al ticket
        for (Producto p : this.compra.getCompra()) {
            ticket += """
                      %s     %.2f     %d     %d%%     %.2f
                      """.formatted(p.nombre(), p.precio(), p.cantidad(),
                    p.iva().getIva(), (p.precio() * p.cantidad()));
        }
        ticket += "------------------------------------------------------------------\n";

        // Contadores para los productos y los ivas según su tipo
        int productosA = 0;
        double precioSinIvaA = 0;
        double precioConIvaA = 0;
        int productosB = 0;
        double precioSinIvaB = 0;
        double precioConIvaB = 0;
        int productosC = 0;
        double precioSinIvaC = 0;
        double precioConIvaC = 0;

        // For each para la parte final del ticket en la que se ven los precios
        // agrupados por tipo de iva
        for (Producto p : this.compra.getCompra()) {

            // Calculamos los ivas de cada producto por su tipo
            if (p.iva().equals(IVA.A)) {
                productosA += p.cantidad();
                precioSinIvaA += p.precio() * p.cantidad();
                precioConIvaA = precioSinIvaA + ((precioSinIvaA * IVA.A.getIva()) / 100);
            } else if (p.iva().equals(IVA.B)) {
                productosB += p.cantidad();
                precioSinIvaB += p.precio() * p.cantidad();
                precioConIvaB = precioSinIvaB + ((precioSinIvaB * IVA.B.getIva()) / 100);
            } else {
                productosC += p.cantidad();
                precioSinIvaC += p.precio() * p.cantidad();
                precioConIvaC = precioSinIvaC + ((precioSinIvaC * IVA.C.getIva()) / 100);
            }

        }

        ticket += """
                  Nº prod. iva 4%%:  %d   Precio sin IVA: %.2f  Precio con IVA: %.2f
                  Nº prod. iva 10%%: %d   Precio sin IVA: %.2f  Precio con IVA: %.2f
                  Nº prod. iva 21%%: %d   Precio sin IVA: %.2f  Precio con IVA: %.2f
                  ------------------------------------------------------------------
                  Total a pagar: %.2f€ -- Gracias por su visita
                  ------------------------------------------------------------------
                  """.formatted(productosA, precioSinIvaA, precioConIvaA,
                productosB, precioSinIvaB, precioConIvaB,
                productosC, precioSinIvaC, precioConIvaC,
                this.totalAPagar);

        return ticket;
    }

}
