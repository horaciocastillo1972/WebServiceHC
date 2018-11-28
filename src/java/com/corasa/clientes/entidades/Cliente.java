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
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;

    private String clhId;
    private String clhNombre;
    private String clhApellido;
    private String clhRsocial;
    private Long clhDocuNro;
    private Long clhCuit;
    private String clhDeNis;
    private String sucursal;
    private String region;
    private String persona;
    private String clhTipoPersona;
    private Long clhDeMontoMax;
    private int clhIdRep;
    private String IndModifica;

    public Cliente() {
    }

    public String getClhId() {
        return clhId;
    }

    public void setClhId(String clhId) {
        this.clhId = clhId;
    }

    public String getClhNombre() {
        return clhNombre;
    }

    public void setClhNombre(String clhNombre) {
        this.clhNombre = clhNombre;
    }

    public String getClhApellido() {
        return clhApellido;
    }

    public void setClhApellido(String clhApellido) {
        this.clhApellido = clhApellido;
    }

    public String getClhRsocial() {
        return clhRsocial;
    }

    public void setClhRsocial(String clhRsocial) {
        this.clhRsocial = clhRsocial;
    }

    public Long getClhDocuNro() {
        return clhDocuNro;
    }

    public void setClhDocuNro(Long clhDocuNro) {
        this.clhDocuNro = clhDocuNro;
    }

    public Long getClhCuit() {
        return clhCuit;
    }

    public void setClhCuit(Long clhCuit) {
        this.clhCuit = clhCuit;
    }

    public String getClhDeNis() {
        return clhDeNis;
    }

    public void setClhDeNis(String clhDeNis) {
        this.clhDeNis = clhDeNis;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPersona() {
        return persona;
    }

    public void setPersona(String persona) {
        this.persona = persona;
    }

    public String getClhTipoPersona() {
        return clhTipoPersona;
    }

    public void setClhTipoPersona(String clhTipoPersona) {
        this.clhTipoPersona = clhTipoPersona;
    }

    public Long getClhDeMontoMax() {
        return clhDeMontoMax;
    }

    public void setClhDeMontoMax(Long clhDeMontoMax) {
        this.clhDeMontoMax = clhDeMontoMax;
    }

    public int getClhIdRep() {
        return clhIdRep;
    }

    public void setClhIdRep(int clhIdRep) {
        this.clhIdRep = clhIdRep;
    }

    public String getIndModifica() {
        return IndModifica;
    }

    public void setIndModifica(String IndModifica) {
        this.IndModifica = IndModifica;
    }

    @Override
    public String toString() {
        return "Cliente{" + "clhId=" + clhId + ", clhNombre=" + clhNombre + ", clhApellido=" + clhApellido + ", clhRsocial=" + clhRsocial + ", clhDocuNro=" + clhDocuNro + ", clhCuit=" + clhCuit + ", clhDeNis=" + clhDeNis + ", sucursal=" + sucursal + ", region=" + region + ", persona=" + persona + ", clhTipoPersona=" + clhTipoPersona + ", clhDeMontoMax=" + clhDeMontoMax + ", clhIdRep=" + clhIdRep + ", IndModifica=" + IndModifica + '}';
    }

}
