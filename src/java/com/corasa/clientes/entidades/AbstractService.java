/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.corasa.clientes.entidades;

import com.corasa.clientes.models.ClienteModelo;
import com.corasa.clientes.models.StatusModelo;
import java.util.List;
import javax.ws.rs.core.Response;

/**
 *
 * @author HCastillo
 */
public abstract class AbstractService  {

/*
    private Class<ClienteModelo> entityClass;

    public AbstractService(Class<ClienteModelo> entityClass) {
        this.entityClass = entityClass;
    }

  */  
    public String statusDb() throws Exception {
        StatusModelo sm = new StatusModelo();
        
            return sm.statusDBDAO();
    }

    public Response find(ParametroBusqueda param) throws Exception {
        ClienteModelo cm = new ClienteModelo();
        //(J) cm.getData((ParametroBusqueda) param);//getEntityManager().find(entityClass, id);
        return Response.ok(cm.getData((ParametroBusqueda) param)).build();
    }

    public Response findAltaBaja(ParametroBusqueda param) throws Exception {
        ClienteModelo cm = new ClienteModelo();
        //(J) cm.getData((ParametroBusqueda) param);//getEntityManager().find(entityClass, id);
        return Response.ok(cm.getDataAltaBaja((ParametroBusqueda) param)).build();
    }

    public Response findRepresentados(int idCliente) throws Exception {
        ClienteModelo cm = new ClienteModelo();
        
        List l = cm.getRepresentados(idCliente);
        
        if (l.isEmpty())
            return Response.status(Response.Status.NOT_FOUND).build();
        else           
            return Response.ok(l).build();
    }
    
    public Response findRepresentantes(int idCliente) throws Exception {
        ClienteModelo cm = new ClienteModelo();
        
        List l = cm.getRepresentantes(idCliente);
        
        if (l.isEmpty())
            return Response.status(Response.Status.NOT_FOUND).build();
        else           
            return Response.ok(l).build();
    }
    
    
    
    public Response LoginLdap(String szUsuario, String szPassword) {
            return Response.ok(true).build();
    }
    
    public Response findCliente(int idCliente) throws Exception {
        ClienteModelo cm = new ClienteModelo();
        
        List l = cm.getCliente(idCliente);
        
        if (l.isEmpty())
            return Response.status(Response.Status.NOT_FOUND).build();
        else           
            return Response.ok(l).build();

    }
    
    public Response altaPersonaJuridica(PersonaJuridica pj) throws Exception {
        ClienteModelo cm = new ClienteModelo();
        EntidadResponse er = cm.altaPersonaJuridica(pj);
//        if(er.isbIndError()) {
//            return Response.status(er.getError()).build();
//        }else{
//            return Response.ok(er).build();
//        }
//            
        return Response.ok(er).build();
    }
 
    public Response altaModifOP(OrganismoPublico op) throws Exception {
        ClienteModelo cm = new ClienteModelo();
        EntidadResponse er = cm.altaModifOP(op);
//        if(er.isbIndError()) {
//            return Response.status(er.getError()).build();
//        }else{
//            return Response.ok(er).build();
//        }
//            
        return Response.ok(er).build();
    }
    
     public Response altaPersonas(Persona p) throws Exception {
        ClienteModelo cm = new ClienteModelo();
        EntidadResponse er = cm.altaPersona(p);
//        if(er.isbIndError()) {
//            return Response.status(er.getError()).build();
//        }else{
//            return Response.ok(er).build();
//        }
//            
        return Response.ok(er).build();
    }
    
     public Response modificacionPersonasFisicas(PersonaModificacion pm) throws Exception {
         ClienteModelo cm = new ClienteModelo();
         EntidadResponse er = cm.modificacionPersonasFi(pm);
     
         return Response.ok(er).build();
      }
     
     
     public Response modificacionPersonasJu(PersonaJuridicaModificacion pjm) throws Exception {
         ClienteModelo cm = new ClienteModelo();
         EntidadResponse er = cm.modificacionPersonasJu(pjm);
     
         return Response.ok(er).build();
      }
     
     
}
