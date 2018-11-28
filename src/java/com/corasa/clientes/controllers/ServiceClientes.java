/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.corasa.clientes.controllers;

import com.corasa.clientes.entidades.AbstractService;
import com.corasa.clientes.entidades.OrganismoPublico;
import com.corasa.clientes.entidades.ParametroBusqueda;
import com.corasa.clientes.entidades.Persona;
import com.corasa.clientes.entidades.PersonaJuridica;
import com.corasa.clientes.entidades.PersonaJuridicaModificacion;
import com.corasa.clientes.entidades.PersonaModificacion;
import javax.ejb.Stateless;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 * 
 * @author HCastillo
 */
//@Stateless
@Path("/serviceclientes")
public class ServiceClientes extends AbstractService {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ServiceClientes
     */
    public ServiceClientes() {
    }

    /**
     * Retrieves representation of an instance of
     * com.corasa.clientes.controllers.ServiceClientes
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of ServiceClientes
     *
     * @param content representation for the resource Busqueda de cliente
     * habitual devuelve varios.
     */
    @POST
    @Path("/busquedacliente")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getClienteBuscados(ParametroBusqueda param) throws Exception {

        System.out.println(param.toString());

        if (param.getSzNis().isEmpty()
                && param.getSzTipoPermiso().isEmpty()
                && param.getSzApellido().isEmpty()
                && param.getSzNombre().isEmpty()
                && param.getSzRsocial().isEmpty()
                && param.getlNroDoc().isEmpty()
                && param.getSzCuit().isEmpty()
                && param.getSzTipoPersona().isEmpty()) {
            param.setSzMsj("No se ha enviado parametros para la busqueda.");

            return Response.status(400).entity(param).build();
        } else {
            return super.find(param);
        }
    }

    @GET
    @Path("/busquedaaltabaja")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    //obtener los parametros por anotacion @Context
    //http://localhost:8080/ServiceClientesHabituales/webresources/serviceclientes/busquedaaltabaja?szNombre=&szApellido=&lNroDoc=12146880&szRazonSocial=
    public Response getClienteAltaBaja(@Context UriInfo info) throws Exception {
        ParametroBusqueda param = new ParametroBusqueda();

        String szNombre = info.getQueryParameters().getFirst("szNombre");
        String szApellido = info.getQueryParameters().getFirst("szApellido");
        String lNroDoc = info.getQueryParameters().getFirst("lNroDoc");
        String szRazonSocial = info.getQueryParameters().getFirst("szRazonSocial");

        param.setSzNombre(szNombre);
        param.setSzApellido(szApellido);
        param.setlNroDoc(lNroDoc);
        param.setSzRsocial(szRazonSocial);

        if (param.getSzNombre().isEmpty()
                && param.getSzApellido().isEmpty()
                && param.getlNroDoc().isEmpty()
                && param.getSzRsocial().isEmpty()) {

            param.setSzMsj("No se ha enviado parametros para la busqueda.");
            return Response.status(400).entity(param).build();
        }
        return super.findAltaBaja(param);
    }

    //FN_BUSQ_Representados
    @GET
    @Path("/getrepresentados/{idCliente}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    //obtener los parametros por anotacion @Context
    //http://localhost:8080/ServiceClientesHabituales/webresources/serviceclientes/busquedaaltabaja?szNombre=&szApellido=&lNroDoc=12146880&szRazonSocial=
    public Response getClienteRepresentado(@PathParam("idCliente") Integer idCliente) throws Exception {
 
        return super.findRepresentados(idCliente);
    }

    //FN_BUSQ_Representantes
    @GET
    @Path("/getrepresentantes/{idCliente}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    //obtener los parametros por anotacion @Context
    //http://localhost:8080/ServiceClientesHabituales/webresources/serviceclientes/busquedaaltabaja?szNombre=&szApellido=&lNroDoc=12146880&szRazonSocial=
    public Response getClienteRepresentantes(@PathParam("idCliente") Integer idCliente) throws Exception {
 
        return super.findRepresentantes(idCliente);
    }

    
    //FN_Obtener_Cliente(P_clhDE_id CLH_DETALLE.clhDE_id%TYPE)RETURN MYCUR
    @GET
    @Path("/getcliente/{idCliente}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    //obtener los parametros por anotacion @Context
    //http://localhost:8080/ServiceClientesHabituales/webresources/serviceclientes/busquedaaltabaja?szNombre=&szApellido=&lNroDoc=12146880&szRazonSocial=
    public Response getCliente(@PathParam("idCliente") Integer idCliente) throws Exception {
 
            System.out.println("idCliente " + idCliente);
        return super.findCliente(idCliente);
        //return Response.ok().build();
    }
    
    @POST
    @Path("/altapj")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)    
    public Response altaPersonaJuridica(PersonaJuridica pj) throws Exception{
                
        
        return super.altaPersonaJuridica(pj);
    }    
 
        
    //SP_ALTA_Modificacion_OP
    @POST
    @Path("/amop")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)        
    public Response altaModOp(OrganismoPublico op) throws Exception {
        
        return super.altaModifOP(op);
    }
    
    //SP_ALTA_PERSONA
    
    @POST
    @Path("/altap")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)        
    public Response altaPersona(Persona p) throws Exception {
        
        return super.altaPersonas(p);
    }
    
    
    
    @POST
    @Path("/modperfi")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)        
    public Response modifPersonaFi(PersonaModificacion pm) throws Exception {
        return super.modificacionPersonasFisicas(pm);
    }
    
    @POST
    @Path("/modperju")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)        
    public Response modifPersonaJu(PersonaJuridicaModificacion mpj) throws Exception {
        return super.modificacionPersonasJu(mpj);
    }
        
    
    
    
}
