/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.corasa.clientes.entidades;

import java.io.Serializable;

/**
 *
 * @author HCastillo
 */
public class ParametroBusqueda implements Serializable {

    /* parametros de busqueda que viene desde navegador como JSON */
    private String szNis;
    private String szTipoPermiso;
    private String szNombre;
    private String szApellido;
    private String lNroDoc;
    private String szRsocial;
    private String szCuit;
    private String szTipoPersona;
    private String szMsj;
        

    public ParametroBusqueda() {
    }

    public String getSzNis() {
        return szNis;
    }

    public void setSzNis(String szNis) {
        this.szNis = szNis;
    }

    public String getSzTipoPermiso() {
        return szTipoPermiso;
    }

    public void setSzTipoPermiso(String szTipoPermiso) {
        this.szTipoPermiso = szTipoPermiso;
    }

    public String getSzNombre() {
        return szNombre;
    }

    public void setSzNombre(String szNombre) {
        this.szNombre = szNombre;
    }

    public String getSzApellido() {
        return szApellido;
    }

    public void setSzApellido(String szApellido) {
        this.szApellido = szApellido;
    }

    public String getlNroDoc() {
        return lNroDoc;
    }

    public void setlNroDoc(String lNroDoc) {
        this.lNroDoc = lNroDoc;
    }

    public String getSzRsocial() {
        return szRsocial;
    }

    public void setSzRsocial(String szRsocial) {
        this.szRsocial = szRsocial;
    }

    public String getSzMsj() {
        return szMsj;
    }

    public void setSzMsj(String szMsj) {
        this.szMsj = szMsj;
    }

    public String getSzCuit() {
        return szCuit;
    }

    public void setSzCuit(String szCuit) {
        this.szCuit = szCuit;
    }

    public String getSzTipoPersona() {
        return szTipoPersona;
    }

    public void setSzTipoPersona(String szTipoPersona) {
        this.szTipoPersona = szTipoPersona;
    }
    
    @Override
    public String toString() {
        return "ParametroBusqueda{" + "szNis=" + szNis + ", szTipoPermiso=" + szTipoPermiso + ", szNombre=" + szNombre + ", szApellido=" + szApellido + ", lNroDoc=" + lNroDoc + ", szRsocial=" + szRsocial + ", szCuit=" + szCuit + ", szTipoPersona=" + szTipoPersona + ", szMsj=" + szMsj + '}';
    }


}
