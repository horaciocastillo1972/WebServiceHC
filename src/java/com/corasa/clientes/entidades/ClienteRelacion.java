/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.corasa.clientes.entidades;

/**
 *
 * @author HCastillo
 *           FROM clh_clientes_habituales a
                inner join clh_detalle b  on a.clh_id=B.clh_id and clhde_id=P_clhDE_id
                LEFT join clh_direccion C on B.clhde_id=c.clhde_id
                LEFT join clh_conyugue D  on b.clhde_id=D.clhde_id
                inner join sucursales s  on s.nis=b.clhde_nis
                inner join region_nis rn on s.nis_padre = rn.nis
                inner join regiones r on rn.region = r.region

 */
public class ClienteRelacion {
    private int clhid;
    private String clhtipopersona;
    private String clhnombre;
    private String clhapellido;
    private String clhdocutipo;
    private String docutipodescrip;
    private String clhdocunro;
    private String clhsexo;
    private String clhfechanacimiento;
    private String clhlugarnacimiento;
    private String clhestadocivil; 
    private String clhpep; 
    private String clhpepcondicion;
    private String clhnacionalidad; 
    private String clhcuit; 
    private String clhrsocial;
    private String clhinscripregistral; 
    private String clhcontrconstlugfec;
    private String clhcontrconstfecinsc; 
    private String clhcontrconstobjeto;
    private String clhcontrconstduracion;
    private String clhocupacion;
    private String clhmontomax;
    private String clhpersonahumana;
    private String clhrepresentante;
    private String clhfuncionario;
    private String clhsegmento;
    private String clhfechaalta;
    
    private int clhdeid;
    private String clhdetelefono;
    private String clhdetelefonomovi;
    private String clhdemail;
    private String clhdenis; 
    private String clhdecodoperador;
    private String clhdemontomax; 
    private String clhdeobservaciones; 
    private String clhdeoperador;
    private String clhdedocoperador; 
    private String clhdefechaconfeccionficha;
    private String clhdefechaalta; 
    private String clhdefechamodificacion;
    private String clhdeusuarioclh;
    private String clhdeusuarioseccionpc;

    private int clhdiid;
    private String clhdicalle;
    private String clhdinrocalle;
    private String clhdipiso;
    private String clhdidpto; 
    private String clhdilocalidad;
    private String clhdiciudad;
    private String clhdicodpostal;
    private String clhdiprovincia; 
    private String clhdipaisresidencia;

    private String clhco_id;
    private String clhco_apellido_conyugue;
    private String clhco_nombre_conyugue;
    private String clhco_docu_tipo_conyugue;
    private String clhco_docu_nro_conyugue;
    private String descrip;
    private String region;
    private String descripcion;

    public ClienteRelacion() {
    }

    public int getClhid() {
        return clhid;
    }

    public void setClhid(int clhid) {
        this.clhid = clhid;
    }

    public String getClhtipopersona() {
        return clhtipopersona;
    }

    public void setClhtipopersona(String clhtipopersona) {
        this.clhtipopersona = clhtipopersona;
    }

    public String getClhnombre() {
        return clhnombre;
    }

    public void setClhnombre(String clhnombre) {
        this.clhnombre = clhnombre;
    }

    public String getClhapellido() {
        return clhapellido;
    }

    public void setClhapellido(String clhapellido) {
        this.clhapellido = clhapellido;
    }

    public String getClhdocutipo() {
        return clhdocutipo;
    }

    public void setClhdocutipo(String clhdocutipo) {
        this.clhdocutipo = clhdocutipo;
    }

    public String getClhdocunro() {
        return clhdocunro;
    }

    public void setClhdocunro(String clhdocunro) {
        this.clhdocunro = clhdocunro;
    }

    public String getClhsexo() {
        return clhsexo;
    }

    public void setClhsexo(String clhsexo) {
        this.clhsexo = clhsexo;
    }

    public String getClhfechanacimiento() {
        return clhfechanacimiento;
    }

    public void setClhfechanacimiento(String clhfechanacimiento) {
        this.clhfechanacimiento = clhfechanacimiento;
    }

    public String getClhlugarnacimiento() {
        return clhlugarnacimiento;
    }

    public void setClhlugarnacimiento(String clhlugarnacimiento) {
        this.clhlugarnacimiento = clhlugarnacimiento;
    }

    public String getClhestadocivil() {
        return clhestadocivil;
    }

    public void setClhestadocivil(String clhestadocivil) {
        this.clhestadocivil = clhestadocivil;
    }

    public String getClhpep() {
        return clhpep;
    }

    public void setClhpep(String clhpep) {
        this.clhpep = clhpep;
    }

    public String getClhpepcondicion() {
        return clhpepcondicion;
    }

    public void setClhpepcondicion(String clhpepcondicion) {
        this.clhpepcondicion = clhpepcondicion;
    }

    public String getClhnacionalidad() {
        return clhnacionalidad;
    }

    public void setClhnacionalidad(String clhnacionalidad) {
        this.clhnacionalidad = clhnacionalidad;
    }

    public String getClhcuit() {
        return clhcuit;
    }

    public void setClhcuit(String clhcuit) {
        this.clhcuit = clhcuit;
    }

    public String getClhrsocial() {
        return clhrsocial;
    }

    public void setClhrsocial(String clhrsocial) {
        this.clhrsocial = clhrsocial;
    }

    public String getClhinscripregistral() {
        return clhinscripregistral;
    }

    public void setClhinscripregistral(String clhinscripregistral) {
        this.clhinscripregistral = clhinscripregistral;
    }

    public String getClhcontrconstlugfec() {
        return clhcontrconstlugfec;
    }

    public void setClhcontrconstlugfec(String clhcontrconstlugfec) {
        this.clhcontrconstlugfec = clhcontrconstlugfec;
    }

    public String getClhcontrconstfecinsc() {
        return clhcontrconstfecinsc;
    }

    public void setClhcontrconstfecinsc(String clhcontrconstfecinsc) {
        this.clhcontrconstfecinsc = clhcontrconstfecinsc;
    }

    public String getClhcontrconstobjeto() {
        return clhcontrconstobjeto;
    }

    public void setClhcontrconstobjeto(String clhcontrconstobjeto) {
        this.clhcontrconstobjeto = clhcontrconstobjeto;
    }

    public String getClhcontrconstduracion() {
        return clhcontrconstduracion;
    }

    public void setClhcontrconstduracion(String clhcontrconstduracion) {
        this.clhcontrconstduracion = clhcontrconstduracion;
    }

    public String getClhocupacion() {
        return clhocupacion;
    }

    public void setClhocupacion(String clhocupacion) {
        this.clhocupacion = clhocupacion;
    }

    public String getClhmontomax() {
        return clhmontomax;
    }

    public void setClhmontomax(String clhmontomax) {
        this.clhmontomax = clhmontomax;
    }

    public String getClhpersonahumana() {
        return clhpersonahumana;
    }

    public void setClhpersonahumana(String clhpersonahumana) {
        this.clhpersonahumana = clhpersonahumana;
    }

    public String getClhrepresentante() {
        return clhrepresentante;
    }

    public void setClhrepresentante(String clhrepresentante) {
        this.clhrepresentante = clhrepresentante;
    }

    public String getClhfuncionario() {
        return clhfuncionario;
    }

    public void setClhfuncionario(String clhfuncionario) {
        this.clhfuncionario = clhfuncionario;
    }

    public String getClhsegmento() {
        return clhsegmento;
    }

    public void setClhsegmento(String clhsegmento) {
        this.clhsegmento = clhsegmento;
    }

    public String getClhfechaalta() {
        return clhfechaalta;
    }

    public void setClhfechaalta(String clhfechaalta) {
        this.clhfechaalta = clhfechaalta;
    }

    public int getClhdeid() {
        return clhdeid;
    }

    public void setClhdeid(int clhdeid) {
        this.clhdeid = clhdeid;
    }

    public String getClhdetelefono() {
        return clhdetelefono;
    }

    public void setClhdetelefono(String clhdetelefono) {
        this.clhdetelefono = clhdetelefono;
    }

    public String getClhdetelefonomovi() {
        return clhdetelefonomovi;
    }

    public void setClhdetelefonomovi(String clhdetelefonomovi) {
        this.clhdetelefonomovi = clhdetelefonomovi;
    }

    public String getClhdemail() {
        return clhdemail;
    }

    public void setClhdemail(String clhdemail) {
        this.clhdemail = clhdemail;
    }

    public String getClhdenis() {
        return clhdenis;
    }

    public void setClhdenis(String clhdenis) {
        this.clhdenis = clhdenis;
    }

    public String getClhdecodoperador() {
        return clhdecodoperador;
    }

    public void setClhdecodoperador(String clhdecodoperador) {
        this.clhdecodoperador = clhdecodoperador;
    }

    public String getClhdemontomax() {
        return clhdemontomax;
    }

    public void setClhdemontomax(String clhdemontomax) {
        this.clhdemontomax = clhdemontomax;
    }

    public String getClhdeobservaciones() {
        return clhdeobservaciones;
    }

    public void setClhdeobservaciones(String clhdeobservaciones) {
        this.clhdeobservaciones = clhdeobservaciones;
    }

    public String getClhdeoperador() {
        return clhdeoperador;
    }

    public void setClhdeoperador(String clhdeoperador) {
        this.clhdeoperador = clhdeoperador;
    }

    public String getClhdedocoperador() {
        return clhdedocoperador;
    }

    public void setClhdedocoperador(String clhdedocoperador) {
        this.clhdedocoperador = clhdedocoperador;
    }

    public String getClhdefechaconfeccionficha() {
        return clhdefechaconfeccionficha;
    }

    public void setClhdefechaconfeccionficha(String clhdefechaconfeccionficha) {
        this.clhdefechaconfeccionficha = clhdefechaconfeccionficha;
    }

    public String getClhdefechaalta() {
        return clhdefechaalta;
    }

    public void setClhdefechaalta(String clhdefechaalta) {
        this.clhdefechaalta = clhdefechaalta;
    }

    public String getClhdefechamodificacion() {
        return clhdefechamodificacion;
    }

    public void setClhdefechamodificacion(String clhdefechamodificacion) {
        this.clhdefechamodificacion = clhdefechamodificacion;
    }

    public String getClhdeusuarioclh() {
        return clhdeusuarioclh;
    }

    public void setClhdeusuarioclh(String clhdeusuarioclh) {
        this.clhdeusuarioclh = clhdeusuarioclh;
    }

    public String getClhdeusuarioseccionpc() {
        return clhdeusuarioseccionpc;
    }

    public void setClhdeusuarioseccionpc(String clhdeusuarioseccionpc) {
        this.clhdeusuarioseccionpc = clhdeusuarioseccionpc;
    }

    public int getClhdiid() {
        return clhdiid;
    }

    public void setClhdiid(int clhdiid) {
        this.clhdiid = clhdiid;
    }

    public String getClhdicalle() {
        return clhdicalle;
    }

    public void setClhdicalle(String clhdicalle) {
        this.clhdicalle = clhdicalle;
    }

    public String getClhdinrocalle() {
        return clhdinrocalle;
    }

    public void setClhdinrocalle(String clhdinrocalle) {
        this.clhdinrocalle = clhdinrocalle;
    }

    public String getClhdipiso() {
        return clhdipiso;
    }

    public void setClhdipiso(String clhdipiso) {
        this.clhdipiso = clhdipiso;
    }

    public String getClhdidpto() {
        return clhdidpto;
    }

    public void setClhdidpto(String clhdidpto) {
        this.clhdidpto = clhdidpto;
    }

    public String getClhdilocalidad() {
        return clhdilocalidad;
    }

    public void setClhdilocalidad(String clhdilocalidad) {
        this.clhdilocalidad = clhdilocalidad;
    }

    public String getClhdiciudad() {
        return clhdiciudad;
    }

    public void setClhdiciudad(String clhdiciudad) {
        this.clhdiciudad = clhdiciudad;
    }

    public String getClhdicodpostal() {
        return clhdicodpostal;
    }

    public void setClhdicodpostal(String clhdicodpostal) {
        this.clhdicodpostal = clhdicodpostal;
    }

    public String getClhdiprovincia() {
        return clhdiprovincia;
    }

    public void setClhdiprovincia(String clhdiprovincia) {
        this.clhdiprovincia = clhdiprovincia;
    }

    public String getClhdipaisresidencia() {
        return clhdipaisresidencia;
    }

    public void setClhdipaisresidencia(String clhdipaisresidencia) {
        this.clhdipaisresidencia = clhdipaisresidencia;
    }

    public String getClhco_id() {
        return clhco_id;
    }

    public void setClhco_id(String clhco_id) {
        this.clhco_id = clhco_id;
    }

    public String getClhco_apellido_conyugue() {
        return clhco_apellido_conyugue;
    }

    public void setClhco_apellido_conyugue(String clhco_apellido_conyugue) {
        this.clhco_apellido_conyugue = clhco_apellido_conyugue;
    }

    public String getClhco_nombre_conyugue() {
        return clhco_nombre_conyugue;
    }

    public void setClhco_nombre_conyugue(String clhco_nombre_conyugue) {
        this.clhco_nombre_conyugue = clhco_nombre_conyugue;
    }

    public String getClhco_docu_tipo_conyugue() {
        return clhco_docu_tipo_conyugue;
    }

    public void setClhco_docu_tipo_conyugue(String clhco_docu_tipo_conyugue) {
        this.clhco_docu_tipo_conyugue = clhco_docu_tipo_conyugue;
    }

    public String getClhco_docu_nro_conyugue() {
        return clhco_docu_nro_conyugue;
    }

    public void setClhco_docu_nro_conyugue(String clhco_docu_nro_conyugue) {
        this.clhco_docu_nro_conyugue = clhco_docu_nro_conyugue;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDocutipodescrip() {
        return docutipodescrip;
    }

    public void setDocutipodescrip(String docutipodescrip) {
        this.docutipodescrip = docutipodescrip;
    }
    
    
    
    
}
