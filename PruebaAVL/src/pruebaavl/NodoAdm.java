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
public class NodoAdm {
   
    

    //miembros de acceso
    NodoAdm nodoizquierdo;
    String datos;
    NodoAdm nododerecho;

    //iniciar dato y hacer de este nodo un nodo hoja
    public NodoAdm(String datosNodo)
    {
        datos = datosNodo;
        nodoizquierdo = nododerecho = null; //el nodo no tiene hijos
    }

    //buscar punto de insercion  e insertar nodo nuevo
    public synchronized void insertar(String valorInsertar)
    {
        //insertar en subarbol izquierdo
        if (valorInsertar.length() <= datos.length()){

            //inserta nuevo nodoarbol
            if (nodoizquierdo == null)
                nodoizquierdo = new NodoAdm(valorInsertar);
            else //continua recorriendo subarbol izquierdo
                nodoizquierdo.insertar(valorInsertar);
        }

        //insertar nodo derecho
        else if(valorInsertar.length() > datos.length()){

            //insertar nuevo nodoarbol
            if (nododerecho == null)
                nododerecho = new NodoAdm(valorInsertar);
            else //continua recorriendo subarbol derecho
                nododerecho.insertar(valorInsertar);
        }
    } //fin del metodo insertar

} //fin clase nodoarbol
    
   

