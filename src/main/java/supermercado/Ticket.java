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

    public Ticket(Cinta cinta) {
        this.compra = cinta;
        this.fecha = LocalDateTime.now();
        for (Producto p : cinta.getCompra()) {
            double precioSinIva = p.precio() * p.cantidad();
            double impuestoDelProducto = (precioSinIva * p.iva().getIva()) / 100;
            this.totalAPagar += precioSinIva + impuestoDelProducto;
        }
    }

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

        for (Producto p : compra) {
            ticket += """
                      %s     %.2f     %d     %d%%     %.2f
                      """.formatted(p.nombre(), p.precio(), p.cantidad(),
                    p.iva().getIva(), (p.precio() * p.cantidad()));
        }
        ticket += "------------------------------------------------------------------\n";

        int productosA = 0;
        double precioSinIvaA = 0;
        double precioConIvaA = 0;
        int productosB = 0;
        double precioSinIvaB = 0;
        double precioConIvaB = 0;
        int productosC = 0;
        double precioSinIvaC = 0;
        double precioConIvaC = 0;
        for (Producto p : compra) {

            if (p.iva() == IVA.A) {
                productosA += p.cantidad();
                precioSinIvaA += p.precio() * p.cantidad();
                precioConIvaA = precioSinIvaA + (precioSinIvaA * IVA.A.getIva() / 100);
            } else if (p.iva() == IVA.B) {
                productosB += p.cantidad();
                precioSinIvaB += p.precio() * p.cantidad();
                precioConIvaB = precioSinIvaB + (precioSinIvaB * IVA.B.getIva() / 100);
            } else {
                productosC += p.cantidad();
                precioSinIvaC += p.precio() * p.cantidad();
                precioConIvaC = precioSinIvaC + (precioSinIvaC * IVA.C.getIva() / 100);
            }

        }

        ticket += """
                  Nº prod. iva 4%%:  %d   Precio sin IVA: %.2f  Precio con IVA: %.2f
                  Nº prod. iva 10%%: %d   Precio sin IVA: %.2f  Precio con IVA: %.2f
                  Nº prod. iva 21%%: %d   Precio sin IVA: %.2f  Precio con IVA: %.2f
                  ------------------------------------------------------------------
                  Total a pagar: %.2f -- Gracias por su visita
                  ------------------------------------------------------------------
                  """.formatted(productosA, precioSinIvaA, precioConIvaA,
                productosB, precioSinIvaB, precioConIvaB,
                productosC, precioSinIvaC, precioConIvaC,
                this.totalAPagar);

        return ticket;
    }

}
