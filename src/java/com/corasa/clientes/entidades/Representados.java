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
public class Representados implements Serializable {

    private String szRteNombre;
    private String szRteApellido;
    private Long lRteDocuNro;
    private int iClhId;
    private String szRtdoNombre;
    private String szRtdoApellido;
    private String szRtdoRsocial;
    private String szRtdoDocuNro;

    public Representados() {
    }

    public String getSzRteNombre() {
        return szRteNombre;
    }

    public void setSzRteNombre(String szRteNombre) {
        this.szRteNombre = szRteNombre;
    }

    public String getSzRteApellido() {
        return szRteApellido;
    }

    public void setSzRteApellido(String szRteApellido) {
        this.szRteApellido = szRteApellido;
    }

    public Long getlRteDocuNro() {
        return lRteDocuNro;
    }

    public void setlRteDocuNro(Long lRteDocuNro) {
        this.lRteDocuNro = lRteDocuNro;
    }

    public int getiClhId() {
        return iClhId;
    }

    public void setiClhId(int iClhId) {
        this.iClhId = iClhId;
    }

    public String getSzRtdoNombre() {
        return szRtdoNombre;
    }

    public void setSzRtdoNombre(String szRtdoNombre) {
        this.szRtdoNombre = szRtdoNombre;
    }

    public String getSzRtdoApellido() {
        return szRtdoApellido;
    }

    public void setSzRtdoApellido(String szRtdoApellido) {
        this.szRtdoApellido = szRtdoApellido;
    }

    public String getSzRtdoRsocial() {
        return szRtdoRsocial;
    }

    public void setSzRtdoRsocial(String szRtdoRsocial) {
        this.szRtdoRsocial = szRtdoRsocial;
    }

    public String getSzRtdoDocuNro() {
        return szRtdoDocuNro;
    }

    public void setSzRtdoDocuNro(String szRtdoDocuNro) {
        this.szRtdoDocuNro = szRtdoDocuNro;
    }

    @Override
    public String toString() {
        return "Representados{" + "szRteNombre=" + szRteNombre + ", szRteApellido=" + szRteApellido + ", lRteDocuNro=" + lRteDocuNro + ", iClhId=" + iClhId + ", szRtdoNombre=" + szRtdoNombre + ", szRtdoApellido=" + szRtdoApellido + ", szRtdoRsocial=" + szRtdoRsocial + ", szRtdoDocuNro=" + szRtdoDocuNro + '}';
    }

}
