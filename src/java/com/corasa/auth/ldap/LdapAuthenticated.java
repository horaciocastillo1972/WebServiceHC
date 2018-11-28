/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.corasa.auth.ldap;

import com.corasa.auth.entidades.Usuario;
import com.sun.jndi.ldap.LdapCtxFactory;
import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import static javax.naming.directory.SearchControls.SUBTREE_SCOPE;
import javax.naming.directory.SearchResult;

/**
 *
 * @author HCastillo
 */
public class LdapAuthenticated {

    static final String domain_name = "correo.local";
    static final String LDAP_URL = "ldap://" + domain_name;

    public Usuario validate(String username, String password) throws Exception{
        Usuario user = new Usuario();;
        Hashtable env = new Hashtable();

        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, LDAP_URL);
        //env.put(Context.SECURITY_AUTHENTICATION, "GSSAPI");
        //env.put("java.naming.ldap.attributes.binary", "objectSID");
        env.put(Context.SECURITY_PRINCIPAL, username + "@" + domain_name);
        env.put(Context.SECURITY_CREDENTIALS, password);

        try {
            DirContext ctx; //new InitialDirContext(env);    
            ctx = new InitialDirContext(env);
            //ctx = LdapCtxFactory.getLdapCtxInstance(LDAP_URL, env);
            user.setbValid(true);
            SearchControls controls = new SearchControls();
            controls.setSearchScope(SUBTREE_SCOPE);
            NamingEnumeration<SearchResult> renum = ctx.search(toDC(domain_name),
                    "(& (userPrincipalName=" + username + "@" + domain_name + ")(objectClass=user))",
                    controls);
            SearchResult result = renum.next();
            Attributes a = result.getAttributes(); // retorna los atributos.

            user.setDisplayName(a.get("cn").get().toString());
            user.setEmail(a.get("mail").get().toString());
            user.setDisplayName(a.get("displayname").get().toString());
            user.setSamAccountName(a.get("samaccountname").get().toString());
            user.setUserPrincipalName(a.get("userprincipalname").get().toString());

            /* cargo la lista de grupos */
            Attribute  memberOf =  result.getAttributes().get("memberOf");
            if (memberOf != null) {// null if this user belongs to no group at
                // all
                String [] mem = new String[memberOf.size()];
                for (int i = 0; i < memberOf.size(); i++) {
                    Attributes  atts = ctx.getAttributes(memberOf.get(i).toString(), new String[] { "CN" });
                    mem[i] = atts.get("CN").get().toString();
                }
                
                user.setMemerof(mem);

            }

        } catch (NamingException e) {
            user.setbValid(false);
            user.setSzError(e.getMessage());
            e.printStackTrace();
            return user;
        } catch (Exception ex) {
            user.setbValid(false);
            user.setSzError(ex.getMessage());
            ex.getMessage();
            return user;
        }
        System.out.println(user.toString());
        return user;
    }

    private String toDC(String domainName) {
        StringBuilder buf = new StringBuilder();
        for (String token : domainName.split("\\.")) {
            if (token.length() == 0) {
                continue; // defensive check
            }
            if (buf.length() > 0) {
                buf.append(",");
            }
            buf.append("DC=").append(token);
        }
        return buf.toString();
    }
}
