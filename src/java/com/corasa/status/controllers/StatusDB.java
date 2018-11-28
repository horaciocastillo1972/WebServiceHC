/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.corasa.status.controllers;

import com.corasa.clientes.entidades.AbstractService;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author HCastillo
 */
//@Stateless
@Path("/status")
public class StatusDB extends AbstractService {
    
    
      @Context
    private UriInfo context;

    /**
     * Creates a new instance of StatusDB
     */
    public StatusDB() {
    }

    
    private static final String api_version = "00.01.00"; 
    
    /**
     * Retrieves representation of an instance of com.hc.WS.Rest.status.StatusDB
     * @return an instance of java.lang.String
     */
    
        
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getTitle() {
        //TODO return proper representation object
        return "<h4> Java Web Service - (c)Horacio Castillo.<h4>";
    }
    
    @Path("/version")
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getVersion() {
        //TODO return proper representation object
        return "<h4>Version: </h4>" + api_version;
    }

    @Path("/database")
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getStatusDb() throws Exception{
        //TODO return proper representation object
        return super.statusDb();
    }
    
}
