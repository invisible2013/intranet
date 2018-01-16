package ge.economy.intranet.core.services;

import ge.economy.intranet.core.api.dto.PersonalDTO;
import ge.economy.intranet.core.response.LDAPResponse;
import ge.economy.intranet.database.database.tables.records.PersonalRecord;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import javax.naming.NamingEnumeration;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.InitialLdapContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by NINO on 9/5/2017.
 */
@Service
public class LDAPService {
    @Autowired
    private PersonalService personalService;
    private final String ldapAdServerEconomy = "ldap://economy.ge:389";
    private int ECONOMY_TREE_PARENT_ID = 1;
    private int ENTERPRISE_TREE_PARENT_ID = 56;
    private Logger logger = Logger.getLogger(LDAPService.class);
    private List<String> matchPersonalMails = new ArrayList();

    public void syncronizePersonal(String mail, String ldapPassword) {
        try {
            String[] personalAttrs = {"sn", "mail", "ou", "cn", "uid", "displayName", "userPrincipalName", "telephonenumber", "title", "description", "objectCategory", "distinguishedName", "department"};

            String ldapUsername = "economy\\" + mail.substring(0, mail.indexOf("@"));

            Hashtable<String, String> env = new Hashtable();

            env.put("java.naming.factory.initial", "com.sun.jndi.ldap.LdapCtxFactory");
            env.put("java.naming.provider.url", "ldap://economy.ge:389");
            env.put("java.naming.security.authentication", "simple");
            env.put("java.naming.security.principal", ldapUsername);
            env.put("java.naming.security.credentials", ldapPassword);

            DirContext ctx = new InitialLdapContext(env, null);

            SearchControls searchCtls = new SearchControls();
            searchCtls.setReturningAttributes(personalAttrs);
            searchCtls.setSearchScope(2);

            String searchFilter = "(&(objectClass=user))";
            String searchBase = "DC=economy,DC=ge";

            NamingEnumeration answer = ctx.search(searchBase, searchFilter, searchCtls);

            List<LDAPResponse> responses = new ArrayList();
            LDAPResponse response;
            while (answer.hasMoreElements()) {
                response = new LDAPResponse();
                SearchResult searchResult = (SearchResult) answer.next();
                response.setNameInNamespace(searchResult.getNameInNamespace());
                String[] resultArray = searchResult.getNameInNamespace().split(",");
                int counter = 0;
                for (String resultItem : resultArray) {
                    if ("OU".equals(resultItem.split("=")[0])) {
                        if (counter == 0) {
                            response.setFirstOU(resultItem.split("=")[1]);
                            counter++;
                        } else {
                            response.setSecondOU(response.getFirstOU());
                            response.setFirstOU(resultItem.split("=")[1]);
                            counter = 0;
                        }
                    }
                }
                Attributes ldapUserAttrs = searchResult.getAttributes();
                if ((ldapUserAttrs != null) &&
                        (ldapUserAttrs.get("userPrincipalName") != null) &&
                        (ldapUserAttrs.get("title") != null)) {
                    if (ldapUserAttrs.get("cn") != null) {
                        response.setCn(ldapUserAttrs.get("cn").get().toString());
                    }
                    if (ldapUserAttrs.get("userPrincipalName") != null) {
                        response.setMail(ldapUserAttrs.get("userPrincipalName").get().toString());
                    }
                    if (ldapUserAttrs.get("title") != null) {
                        response.setTitle(ldapUserAttrs.get("title").get().toString());
                    }
                    if (ldapUserAttrs.get("telephonenumber") != null) {
                        response.setTelephoneNumber(ldapUserAttrs.get("telephonenumber").get().toString());
                    }
                    responses.add(response);
                }
            }
            for (LDAPResponse lDapResponse : responses) {
                savePersonalInfoFromLDAP(lDapResponse, 1, ECONOMY_TREE_PARENT_ID);
            }
            ctx.close();
            inactiveUsers(this.ECONOMY_TREE_PARENT_ID);
        } catch (Exception e) {
            int a = 5;
            this.logger.error(e);
        }
    }

    public void savePersonalInfoFromLDAP(LDAPResponse response, int structureId, int organisationId)
            throws Exception {
        try {
            PersonalRecord _personal = new PersonalRecord();
            if ((response.getCn() != null) && (response.getCn().length() > 1)) {
                _personal.setFirstName(response.getCn().substring(0, response.getCn().indexOf(" ")));
                _personal.setLastName(response.getCn().substring(response.getCn().indexOf(" ")));
            }
            this.matchPersonalMails.add(response.getMail());
            _personal.setMail(response.getMail());
            _personal.setPositionId(Integer.valueOf(7));
            _personal.setGroupId(Integer.valueOf(PersonalDTO.USER_GROUP));
            _personal.setStructureId(Integer.valueOf(structureId));
            _personal.setOrganisationId(Integer.valueOf(organisationId));
            _personal.setStatusId(Integer.valueOf(PersonalDTO.ACTIVE_PERSONAL));
            this.personalService.savePersonal(_personal);
        } catch (Exception ex) {
            this.logger.error(ex);
        }
    }

    public PersonalDTO ldapAuthorisation(String mail, String ldapPassword) throws Exception {
        try {
            String userName = mail.substring(0, mail.indexOf("@"));
            String domain = mail.substring(mail.indexOf("@") + 1, mail.length());
            Hashtable<String, String> env = new Hashtable();
            String ldapServer = "";
            String ldapUsername = "";
            int organisationId = 1;
            boolean isEconomy = false;
            if (domain.equals("economy.ge") || domain.equals("moesd.gov.ge")) {
                ldapServer = "ldap://economy.ge:389";
                ldapUsername = "economy\\" + userName;
                isEconomy = true;
            } else if (domain.equals("enterprise.gov.loc")) {
                ldapServer = "ldap://enterprise.gov.loc:389";
                ldapUsername = "enterprise\\" + userName;
                organisationId = 2;
            } else {
                throw new Exception("username or password incorrect");
            }

            env.put("java.naming.factory.initial", "com.sun.jndi.ldap.LdapCtxFactory");
            env.put("java.naming.provider.url", ldapServer);
            env.put("java.naming.security.authentication", "simple");
            env.put("java.naming.security.principal", ldapUsername);
            env.put("java.naming.security.credentials", ldapPassword);

            DirContext ctx = new InitialLdapContext(env, null);

            PersonalDTO p = personalService.getPersonalByMail(mail);
            String personalEmail = mail;
            if (p == null && isEconomy) {
                if (domain.equals("economy.ge")) {
                    p = personalService.getPersonalByMail(userName + "@moesd.gov.ge");
                } else {
                    p = personalService.getPersonalByMail(userName + "@economy.ge");
                }
            }
            if (p == null) {
                personalService.addBasePersonalByMail(mail, organisationId);
            } else {
                personalEmail = p.getMail();
            }
            return personalService.getPersonalByMail(personalEmail);
        } catch (Exception ex) {
            logger.error(ex);
            throw new Exception("username or password incorrect");
        }
    }

    public PersonalDTO ldapAuth(String mail, String ldapPassword)
            throws Exception {
        try {
            String userName = mail.substring(0, mail.indexOf("@"));
            String ldapServer = "ldap://economy.ge:389";
            String ldapUsername = "economy\\" + userName;
            Hashtable<String, String> env = new Hashtable();

            env.put("java.naming.factory.initial", "com.sun.jndi.ldap.LdapCtxFactory");
            env.put("java.naming.provider.url", ldapServer);
            env.put("java.naming.security.authentication", "simple");
            env.put("java.naming.security.principal", ldapUsername);
            env.put("java.naming.security.credentials", ldapPassword);

            DirContext ctx = new InitialLdapContext(env, null);
            PersonalDTO p = this.personalService.getPersonalByMail(mail);
            if (p == null) {
                this.personalService.addBasePersonalByMail(mail, PersonalDTO.ORGANISATION_ECONOMY);
            }
            return this.personalService.getPersonalByMail(mail);
        } catch (Exception ex) {
            this.logger.error(ex);
            throw new Exception("username or password incorrect");
        }
    }

    public void inactiveUsers(int organisationId) {
        if ((this.matchPersonalMails != null) && (this.matchPersonalMails.size() > 0)) {
            this.personalService.inactivePersonal(this.matchPersonalMails, organisationId);
        }
    }

    public List<String> getMatchPersonalMails() {
        return this.matchPersonalMails;
    }

    public void setMatchPersonalMails(List<String> matchPersonalMails) {
        this.matchPersonalMails = matchPersonalMails;
    }
}
