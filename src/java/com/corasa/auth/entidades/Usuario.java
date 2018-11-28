/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.corasa.auth.entidades;


/**
 *
 * @author HCastillo
 */
public class Usuario {

    private String szUsuario;
    private String displayName;
    private String email;
    private String userPrincipalName;
    private String samAccountName;
    private boolean bValid;
    private String []   memerof;
    private String szError;
    private String token;

    public Usuario() {
    }

    public String getSzUsuario() {
        return szUsuario;
    }

    public void setSzUsuario(String szUsuario) {
        this.szUsuario = szUsuario;
    }

    public boolean isbValid() {
        return bValid;
    }

    public void setbValid(boolean bValid) {
        this.bValid = bValid;
    }


    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserPrincipalName() {
        return userPrincipalName;
    }

    public void setUserPrincipalName(String userPrincipalName) {
        this.userPrincipalName = userPrincipalName;
    }

    public String getSamAccountName() {
        return samAccountName;
    }

    public void setSamAccountName(String samAccountName) {
        this.samAccountName = samAccountName;
    }

    public String[] getMemerof() {
        return memerof;
    }

    public void setMemerof(String[] memerof) {
        this.memerof = memerof;
    }

    public String getSzError() {
        return szError;
    }

    public void setSzError(String szError) {
        this.szError = szError;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    
    

    @Override
    public String toString() {
        return "Usuario{" + "szUsuario=" + szUsuario + ", displayName=" + displayName + ", email=" + email + ", userPrincipalName=" + userPrincipalName + ", samAccountName=" + samAccountName + ", bValid=" + bValid + ", memerof=" + memerof + ", szError=" + szError + '}';
    }


}
