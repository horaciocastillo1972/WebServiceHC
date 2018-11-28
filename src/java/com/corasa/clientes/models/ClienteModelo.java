/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.corasa.clientes.models;

import com.corasa.clientes.entidades.Cliente;
import com.corasa.clientes.entidades.ClienteRelacion;
import com.corasa.clientes.entidades.EntidadResponse;
import com.corasa.clientes.entidades.OrganismoPublico;
import com.corasa.clientes.entidades.ParametroBusqueda;
import com.corasa.clientes.entidades.Persona;
import com.corasa.clientes.entidades.PersonaJuridica;
import com.corasa.clientes.entidades.PersonaJuridicaModificacion;
import com.corasa.clientes.entidades.PersonaModificacion;
import com.corasa.clientes.entidades.Representados;
import com.corasa.database.dao.OracleDS;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import javax.sql.DataSource;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author HCastillo
 */
public class ClienteModelo {

    private Connection conn;
    private DataSource dt;
    private CallableStatement cs = null;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public ClienteModelo() {
    }

    public List<Cliente> getData(ParametroBusqueda param) throws Exception {

        List<Cliente> list = new LinkedList<>();
        try {
            conn = OracleDS.OracleDSConn().getConnection();
            cs = conn.prepareCall(Constants.FN_BUSQ_PERSONA);

            System.err.println(Constants.FN_BUSQ_PERSONA);

            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.setString(2, param.getSzNis());
            cs.setString(3, param.getSzTipoPermiso());
            cs.setString(4, param.getSzNombre());
            cs.setString(5, param.getSzApellido());
            cs.setString(6, param.getlNroDoc());
            cs.setString(7, param.getSzRsocial());
            cs.setString(8, param.getSzCuit());
            cs.setString(9, param.getSzTipoPersona());
            //cs.registerOutParameter(8, OracleTypes.NUMBER);

            cs.execute();

            ResultSet rs = (ResultSet) cs.getObject(1);   // Nuestro cursor, convertido en ResultSet
            //Long lCnt = cs.getLong(8);

            Cliente cli;

            System.out.println("Comienza el while.....Cnt: ");
            while (rs.next()) {
                cli = new Cliente();

                cli.setClhNombre(rs.getString(1));
                cli.setClhApellido(rs.getString(2));
                cli.setClhRsocial(rs.getString(3));
                cli.setClhDocuNro(rs.getLong(4));
                cli.setClhCuit(rs.getLong(5));
                cli.setClhDeNis(rs.getString(6));
                cli.setSucursal(rs.getString(7));
                cli.setRegion(rs.getString(8));
                cli.setPersona(rs.getString(9));
                cli.setClhTipoPersona(rs.getString(10));
                cli.setClhDeMontoMax(rs.getLong(11));
                cli.setClhId(rs.getString(12));
                cli.setClhIdRep(rs.getInt(13));
                cli.setIndModifica(rs.getString(14));

                // Add vacante object to the list
                list.add(cli);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }

    public List<Cliente> getDataAltaBaja(ParametroBusqueda param) throws Exception {

        List<Cliente> list = new LinkedList<>();
        try {
            conn = OracleDS.OracleDSConn().getConnection();
            cs = conn.prepareCall(Constants.FN_BUSQ_PERSONA_ALTA_BAJA);

            System.err.println(Constants.FN_BUSQ_PERSONA_ALTA_BAJA);

            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.setString(2, param.getSzNombre());
            cs.setString(3, param.getSzApellido());
            cs.setString(4, param.getlNroDoc());
            cs.setString(5, param.getSzRsocial());

            //cs.registerOutParameter(8, OracleTypes.NUMBER);
            cs.execute();

            ResultSet rs = (ResultSet) cs.getObject(1);   // Nuestro cursor, convertido en ResultSet
            //Long lCnt = cs.getLong(8);

            Cliente cli;

            System.out.println("Comienza el while.....Cnt: ");
            while (rs.next()) {
                cli = new Cliente();
                cli.setClhId(rs.getString(1));
                cli.setClhNombre(rs.getString(2));
                cli.setClhApellido(rs.getString(3));
                cli.setClhRsocial(rs.getString(4));
                cli.setClhDocuNro(rs.getLong(5));
                cli.setClhCuit(rs.getLong(6));
                cli.setClhTipoPersona(rs.getString(7));

                // Add vacante object to the list
                list.add(cli);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }

    public List<Representados> getRepresentados(int idCliente) throws Exception {

        List<Representados> list = new LinkedList<>();
        try {
            conn = OracleDS.OracleDSConn().getConnection();
            cs = conn.prepareCall(Constants.FN_BUSQ_REPRESENTADOS);

            System.out.println(Constants.FN_BUSQ_REPRESENTADOS);

            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.setInt(2, idCliente);

            //cs.registerOutParameter(8, OracleTypes.NUMBER);
            cs.execute();

            ResultSet rs = (ResultSet) cs.getObject(1);   // Nuestro cursor, convertido en ResultSet
            //Long lCnt = cs.getLong(8);

            Representados rep;

            System.out.println("Comienza el while.....Cnt: ");
            while (rs.next()) {
                rep = new Representados();

                rep.setSzRteNombre(rs.getString(1));
                rep.setSzRteApellido(rs.getString(2));
                rep.setlRteDocuNro(rs.getLong(3));
                rep.setiClhId(rs.getInt(4));
                rep.setSzRtdoNombre(rs.getString(5));
                rep.setSzRtdoApellido(rs.getString(6));
                rep.setSzRtdoRsocial(rs.getString(7));
                rep.setSzRtdoDocuNro(rs.getString(8));

                // Add vacante object to the list
                list.add(rep);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }
    //getRepresentantes

    public List<Representados> getRepresentantes(int idCliente) throws Exception {

        List<Representados> list = new LinkedList<>();
        try {
            conn = OracleDS.OracleDSConn().getConnection();
            cs = conn.prepareCall(Constants.FN_BUSQ_REPRESENTANTES);

            System.out.println(Constants.FN_BUSQ_REPRESENTANTES);

            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.setInt(2, idCliente);

            //cs.registerOutParameter(8, OracleTypes.NUMBER);
            cs.execute();

            ResultSet rs = (ResultSet) cs.getObject(1);   // Nuestro cursor, convertido en ResultSet
            //Long lCnt = cs.getLong(8);

            Representados rep;

            System.out.println("Comienza el while.....Cnt: ");
            while (rs.next()) {
                rep = new Representados();

                rep.setiClhId(rs.getInt(1));
                rep.setSzRteNombre(rs.getString(2));
                rep.setSzRteApellido(rs.getString(3));
                rep.setlRteDocuNro(rs.getLong(4));
                rep.setSzRtdoNombre(rs.getString(5));
                rep.setSzRtdoApellido(rs.getString(6));
                rep.setSzRtdoRsocial(rs.getString(7));
                rep.setSzRtdoDocuNro(rs.getString(8));

                // Add vacante object to the list
                list.add(rep);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }

    public List<ClienteRelacion> getCliente(int idCliente) throws Exception {

        List<ClienteRelacion> list = new LinkedList<>();
        try {
            conn = OracleDS.OracleDSConn().getConnection();
            cs = conn.prepareCall(Constants.FN_OBTENER_CLIENTE);

            System.out.println(Constants.FN_OBTENER_CLIENTE);

            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.setInt(2, idCliente);

            //cs.registerOutParameter(8, OracleTypes.NUMBER);
            cs.execute();

            ResultSet rs = (ResultSet) cs.getObject(1);   // Nuestro cursor, convertido en ResultSet
            //Long lCnt = cs.getLong(8);

            ClienteRelacion cr;

            System.out.println("Comienza el while.....Cnt: ");
            while (rs.next()) {
                cr = new ClienteRelacion();
                cr.setClhid(rs.getInt(1));
                cr.setClhtipopersona(rs.getString(2));
                cr.setClhnombre(rs.getString(3));
                cr.setClhapellido(rs.getString(4));
                cr.setClhdocutipo(rs.getString(5));
                cr.setDocutipodescrip(rs.getString(6));
                cr.setClhdocunro(rs.getString(7));
                cr.setClhsexo(rs.getString(8));
                cr.setClhfechanacimiento(rs.getString(9));
                cr.setClhlugarnacimiento(rs.getString(10));
                cr.setClhestadocivil(rs.getString(11));
                cr.setClhpep(rs.getString(12));
                cr.setClhpepcondicion(rs.getString(13));
                cr.setClhnacionalidad(rs.getString(14));
                cr.setClhcuit(rs.getString(15));
                cr.setClhrsocial(rs.getString(16));
                cr.setClhinscripregistral(rs.getString(17));
                cr.setClhcontrconstlugfec(rs.getString(18));
                cr.setClhcontrconstfecinsc(rs.getString(19));
                cr.setClhcontrconstobjeto(rs.getString(20));
                cr.setClhcontrconstduracion(rs.getString(21));
                cr.setClhocupacion(rs.getString(22));
                cr.setClhmontomax(rs.getString(23));
                cr.setClhpersonahumana(rs.getString(24));
                cr.setClhrepresentante(rs.getString(25));
                cr.setClhfuncionario(rs.getString(26));
                cr.setClhsegmento(rs.getString(27));
                cr.setClhfechaalta(rs.getString(28));

                cr.setClhdeid(rs.getInt(29));
                cr.setClhdetelefono(rs.getString(30));
                cr.setClhdetelefonomovi(rs.getString(31));
                cr.setClhdemail(rs.getString(32));
                cr.setClhdenis(rs.getString(33));
                cr.setClhdecodoperador(rs.getString(34));
                cr.setClhdemontomax(rs.getString(35));
                cr.setClhdeobservaciones(rs.getString(36));
                cr.setClhdeoperador(rs.getString(37));
                cr.setClhdedocoperador(rs.getString(38));
                cr.setClhdefechaconfeccionficha(rs.getString(39));
                cr.setClhdefechaalta(rs.getString(40));
                cr.setClhdefechamodificacion(rs.getString(41));
                cr.setClhdeusuarioclh(rs.getString(42));
                cr.setClhdeusuarioseccionpc(rs.getString(43));

                cr.setClhdiid(rs.getInt(44));
                cr.setClhdicalle(rs.getString(45));
                cr.setClhdinrocalle(rs.getString(46));
                cr.setClhdipiso(rs.getString(47));
                cr.setClhdidpto(rs.getString(48));
                cr.setClhdilocalidad(rs.getString(49));
                cr.setClhdiciudad(rs.getString(50));
                cr.setClhdicodpostal(rs.getString(51));
                cr.setClhdiprovincia(rs.getString(52));
                cr.setClhdipaisresidencia(rs.getString(53));

                // Add vacante object to the list
                list.add(cr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }

    public EntidadResponse altaPersonaJuridica(PersonaJuridica pj) throws SQLException, Exception {
        EntidadResponse er = new EntidadResponse();

        try {

            conn = OracleDS.OracleDSConn().getConnection();
            cs = conn.prepareCall(Constants.SP_ALTA_JURIDICA);

            System.out.println(Constants.SP_ALTA_JURIDICA);

            System.out.println(pj.toString());

            if (pj.getPclhid() == null) {
                cs.setNull(1, java.sql.Types.INTEGER);
            } else {
                cs.setLong(1, pj.getPclhid());
            }

            cs.setString(2, pj.getPclhcuit());
            cs.setString(3, pj.getPclhrsocial());
            cs.setString(4, pj.getPclhinscripregistral());
            cs.setString(5, pj.getPclhcontrconstlugfec());
            java.util.Date fecha = sdf.parse(pj.getPclhcontrconstfecinsc());
            java.sql.Date sqlF = new java.sql.Date(fecha.getTime());
            //private Date pclhcontrconstfecinsc;

            cs.setDate(6, sqlF);

            cs.setString(7, pj.getPclhcontrconstobjeto());
            cs.setString(8, pj.getPclhcontrconstduracion());
            cs.setString(9, pj.getPclhocupacion());
            cs.setString(10, pj.getPclhsegmento());
            cs.setString(11, pj.getPclhdetelefono());
            cs.setString(12, pj.getPclhdemail());
            cs.setString(13, pj.getPclhdenis());
            cs.setString(14, pj.getPclhdecodoperador());
            cs.setLong(15, pj.getPclhdemontomax());
            cs.setString(16, pj.getPclhdeobservaciones());
            cs.setString(17, pj.getPclhdeoperador());
            cs.setString(18, pj.getPclhdedocoperador());
            java.util.Date fecha2 = sdf.parse(pj.getPclhdefechaconfeccionficha());
            java.sql.Date sqlF2 = new java.sql.Date(fecha2.getTime());

            cs.setDate(19, sqlF2);
            cs.setString(20, pj.getPclhdeusuarioclh());
            cs.setString(21, pj.getPclhdeusuarioseccionpc());
            cs.setString(22, pj.getPclhdicalle());
            cs.setString(23, pj.getPclhdinrocalle());
            cs.setString(24, pj.getPclhdipiso());
            cs.setString(25, pj.getPclhdidpto());
            cs.setString(26, pj.getPclhdilocalidad());
            cs.setString(27, pj.getPclhdicodpostal());
            cs.setString(28, pj.getPclhdiprovincia());
            cs.setString(29, pj.getPclhdipaisresidencia());

            cs.registerOutParameter(30, OracleTypes.NUMBER);
            cs.registerOutParameter(31, OracleTypes.NUMBER);

            cs.execute();

            er.setPclhidout(cs.getLong(30));
            er.setPclhdeidout(cs.getLong(31));
            er.setError("Se ha creado el registro correctamente.");
            er.setbIndError(false);

        } catch (SQLException esql) {
            System.out.println("error sqlexception " + esql.getSQLState());
            er.setError(esql.getMessage());
            er.setbIndError(true);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return er;
    }

    public EntidadResponse altaModifOP(OrganismoPublico op) throws SQLException, Exception {
        EntidadResponse er = new EntidadResponse();

        try {

            conn = OracleDS.OracleDSConn().getConnection();

            cs = conn.prepareCall(Constants.SP_ALTA_MODIFICACION_OP);

            System.out.println(Constants.SP_ALTA_MODIFICACION_OP);

            System.out.println(op.toString());

            if (op.getPclhid() == null) {
                cs.setNull(1, java.sql.Types.INTEGER);
            } else {
                cs.setLong(1, op.getPclhid());
            }

            cs.setString(2, op.getPclhcuit());
            cs.setString(3, op.getPCLHRSOCIAL());
            cs.setString(4, op.getPCLHSEGMENTO());
            if (op.getPCLHDEID() == null) {
                cs.setNull(5, java.sql.Types.INTEGER);
            } else {
                cs.setLong(5, op.getPCLHDEID());
            }
            cs.setString(6, op.getPCLHDENIS());
            cs.setString(7, op.getPCLHDECODOPERADOR());
            cs.setFloat(8, op.getPCLHDEMONTOMAX());
            cs.setString(9, op.getPCLHDEOBSERVACIONES());
            cs.setString(10, op.getPCLHDEOPERADOR());
            cs.setString(11, op.getPCLHDEDOCOPERADOR());

            java.util.Date fecha3 = sdf.parse(op.getPCLHDEFECHACONFECCIONFICHA());
            java.sql.Date sqlF3 = new java.sql.Date(fecha3.getTime());
            cs.setDate(12, sqlF3);
            cs.setString(14, op.getPCLHDEUSUARIOCLH());
            cs.setString(15, op.getPCLHDEUSUARIOSECCIONPC());
            if (op.getPCLHDIID() == null) {
                cs.setNull(16, java.sql.Types.INTEGER);
            } else {
                cs.setLong(16, op.getPCLHDIID());
            }

            cs.setString(17, op.getPCLHDICALLE());
            cs.setString(18, op.getPCLHDINROCALLE());
            cs.setString(20, op.getPCLHDIPISO());
            cs.setString(21, op.getPCLHDIDPTO());
            cs.setString(22, op.getPCLHDILOCALIDAD());
            cs.setString(23, op.getPCLHDICODPOSTAL());
            cs.setString(24, op.getPCLHDIPROVINCIA());
            cs.setString(25, op.getPCLHDIPAISRESIDENCIA());
            cs.setString(26, op.getPALTAMODIFICACION());

            cs.execute();

            er.setPclhidout(cs.getLong(27));
            er.setPclhdeidout(cs.getLong(28));
            er.setError("Se ha creado el registro correctamente.");
            er.setbIndError(false);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return er;

    }

    //SP_ALTA_PERSONA
    public EntidadResponse altaPersona(Persona p) throws SQLException, Exception {
        EntidadResponse er = new EntidadResponse();

        try {

            conn = OracleDS.OracleDSConn().getConnection();

            cs = conn.prepareCall(Constants.SP_ALTA_PERSONA);

            System.out.println(Constants.SP_ALTA_PERSONA);

            System.out.println(p.toString());

//            if(op.getPclhid() == null) {
//                cs.setNull(1, java.sql.Types.INTEGER);
//            } else {
//                cs.setLong(1, op.getPclhid());
//            }
            cs.setString(1, p.getPCLHNOMBRE());
            cs.setString(2, p.getPCLHAPELLIDO());
            cs.setString(3, p.getPCLHDOCUTIPO());
            cs.setString(4, p.getPCLHDOCUNRO());
            cs.setString(5, p.getPCLHSEXO());

            java.util.Date fecha4 = sdf.parse(p.getPCLHFECHANACIMIENTO());
            java.sql.Date sqlF4 = new java.sql.Date(fecha4.getTime());
            cs.setDate(6, sqlF4);

            cs.setString(7, p.getPCLHLUGARNACIMIENTO());
            cs.setString(8, p.getPCLHESTADOCIVIL());
            cs.setString(9, p.getPCLHPEP());
            cs.setString(10, p.getPCLHPEPCONDICION());
            cs.setString(11, p.getPCLHOCUPACION());
            cs.setString(12, p.getPCLHNACIONALIDAD());
            cs.setString(13, p.getPCLHPERSONAHUMANA());
            cs.setString(14, p.getPCLHREPRESENTANTE());
            cs.setString(14, p.getPCLHFUNCIONARIO());
            cs.setString(16, p.getPCLHSEGMENTO());
            cs.setString(17, p.getPCLHDETELEFONO());
            cs.setString(18, p.getPCLHDETELEFONOMOVI());
            cs.setString(19, p.getPCLHDEMAIL());
            cs.setString(20, p.getPCLHDENIS());
            cs.setString(21, p.getPCLHDECODOPERADOR());
            cs.setFloat(22, p.getPCLHDEMONTOMAX());
            cs.setString(23, p.getPCLHDEOBSERVACIONES());
            cs.setString(24, p.getPCLHDEOPERADOR());
            cs.setString(25, p.getPCLHDEDOCOPERADOR());

            java.util.Date fecha5 = sdf.parse(p.getPCLHDEFECHACONFECCIONFICHA());
            java.sql.Date sqlF5 = new java.sql.Date(fecha5.getTime());
            cs.setDate(26, sqlF5);

            cs.setString(27, p.getPCLHDEUSUARIOCLH());
            cs.setString(28, p.getPCLHDEUSUARIOSECCIONPC());
            cs.setString(29, p.getPCLHDICALLE());
            cs.setString(30, p.getPCLHDINROCALLE());
            cs.setString(31, p.getPCLHDIPISO());
            cs.setString(32, p.getPCLHDIDPTO());
            cs.setString(33, p.getPCLHDILOCALIDAD());
            cs.setString(34, p.getPCLHDICODPOSTAL());
            cs.setString(35, p.getPCLHDIPROVINCIA());
            cs.setString(36, p.getPCLHDIPAISRESIDENCIA());
            cs.setString(37, p.getPCLHCOAPELLIDOCONYUGUE());
            cs.setString(38, p.getPCLHCONOMBRECONYUGUE());
            cs.setString(39, p.getPCLHCODOCUTIPOCONYUGUE());
            cs.setString(40, p.getPCLHCODOCUNROCONYUGUE());

            cs.execute();

            er.setPclhidout(cs.getLong(41));
            er.setPclhdeidout(cs.getLong(42));
            er.setError("Se ha creado el registro correctamente.");
            er.setbIndError(false);

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return er;
    }

    //SP_MODIFICACION_PERSONA_FI
    public EntidadResponse modificacionPersonasFi(PersonaModificacion pm) throws SQLException, Exception {
        EntidadResponse er = new EntidadResponse();

        try {

            conn = OracleDS.OracleDSConn().getConnection();

            cs = conn.prepareCall(Constants.SP_MODIFICACION_PERSONA_FI);

            System.out.println(Constants.SP_MODIFICACION_PERSONA_FI);

            System.out.println(pm.toString());

            if (pm.getPclhid() == null) {
                cs.setNull(1, java.sql.Types.INTEGER);
            } else {
                cs.setLong(1, pm.getPclhid());
            }

            cs.setString(2, pm.getPCLHNOMBRE());
            cs.setString(3, pm.getPCLHAPELLIDO());
            cs.setString(4, pm.getPCLHDOCUTIPO());
            cs.setString(5, pm.getPCLHDOCUNRO());
            cs.setString(6, pm.getPCLHSEXO());

            java.util.Date fecha6 = sdf.parse(pm.getPCLHFECHANACIMIENTO());
            java.sql.Date sqlF6 = new java.sql.Date(fecha6.getTime());
            cs.setDate(7, sqlF6);

            cs.setString(8, pm.getPCLHLUGARNACIMIENTO());
            cs.setString(9, pm.getPCLHESTADOCIVIL());
            cs.setString(10, pm.getPCLHPEP());
            cs.setString(11, pm.getPCLHPEPCONDICION());
            cs.setString(12, pm.getPCLHOCUPACION());
            cs.setString(13, pm.getPCLHNACIONALIDAD());
            cs.setString(14, pm.getPCLHPERSONAHUMANA());
            cs.setString(15, pm.getPCLHREPRESENTANTE());
            cs.setString(16, pm.getPCLHFUNCIONARIO());
            cs.setString(17, pm.getPCLHSEGMENTO());

            if (pm.getPCLHDEID() == null) {
                cs.setNull(18, java.sql.Types.INTEGER);
            } else {
                cs.setLong(18, pm.getPCLHDEID());
            }

            cs.setString(19, pm.getPCLHDETELEFONO());
            cs.setString(20, pm.getPCLHDETELEFONOMOVI());
            cs.setString(21, pm.getPCLHDEMAIL());
            cs.setString(22, pm.getPCLHDENIS());
            cs.setString(23, pm.getPCLHDECODOPERADOR());
            cs.setFloat(24, pm.getPCLHDEMONTOMAX());
            cs.setString(25, pm.getPCLHDEOBSERVACIONES());
            cs.setString(26, pm.getPCLHDEOPERADOR());
            cs.setString(27, pm.getPCLHDEDOCOPERADOR());

            java.util.Date fecha7 = sdf.parse(pm.getPCLHDEFECHACONFECCIONFICHA());
            java.sql.Date sqlF7 = new java.sql.Date(fecha7.getTime());
            cs.setDate(28, sqlF7);

            cs.setString(29, pm.getPCLHDEUSUARIOCLH());
            cs.setString(30, pm.getPCLHDEUSUARIOSECCIONPC());

            if (pm.getPCLHDIID() == null) {
                cs.setNull(31, java.sql.Types.INTEGER);
            } else {
                cs.setLong(31, pm.getPCLHDIID());
            }

            cs.setString(32, pm.getPCLHDICALLE());
            cs.setString(33, pm.getPCLHDINROCALLE());
            cs.setString(34, pm.getPCLHDIPISO());
            cs.setString(35, pm.getPCLHDIDPTO());
            cs.setString(36, pm.getPCLHDILOCALIDAD());
            cs.setString(37, pm.getPCLHDICODPOSTAL());
            cs.setString(38, pm.getPCLHDIPROVINCIA());
            cs.setString(39, pm.getPCLHDIPAISRESIDENCIA());

            if (pm.getPCLHCOID() == null) {
                cs.setNull(40, java.sql.Types.INTEGER);
            } else {
                cs.setLong(40, pm.getPCLHCOID());
            }

            cs.setString(41, pm.getPCLHCOAPELLIDOCONYUGUE());
            cs.setString(42, pm.getPCLHCONOMBRECONYUGUE());
            cs.setString(43, pm.getPCLHCODOCUTIPOCONYUGUE());
            cs.setString(44, pm.getPCLHCODOCUNROCONYUGUE());

            cs.execute();

            er.setbIndError(false);
            er.setError("Se ha modificado el registro correctamente.");

        } catch (SQLException sqle) {
            er.setbIndError(true);
            er.setDescError(sqle.getMessage());
            er.setError("Error al modificar Persona Fisica");
            sqle.printStackTrace();
        } catch (Exception ex) {
            er.setbIndError(true);
            er.setDescError(ex.getMessage());
            er.setError("Error al modificar Persona Fisica");
            ex.printStackTrace();
        }

        return er;
    }

    //SP_MODIFICACION_PERSONA_JU
    public EntidadResponse modificacionPersonasJu(PersonaJuridicaModificacion pjm) throws SQLException, Exception {
        EntidadResponse er = new EntidadResponse();

        try {

            conn = OracleDS.OracleDSConn().getConnection();

            cs = conn.prepareCall(Constants.SP_MODIFICACION_PERSONA_JU);

            System.out.println(Constants.SP_MODIFICACION_PERSONA_JU);

            System.out.println(pjm.toString());

            if (pjm.getPclhid() == null) {
                cs.setNull(1, java.sql.Types.INTEGER);
            } else {
                cs.setLong(1, pjm.getPclhid());
            }

            cs.setString(2, pjm.getPCLHRSOCIAL());
            cs.setString(3, pjm.getPCLHINSCRIPREGISTRAL());
            cs.setString(4, pjm.getPCLHCONTRCONSTLUGFEC());

            java.util.Date fecha8 = sdf.parse(pjm.getPCLHCONTRCONSTFECINSC());
            java.sql.Date sqlF8 = new java.sql.Date(fecha8.getTime());
            cs.setDate(5, sqlF8);

            cs.setString(6, pjm.getPCLHCONTRCONSTOBJETO());
            cs.setString(7, pjm.getPCLHCONTRCONSTDURACION());
            cs.setString(8, pjm.getPCLHOCUPACION());
            cs.setString(9, pjm.getPCLHSEGMENTO());
            cs.setString(10, pjm.getPCLHJURIDICACONSTITUIDA());

            if (pjm.getPCLHDEID() == null) {
                cs.setNull(11, java.sql.Types.INTEGER);
            } else {
                cs.setLong(11, pjm.getPCLHDEID());
            }

            cs.setString(12, pjm.getPCLHDETELEFONO());
            cs.setString(13, pjm.getPCLHDETELEFONOMOVI());
            cs.setString(14, pjm.getPCLHDEMAIL());
            cs.setString(15, pjm.getPCLHDENIS());
            cs.setString(16, pjm.getPCLHDECODOPERADOR());
            cs.setFloat(17, pjm.getPCLHDEMONTOMAX());
            cs.setString(18, pjm.getPCLHDEOBSERVACIONES());
            cs.setString(19, pjm.getPCLHDEOPERADOR());
            cs.setString(20, pjm.getPCLHDEDOCOPERADOR());

            java.util.Date fecha9 = sdf.parse(pjm.getPCLHDEFECHACONFECCIONFICHA());
            java.sql.Date sqlF9 = new java.sql.Date(fecha9.getTime());
            cs.setDate(21, sqlF9);

            cs.setString(22, pjm.getPCLHDEUSUARIOCLH());
            cs.setString(23, pjm.getPCLHDEUSUARIOSECCIONPC());

            if (pjm.getPCLHDIID() == null) {
                cs.setNull(24, java.sql.Types.INTEGER);
            } else {
                cs.setLong(24, pjm.getPCLHDIID());
            }

            cs.setString(25, pjm.getPCLHDICALLE());
            cs.setString(26, pjm.getPCLHDINROCALLE());
            cs.setString(27, pjm.getPCLHDIPISO());
            cs.setString(28, pjm.getPCLHDIDPTO());
            cs.setString(29, pjm.getPCLHDILOCALIDAD());
            cs.setString(30, pjm.getPCLHDICODPOSTAL());
            cs.setString(31, pjm.getPCLHDIPROVINCIA());
            cs.setString(32, pjm.getPCLHDIPAISRESIDENCIA());

            cs.execute();

            er.setbIndError(false);
            er.setError("Se ha modificado el registro correctamente de persona Juridica: " + pjm.getPclhid());

        } catch (SQLException sqle) {
            er.setbIndError(true);
            er.setDescError(sqle.getMessage());
            er.setError("Error al modificar Persona Juridica " + pjm.getPclhid());
            sqle.printStackTrace();
        } catch (Exception ex) {
            er.setbIndError(true);
            er.setDescError(ex.getMessage());
            er.setError("Error al modificar Persona Juridica " + pjm.getPclhid());
            ex.printStackTrace();
        }
        return er;
    }

}
