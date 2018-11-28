/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.corasa.database.util;

/**
 *
 * @author HCastillo
 */
public class SQLTools {

    /* Construccion para procedimiento */
    public static String buildProcedureCall(String packageName, String procedureName, int paramCount) {
        StringBuffer sb = new StringBuffer("{call " + packageName + "." + procedureName + "(");
        for (int n = 1; n <= paramCount; n++) {
            sb.append("?");
            if (n < paramCount) {
                sb.append(",");
            }
        }
        return sb.append(")}").toString();
    }

    /* Construccion para funcion */
    public static String buildFunctionCall(String packageName, String procedureName, int paramCount) {
        StringBuffer sb = new StringBuffer("{? = call " + packageName + "." + procedureName + "(");
        for (int n = 1; n <= paramCount - 1; n++) {
            sb.append("?");
            if (n < paramCount - 1) {
                sb.append(",");
            }
        }
        return sb.append(")}").toString();
    }

    /* public static void close(ResultSet rs, Statement s, Connection c) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (Exception e) {
        }
        try {
            if (s != null) {
                s.close();
            }
        } catch (Exception e) {
        }
        try {
            if (c != null) {
                c.close();
            }
        } catch (Exception e) {
        }
    }*/
}
