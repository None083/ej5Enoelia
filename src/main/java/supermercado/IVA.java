/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package supermercado;

/**
 *
 * @author Noelia
 */
public enum IVA {
    A(4) ,B(10) ,C(21);
    private int iva;

    public int getIva() {
        return iva;
    }
    private IVA(int iva){
        this.iva=iva;
    }
    
}
