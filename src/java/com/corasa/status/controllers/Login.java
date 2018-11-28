/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.corasa.status.controllers;

import com.corasa.auth.entidades.Usuario;
import com.corasa.auth.entidades.UsuarioConsulta;
import com.corasa.auth.ldap.LdapAuthenticated;
import com.corasa.clientes.entidades.AbstractService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author HCastillo
 */
//@Stateless
@Path("/login")
public class Login extends AbstractService {
 
    @POST
    //@Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response authenticate(UsuarioConsulta usu) throws Exception {
        LdapAuthenticated ld = new LdapAuthenticated();
        Usuario usuRet =  ld.validate(usu.getSzUsuario(), usu.getSzPassword());
        
        if(usuRet.isbValid()) {
            String KEY = "$WDESDAG&%";
            long tiempo = System.currentTimeMillis();
            String jwt = Jwts.builder()
                            .signWith(SignatureAlgorithm.HS256, KEY)
                            .setSubject(usuRet.getUserPrincipalName())
                    .setIssuedAt( new Date(tiempo))
                    .setExpiration(new Date(tiempo+900000))
                    .claim("email" , usuRet.getEmail())
                    .compact();
                    
            usuRet.setToken(jwt);
            
           // JsonObject json = Json.createObjectBuilder()       
                          //    .add("").build();
            
            
                              
            
            return Response.status(Response.Status.CREATED).entity(usuRet).build();
            
        }
        
        JsonObject json = Json.createObjectBuilder()
                              .add("Message", "Datos Incorrectos")
                              .build();
        
        return Response.status(Response.Status.UNAUTHORIZED)
                                .entity(json).build();
    }
    
}





