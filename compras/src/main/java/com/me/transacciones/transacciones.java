/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/EjbWebService.java to edit this template
 */
package com.me.transacciones;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

/**
 *
 * @author Thomas
 */
@WebService(serviceName = "transacciones")
@Stateless()
public class transacciones {
    
    public static String [][]datos_banco={{"123456789","987654321"},{"123","321"},{"Julio","Thomas"},{"500","50"}};//tarjeta,cvv,nombre,dinero en cuenta
    public static Integer [][]productos={{10,15},{50,40}};// id,cantidad

    /**
     * This is a sample web service operation
     */
    /**
     * Web service operation
     */
    @WebMethod(operationName = "Pagar")
    public Boolean Pagar(@WebParam(name = "numero_tarjeta") String numero_tarjeta, @WebParam(name = "nombre_usuario") String nombre_usuario, @WebParam(name = "codigo_cvv") int codigo_cvv, @WebParam(name = "monto") int monto) {
        boolean flag=false;
        int i = 0;
       
        
        for(i=0;i<datos_banco.length;i++){
            if(datos_banco[0][i].equals(numero_tarjeta)&&datos_banco[1][i].equals(String.valueOf(codigo_cvv))&&datos_banco[2][i].equals(nombre_usuario)){
                flag=true;
                break;
            } 
        }
        if(flag==false)
            return false;
      //Verificar dinero y cambiarlo en la cuenta
        int dinero_en_cuenta=Integer.parseInt(datos_banco[3][i]);
        if(dinero_en_cuenta>=monto){
            dinero_en_cuenta=dinero_en_cuenta-monto;
            datos_banco[3][i]=String.valueOf(dinero_en_cuenta);
            return true;
        }else{
            return false;
        }
        
    }
    /**
     * Web service operation
     */
    @WebMethod(operationName = "Comprar")
    public Boolean Comprar(@WebParam(name = "id_producto") int id_producto, @WebParam(name = "precio") int precio, @WebParam(name = "numero_productos") int numero_productos, @WebParam(name = "total") int total) {
        int i=0;
        boolean flag=false;
        
        for(i=0;i<productos[0].length;i++)
            if(productos[0][i]==id_producto){
                flag=true;
                break;
            }

        if(productos[1][i]<numero_productos || flag==false)
            return false;

        int monto_a_pagar=precio*numero_productos;
        
        if(monto_a_pagar>total)
            return false;
        else
            productos[1][i]=productos[1][i]-numero_productos;
        
            
        
        return true;
    }
}
