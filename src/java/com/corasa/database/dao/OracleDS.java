/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.corasa.database.dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 *
 * @author HCastillo
 */
public class OracleDS {
    
       private static DataSource dts = null;
    private static Context ctx = null;
    
    public static DataSource OracleDSConn() throws Exception {
    
        if (dts != null) {
            return dts;
        }
        
        try {
            if (ctx == null) {
                ctx = new InitialContext();
            }
            
            dts = (DataSource) ctx.lookup("OracleDS");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dts;
    }
    
    
}
