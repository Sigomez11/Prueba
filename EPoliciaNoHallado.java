/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dptoPolicia;

/**
 *
 * @author sigoc
 */
public class EPoliciaNoHallado extends Exception{
    public EPoliciaNoHallado(){
        super("El policia no ha sido encontrado");
    }
}
