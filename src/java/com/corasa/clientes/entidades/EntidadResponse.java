/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.corasa.clientes.entidades;

/**
 *
 * @author HCastillo
 */
public class EntidadResponse {
       //,P_CLH_ID_OUT OUT NUMBER
    //,P_CLHDE_ID_OUT OUT NUMBER
    private Long  pclhidout;
    private Long pclhdeidout;
    private String Error;
    private String DescError;
    private boolean bIndError = false;

    public EntidadResponse() {
    }

    public Long getPclhidout() {
        return pclhidout;
    }

    public void setPclhidout(Long pclhidout) {
        this.pclhidout = pclhidout;
    }

    public Long getPclhdeidout() {
        return pclhdeidout;
    }

    public void setPclhdeidout(Long pclhdeidout) {
        this.pclhdeidout = pclhdeidout;
    }

    public String getError() {
        return Error;
    }

    public void setError(String Error) {
        this.Error = Error;
    }

    public boolean isbIndError() {
        return bIndError;
    }

    public void setbIndError(boolean bIndError) {
        this.bIndError = bIndError;
    }

    public String getDescError() {
        return DescError;
    }

    public void setDescError(String DescError) {
        this.DescError = DescError;
    }

    
    
    
    
}
