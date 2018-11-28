/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.corasa.clientes.models;

import com.corasa.database.dao.OracleDS;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author HCastillo
 */
public class StatusModelo {

    public StatusModelo() {
    }

    
    public String statusDBDAO() throws Exception {
        
        PreparedStatement query = null;
        String szTmp = null;
        String szInstance = null;
        String szVersion = null;
        String szDateTime = null;
        Connection conn = null;

        try {
            conn = OracleDS.OracleDSConn().getConnection();

            query = conn.prepareStatement("SELECT INSTANCE_NAME, " +
                                          " VERSION, " +
                                          " TO_CHAR(SYSDATE,'DD-MM-YYYY HH24:MI:SS') DATETIME " +
                                          "FROM V$INSTANCE");
            ResultSet rs = query.executeQuery();
            while (rs.next()) {
                szInstance = rs.getString("INSTANCE_NAME");
                szVersion = rs.getString("VERSION");
                szDateTime = rs.getString("DATETIME");
            }

            query.close();

            szTmp = "<h2> Estado de la base de datos: </h2>"
                    + "<h2> Instancia: </h2>" + szInstance
                    + "<h2> Version: </h2>" + szVersion
                    + "<h2> Date / Time: </h2>" + szDateTime;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                conn.close();
            }

        }

        return szTmp;
    }
}
