
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import Administrador.ArbolAdmin;
import Administrador.NodoAdmin;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jenny
 */
public class Login {
        
ArbolAdmin  arbol = new ArbolAdmin();

    
    public void Login(){
    
        if(arbol.raiz != null)
        {
            arbol.setEnco(false);
            System.out.println("Si haay usuarios la raiz es: "+arbol.raiz.getNombre());
            arbol.buscarEnArbol(arbol.raiz, getUsuario(),getPassword());
            boolean reci = arbol.isEnco();
            if(reci == true)
            {
                String adonde="";
                if(arbol.getEste().getTipo().equals("administrador"))
                {
                    adonde = "Administrador";
                }
                if(arbol.getEste().getTipo().equals("vendedor"))
                {
                    adonde = "Vendedor";
                }                
                if(arbol.getEste().getTipo().equals("agencia"))
                {
                    adonde = "Normal";
                }
                System.out.println("loggeo correcto");
                FacesContext context = FacesContext.getCurrentInstance();         
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Logeo Correcto",  "Bienvenido "+getUsuario()) );            
                
                
                return adonde;
            }
            else
            {
                if(!usuario.equals("admin") && !password.equals("admin"))
                {
                    FacesContext context = FacesContext.getCurrentInstance();         
                    context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error" ,"Usuario y/O Contrasena incorrectos") );            
                    System.out.println("Usuario o contra incorrectos");
                    setUsuario("");
                    setPassword("");
                    return "index";
                }
                else
                {
                    FacesContext context = FacesContext.getCurrentInstance();         
                    context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Logeo Correcto",  "Bienvenido "+getUsuario()) );            
                    System.out.println("loggeo administrador correcto");
                    setUsuario("");
                    setPassword("");
                    return "Administrador";
                }
                
            }
            
        }
        else
        {
            System.out.println("no hay mas usuarios y entro a administrador");
            if(usuario.equals("admin") && password.equals("admin") )
            {
                //httpServletRequest.getSession().setAttribute("sesionUsuario",usuario);
                //facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO,"Bienvenido: "+usuario,null);
                //facesContext.addMessage(null, facesMessage);      
                FacesContext context = FacesContext.getCurrentInstance();         
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Logeo Correcto",  "Bienvenido "+getUsuario()) );            
                System.out.println("loggeo administrador correcto");
                setUsuario("");
                setPassword("");
                return "Administrador";

            }
            else
            {
                ////facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Usuario/Contrasena incorrecto",null);
                //facesContext.addMessage(null, facesMessage);  
                ////ErrorContrasena();
                FacesContext context = FacesContext.getCurrentInstance();         
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error" ,"Usuario y/O Contrasena incorrectos") );            
                System.out.println("loggeo administrador incorrecto");
                setUsuario("");
                setPassword("");
                return "index";
            }                     
        }//fin else
        
                
    }//fin metodo
    
    public String cerrarSession()
    {
        return "index";
    }
    
//************************************* Subir Archivo *****************//
    public void TransferFile(String fileName, InputStream in)
    {
        try
        {
            OutputStream out = new FileOutputStream(new File(destination+fileName));
            int reader=0;
            byte[] bytes = new byte[(int)getFile().getSize()];
            while((reader = in.read(bytes)) != -1)
            {
                out.write(bytes,0,reader);
                //archivo = archivo + bytes;
            }
            in.close();
            out.flush();
            out.close();
        }catch(IOException e)
        {
            System.out.println(e.getMessage());
        
        }
    
    
    }
            
                
        
}
