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
    private Cinta cinta;

    public Caja() {
        contador++;
        this.identificador = contador;
        this.cinta = new Cinta();
    }

}
