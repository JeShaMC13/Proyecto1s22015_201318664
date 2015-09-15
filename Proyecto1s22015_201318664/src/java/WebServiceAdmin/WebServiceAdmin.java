/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebServiceAdmin;

import Administrador.ArbolAdmin;
import Administrador.NodoAdmin;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import Administrador. *;
/**
 *
 * @author Jenny
 */
@WebService(serviceName = "WebServiceAdmin")
public class WebServiceAdmin {


    /**
     * Web service operation
     */
    @WebMethod(operationName = "Login")
    public String Login(@WebParam(name = "Correo") String Correo, @WebParam(name = "Contrasena") String Contrasena) {
 
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "Registrar")
    public String Registrar(@WebParam(name = "Correo") String Correo, @WebParam(name = "Contrasenia") String Contrasenia) {
    ArbolAdmin agregar = new  ArbolAdmin();
    String datosObt = agregar.insertarDato(Correo, Contrasenia);
        return datosObt;
    }




}
