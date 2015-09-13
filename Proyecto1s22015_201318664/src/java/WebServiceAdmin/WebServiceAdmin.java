/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebServiceAdmin;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

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
        //TODO write your implementation code here:
        return null;
    }
}
