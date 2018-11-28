/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.corasa.clientes.models;

import com.corasa.database.util.SQLTools;

/**
 *
 * @author HCastillo
 */
public abstract class Constants {
    
    
    public static String FN_BUSQ_PERSONA
            = SQLTools.buildFunctionCall("OWBTGDESA.pkg_clientes_habituales", 
                                          "FN_BUSQ_Persona", 9);

    public static String FN_BUSQ_PERSONA_ALTA_BAJA
            = SQLTools.buildFunctionCall("OWBTGDESA.pkg_clientes_habituales", "FN_BUSQ_Persona_ALTA_BAJA", 5);

    public static String FN_BUSQ_REPRESENTADOS
            = SQLTools.buildFunctionCall("OWBTGDESA.pkg_clientes_habituales", "FN_BUSQ_Representados", 2);

    public static String FN_BUSQ_REPRESENTANTES
            = SQLTools.buildFunctionCall("OWBTGDESA.pkg_clientes_habituales", "FN_BUSQ_Representantes", 2);
    
    public static String FN_OBTENER_CLIENTE
            = SQLTools.buildFunctionCall("OWBTGDESA.pkg_clientes_habituales", "FN_Obtener_Cliente", 2);

    public static String SP_ALTA_JURIDICA
            = SQLTools.buildProcedureCall("OWBTGDESA.pkg_clientes_habituales", "SP_ALTA_JURIDICA", 31);
    
    public static String SP_ALTA_MODIFICACION_OP
            = SQLTools.buildProcedureCall("OWBTGDESA.pkg_clientes_habituales", "SP_ALTA_MODIFICACION_OP", 26);
    
    public static String SP_ALTA_PERSONA
            = SQLTools.buildProcedureCall("OWBTGDESA.pkg_clientes_habituales", "SP_ALTA_PERSONA", 42);
    
    
    public static String SP_MODIFICACION_PERSONA_FI
            = SQLTools.buildProcedureCall("OWBTGDESA.pkg_clientes_habituales", "SP_MODIFICACION_PERSONA_FI", 44);
    
    
    public static String SP_MODIFICACION_PERSONA_JU
            = SQLTools.buildProcedureCall("OWBTGDESA.pkg_clientes_habituales", "SP_MODIFICACION_PERSONA_JU", 32);
    
    
}
