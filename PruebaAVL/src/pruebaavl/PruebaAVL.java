/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pruebaavl;

/**
 *
 * @author Jenny
 */
public class PruebaAVL {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArbolAdmin arbol = new ArbolAdmin();
        

        System.out.println( "Insertando los siguientes valores:"+ 
        "camino, abedul, estruendo, noche, dia, espejo, roca, dirimir,"+
        "ambulancia, hiperrealidad, amigo");

        arbol.insertarNodo("camino");
        arbol.insertarNodo("abedul");
        arbol.insertarNodo("estruendo");
        arbol.insertarNodo("noche");
        arbol.insertarNodo("dia");
        arbol.insertarNodo("espejo");
        arbol.insertarNodo("roca");
        arbol.insertarNodo("dirimir");
        arbol.insertarNodo("ambulancia");
        arbol.insertarNodo("hiperrealidad");
        arbol.insertarNodo("amigo");


        System.out.println("\n\nRecorrido preorden");
        arbol.recorridoPreorden();

        System.out.println("\n\nRecorrido inorden");
        arbol.recorridoInorden();

        System.out.println("\n\nRecorrido posorden");
        arbol.recorridoPosorden();
    }
    }
    

