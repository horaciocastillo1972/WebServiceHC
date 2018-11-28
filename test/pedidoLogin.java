
import com.corasa.auth.entidades.Usuario;
import com.corasa.auth.ldap.LdapAuthenticated;
import javax.naming.directory.DirContext;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HCastillo
 */
public class pedidoLogin {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        
        LdapAuthenticated valid = new  LdapAuthenticated();
     
        Usuario cxt = valid.validate("hcastillo", "Sputnik2018%");
        
        System.out.println(cxt.toString());
        
    }
    
}
