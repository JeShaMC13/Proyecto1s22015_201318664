<%-- 
    Document   : index
    Created on : 15-sep-2015, 17:16:24
    Author     : Jenny
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login usuario</title>
    </head>
    <body>
        <h1 style="text-align: center;">Login</h1>
           <form action="Autentificar" method="POST">
               <table border="0" style="margin-left: 28%;"  >
                   <thead>
 <tr>
                       </tr>
                           <th style="text-align: center;"><select name="opciones">
                                   <option>Administradore</option>
                                   <option>Chofer</option>
                               </select></th>

                       <tr>
                           <th>Correo:</th>
                           <th><input type="text" name="txtCorreo" value="" /></th>
                       </tr>
                   </thead>
                   <tbody>
                       <tr>
                           <td>Contrasenia:</td>
                           <td><input type="password" name="txtContra" value="" /></td>
                       </tr>
                       <tr>
                           <td><input type="submit" value="ingreso" name="btnIngreso" /></td>
                       </tr>
                       <tr>
                           <td></td>
                           <td></td>
                       </tr>
                   </tbody>
               </table>

           </form>
    </body>
</html>
