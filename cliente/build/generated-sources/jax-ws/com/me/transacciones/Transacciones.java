
package com.me.transacciones;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * Eclipse Metro/2.4.8 (RELEASE-2.4.8-e044505; 2022-01-04T13:29:23+0000) JAXWS-RI/2.3.5 JAXWS-API/2.3.3 JAXB-RI/2.3.5 JAXB-API/2.3.3
 * Generated source version: 2.2
 * 
 */
@WebService(name = "transacciones", targetNamespace = "http://transacciones.me.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface Transacciones {


    /**
     * 
     * @param precio
     * @param total
     * @param numeroProductos
     * @param idProducto
     * @return
     *     returns java.lang.Boolean
     */
    @WebMethod(operationName = "Comprar")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "Comprar", targetNamespace = "http://transacciones.me.com/", className = "com.me.transacciones.Comprar")
    @ResponseWrapper(localName = "ComprarResponse", targetNamespace = "http://transacciones.me.com/", className = "com.me.transacciones.ComprarResponse")
    @Action(input = "http://transacciones.me.com/transacciones/ComprarRequest", output = "http://transacciones.me.com/transacciones/ComprarResponse")
    public Boolean comprar(
        @WebParam(name = "id_producto", targetNamespace = "")
        int idProducto,
        @WebParam(name = "precio", targetNamespace = "")
        int precio,
        @WebParam(name = "numero_productos", targetNamespace = "")
        int numeroProductos,
        @WebParam(name = "total", targetNamespace = "")
        int total);

    /**
     * 
     * @param monto
     * @param nombreUsuario
     * @param numeroTarjeta
     * @param codigoCvv
     * @return
     *     returns java.lang.Boolean
     */
    @WebMethod(operationName = "Pagar")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "Pagar", targetNamespace = "http://transacciones.me.com/", className = "com.me.transacciones.Pagar")
    @ResponseWrapper(localName = "PagarResponse", targetNamespace = "http://transacciones.me.com/", className = "com.me.transacciones.PagarResponse")
    @Action(input = "http://transacciones.me.com/transacciones/PagarRequest", output = "http://transacciones.me.com/transacciones/PagarResponse")
    public Boolean pagar(
        @WebParam(name = "numero_tarjeta", targetNamespace = "")
        String numeroTarjeta,
        @WebParam(name = "nombre_usuario", targetNamespace = "")
        String nombreUsuario,
        @WebParam(name = "codigo_cvv", targetNamespace = "")
        int codigoCvv,
        @WebParam(name = "monto", targetNamespace = "")
        int monto);

}
