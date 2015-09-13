package Administrador;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jenny
 */
public class ArbolAdmin {
   private NodoAdmin raiz;
   private NodoAdmin encontrado;
   private NodoAdmin grandf;  
   private int h=0;    
   private int altura;
   String cadena1="";
   String cadena2="";
    
    public ArbolAdmin()
    {
        this.raiz = null;
        this.grandf = null;
    }
    
  //=================Empieza metodo del arbol==================================
        
    public NodoAdmin insertar(NodoAdmin raiz,String cor, String contra)
    {
        NodoAdmin n1;
        if(raiz == null)
        {
            raiz = new NodoAdmin(cor, contra);
            if(this.raiz == null)
            {
                this.raiz = raiz;
            }
            h =1;
            return raiz;
        }
        else
        {
            //verificar si irse a la izquierda o derecha
            if(cor.compareTo(raiz.getCorreo()) < 0)
            {
                raiz.setHijoIzquierdo(insertar(raiz.getHijoIzquierdo(), cor, contra));
                //verificar equilibrio
                if(h == 1)
                {
                    switch(raiz.getFe())
                    {
                        case 1: raiz.setFe(0);
                                h = 0;
                                break;
                        case 0: raiz.setFe(-1);
                                break;
                        case -1:    n1 = raiz.getHijoIzquierdo();
                                    if(n1.getFe()==-1)
                                    {                                        
                                        raiz = rotacionII(raiz, n1);
                                        System.out.println("Rotacion II");
                                    }
                                    else
                                    {
                                        raiz = rotacionID(raiz, n1);
                                        System.out.println("Rotacion ID");
                                    }
                                    h = 0;
                                    break;
                    }//fin switch
                }//fin if
            }
            if(cor.compareTo(raiz.getCorreo()) > 0)
            {
                raiz.setHijoDerecho(insertar(raiz.getHijoDerecho(), cor, contra));
                //verificar equilibrio
                if(h == 1)
                {
                    switch(raiz.getFe())
                    {
                        case 1: n1 = raiz.getHijoDerecho();
                                if(n1.getFe()==1)
                                {
                                    System.out.println("ROtacion DD");
                                    raiz = rotacionDD(raiz, n1);
                                }
                                else
                                {
                                    raiz = rotacionDI(raiz, n1);
                                    System.out.println("Rotacion DI");
                                }
                                h = 0;                                
                                break;
                        case 0: raiz.setFe(1);                        
                                break;
                        case -1:    raiz.setFe(0);
                                    h = 0;
                                    break;                                    
                    }//fin switch
                }//fin if
            }
            if(cor.compareTo(raiz.getCorreo()) == 0)
            {
                insertar(raiz,cor,contra);
            }
            
        }//fin else
        return raiz;
    }
    
    //=================================Eliminar nodo==================================================================
     public NodoAdmin EliminarNodo(String correo,NodoAdmin raiz){
        if(raiz==null){
            System.out.println("no existe");
            altura = 0;
        }else{
            
            if(correo.compareTo(raiz.getCorreo()) < 0){
                raiz.setHijoIzquierdo( EliminarNodo(correo,raiz.getHijoIzquierdo()));
                if(altura!=0){
                    raiz = equilibrarIz(raiz);
                }
            }
            if(correo.compareTo(raiz.getCorreo()) > 0){
                raiz.setHijoDerecho( EliminarNodo(correo,raiz.getHijoDerecho()));
                if(altura!=0){
                    raiz = equilibrarDer(raiz);
                }
            }
            if(correo.equals(raiz.getCorreo())){
                NodoAdmin aux;
                aux = raiz;
                if(aux.getHijoIzquierdo()==null){
                    raiz = aux.getHijoDerecho();
                    altura = 1;
                }else if(aux.getHijoDerecho() == null){
                    raiz = aux.getHijoIzquierdo();
                    altura = 1;
                }else{
                    raiz.setHijoIzquierdo(reemplazar(raiz,raiz.getHijoIzquierdo()));
                    if(altura!=0){
                        raiz = equilibrarIz(raiz);
                    }
                    aux = null;
                }
            }
        }
        return raiz;
    }//fin metodo
    
  //=================================Equilibrar izquierda nodo==================================================================
    
    public NodoAdmin equilibrarIz(NodoAdmin n){
        NodoAdmin n1;
        switch(n.getFe()){
            case 1:
                n1 = n.getHijoDerecho();
                if(n1.getFe()>=0){
                    if(n1.getFe()==1){
                        n = rotacionDD(n,n1);
                    }
                    altura = 0;
                }else{
                    n = rotacionDI(n,n1);
                }
            break;
            case 0:
                n.setFe(1);        //deberia ser 1 xqe elimine un izquierdo[tenia -1]
                altura = 0;
            break;
            case -1:
                n.setFe(0);
            break;
        }
        return n;
    }//fin metodo
    
    //=================================Equilibrar derecha nodo==================================================================
    
    public NodoAdmin equilibrarDer(NodoAdmin n){
        NodoAdmin n1;
        switch(n.getFe())
        {
            case 1:
                    n.setFe(0);
                    break;
            case 0:
                    n.setFe(-1);
                    altura = 0;
                    break;
            case -1:
                    n1 = n.getHijoIzquierdo();
                    if(n1.getFe()<=0)
                    {
                        if(n1.getFe()==-1)
                        {
                            n = rotacionII(n,n1);
                        }
                        altura = 0;
                    }
                    else
                    {
                        n = rotacionID(n,n1);
                    }
            break;
         }
        return n;
    }//fin metodo
    
    
    //=================================Remplazar nodo==================================================================
    
    public NodoAdmin reemplazar(NodoAdmin n, NodoAdmin actual){
        if(actual.getHijoDerecho() != null){
            actual.setHijoDerecho(reemplazar(n,actual.getHijoDerecho()));
            if(altura!=0){
                actual = equilibrarDer(actual);
            }
        }else{            
            n.setCorreo(actual.getCorreo());
            n.setContrasenia(actual.getContrasenia());
            n = actual;
            actual = actual.getHijoIzquierdo();
            altura = 1;
            
        }
        return actual;
    }//fin metodo
    
    
    
    public NodoAdmin found(NodoAdmin raiz,String correo)
    {
        buscar2(raiz,correo);
        return this.encontrado;
    }
    
    
  //=================================Buscar nodo==================================================================
    
    public void buscar2(NodoAdmin raiz,String correo)
    {
        if(raiz != null)
        {
            buscar2(raiz.getHijoIzquierdo(),correo);
            System.out.println("Estoy buscando ... "+raiz.getCorreo());
            if(raiz.getCorreo().equals(correo))
            {
                encontrado = raiz;
            }
            buscar2(raiz.getHijoDerecho(),correo);
        }
    }
    
    //=================================Buscar nodo==================================================================
    
    public void buscar(NodoAdmin raiz,String cor, String contra)
    {
        if(raiz != null)
        {
            buscar(raiz.getHijoIzquierdo(),cor, contra);
            System.out.println("Estoy buscando ... "+raiz.getCorreo());
            if(raiz.getCorreo().equals(cor) && raiz.getContrasenia().equals(contra))
            {
                encontrado = raiz;
            }
            buscar(raiz.getHijoDerecho(),cor,contra);
        }
    }
    
    //=================================Reemplazar nodo==================================================================
    
    
    public void remplazar(NodoAdmin raiz,String Correo, String Contrasenia)
    {
        if(raiz != null)
        {
            remplazar(raiz.getHijoIzquierdo(), Correo, Contrasenia);
            System.out.println("Estoy buscando ... "+raiz.getCorreo());
            if(raiz.getCorreo().equals(Correo) )
            {
                raiz.setCorreo(Correo);
                raiz.setContrasenia(Contrasenia);
            }
            remplazar(raiz.getHijoDerecho(),Correo,Contrasenia);
        }
    }
    //================================ROTACION ARBOL AVL=================================================
     
    //=================================Rotacion izquierda-izquierda==================================================================
    
    public  NodoAdmin rotacionII( NodoAdmin n, NodoAdmin n1)
    {
        n.setHijoIzquierdo(n1.getHijoDerecho());
        n1.setHijoDerecho(n);
        if(n1.getFe()== -1)
        {
            n.setFe(0);
            n1.setFe(0);            
        }
        else
        {
            n.setFe(-1);
            n1.setFe(1);            
        }
        n = n1;
        return n1;
    }
    
    //=================================Rotacion derecha-derecha==================================================================
    
    public NodoAdmin rotacionDD(NodoAdmin n,NodoAdmin n1)
    {
        n.setHijoDerecho(n1.getHijoIzquierdo());
        n1.setHijoIzquierdo(n);
        if(n1.getFe()==1)
        {
            n.setFe(0);
            n1.setFe(0);
        }
        else
        {
            n.setFe(1);
            n1.setFe(-1);
        }
        n = n1;
        
        return n;
    }
    
    //=================================Rotacion izquierda-derecha==================================================================
    
    public NodoAdmin rotacionID(NodoAdmin n, NodoAdmin n1)
    {
        NodoAdmin n2;
        n2 = n1.getHijoDerecho();
        n.setHijoIzquierdo(n2.getHijoDerecho());
        n2.setHijoDerecho(n);
        n1.setHijoDerecho(n2.getHijoIzquierdo());
        n2.setHijoIzquierdo(n1);
        if(n2.getFe()==1)
        {
            n1.setFe(-1);
        }
        else
        {
            n1.setFe(0);
        } 
        if(n2.getFe()==-1)
        {
            n.setFe(1);
        }
        else
        {
            n.setFe(0);
        }
        n2.setFe(0);
        n = n2;
        return n;
    }
    
    //=================================Rotacion derecha-izquierda==================================================================
    
    
    public NodoAdmin rotacionDI(NodoAdmin n , NodoAdmin n1)
    {
        NodoAdmin n2;
        n2 = n1.getHijoIzquierdo();
        n.setHijoDerecho(n2.getHijoIzquierdo());
        n2.setHijoIzquierdo(n);
        n1.setHijoIzquierdo(n2.getHijoDerecho());
        n2.setHijoDerecho(n1);
        if(n2.getFe()==1)
        {
            n.setFe(-1);
        }
        else
        {
            n.setFe(0);
        }
        if(n2.getFe()==-1)
        {
            n1.setFe(1);
        }
        else
        {
            n1.setFe(0);
        }
            
        n2.setFe(0);
        n=n2;
        return n;
    }
 
  
    
    
    public NodoAdmin getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoAdmin raiz) {
        this.raiz = raiz;
    }
    
    
    
}
