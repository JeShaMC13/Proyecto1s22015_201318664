/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jenny
 */
public class NodoAdmin {
  private String correo;
  private String contrasenia;
  private int fe;
  NodoAdmin hijoIzquierdo;
  NodoAdmin hijoDerecho;
  
   
   public NodoAdmin(String cor, String contra){
       this.correo= cor;
       this.contrasenia= contra;
       this.fe = 0;
       this.hijoDerecho = null;
       this.hijoIzquierdo = null;
       
   }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setFe(int fe) {
        this.fe = fe;
    }

    public void setHijoIzquierdo(NodoAdmin hijoIzquierdo) {
        this.hijoIzquierdo = hijoIzquierdo;
    }

    public void setHijoDerecho(NodoAdmin hijoDerecho) {
        this.hijoDerecho = hijoDerecho;
    }

    public String getCorreo() {
        return correo;
    }

    public int getFe() {
        return fe;
    }

    public NodoAdmin getHijoIzquierdo() {
        return hijoIzquierdo;
    }

    public NodoAdmin getHijoDerecho() {
        return hijoDerecho;
    }
    
   
   
}
