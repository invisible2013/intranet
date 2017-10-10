/**
 * This class is generated by jOOQ
 */
package ge.economy.intranet.database.database.tables.records;


import ge.economy.intranet.database.database.tables.Organisation;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record9;
import org.jooq.Row9;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.7.3"
	},
	comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class OrganisationRecord extends UpdatableRecordImpl<OrganisationRecord> implements Record9<Integer, String, String, String, Integer, String, String, String, String> {

	private static final long serialVersionUID = 645469400;

	/**
	 * Setter for <code>public.organisation.id</code>.
	 */
	public void setId(Integer value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>public.organisation.id</code>.
	 */
	public Integer getId() {
		return (Integer) getValue(0);
	}

	/**
	 * Setter for <code>public.organisation.name</code>.
	 */
	public void setName(String value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>public.organisation.name</code>.
	 */
	public String getName() {
		return (String) getValue(1);
	}

	/**
	 * Setter for <code>public.organisation.domain</code>.
	 */
	public void setDomain(String value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>public.organisation.domain</code>.
	 */
	public String getDomain() {
		return (String) getValue(2);
	}

	/**
	 * Setter for <code>public.organisation.dc_name</code>.
	 */
	public void setDcName(String value) {
		setValue(3, value);
	}

	/**
	 * Getter for <code>public.organisation.dc_name</code>.
	 */
	public String getDcName() {
		return (String) getValue(3);
	}

	/**
	 * Setter for <code>public.organisation.parent_tree_id</code>.
	 */
	public void setParentTreeId(Integer value) {
		setValue(4, value);
	}

	/**
	 * Getter for <code>public.organisation.parent_tree_id</code>.
	 */
	public Integer getParentTreeId() {
		return (Integer) getValue(4);
	}

	/**
	 * Setter for <code>public.organisation.username</code>.
	 */
	public void setUsername(String value) {
		setValue(5, value);
	}

	/**
	 * Getter for <code>public.organisation.username</code>.
	 */
	public String getUsername() {
		return (String) getValue(5);
	}

	/**
	 * Setter for <code>public.organisation.password</code>.
	 */
	public void setPassword(String value) {
		setValue(6, value);
	}

	/**
	 * Getter for <code>public.organisation.password</code>.
	 */
	public String getPassword() {
		return (String) getValue(6);
	}

	/**
	 * Setter for <code>public.organisation.mail</code>.
	 */
	public void setMail(String value) {
		setValue(7, value);
	}

	/**
	 * Getter for <code>public.organisation.mail</code>.
	 */
	public String getMail() {
		return (String) getValue(7);
	}

	/**
	 * Setter for <code>public.organisation.ldap_server_url</code>.
	 */
	public void setLdapServerUrl(String value) {
		setValue(8, value);
	}

	/**
	 * Getter for <code>public.organisation.ldap_server_url</code>.
	 */
	public String getLdapServerUrl() {
		return (String) getValue(8);
	}

	// -------------------------------------------------------------------------
	// Primary key information
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Record1<Integer> key() {
		return (Record1) super.key();
	}

	// -------------------------------------------------------------------------
	// Record9 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row9<Integer, String, String, String, Integer, String, String, String, String> fieldsRow() {
		return (Row9) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row9<Integer, String, String, String, Integer, String, String, String, String> valuesRow() {
		return (Row9) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field1() {
		return Organisation.ORGANISATION.ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field2() {
		return Organisation.ORGANISATION.NAME;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field3() {
		return Organisation.ORGANISATION.DOMAIN;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field4() {
		return Organisation.ORGANISATION.DC_NAME;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field5() {
		return Organisation.ORGANISATION.PARENT_TREE_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field6() {
		return Organisation.ORGANISATION.USERNAME;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field7() {
		return Organisation.ORGANISATION.PASSWORD;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field8() {
		return Organisation.ORGANISATION.MAIL;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field9() {
		return Organisation.ORGANISATION.LDAP_SERVER_URL;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer value1() {
		return getId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value2() {
		return getName();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value3() {
		return getDomain();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value4() {
		return getDcName();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer value5() {
		return getParentTreeId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value6() {
		return getUsername();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value7() {
		return getPassword();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value8() {
		return getMail();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value9() {
		return getLdapServerUrl();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public OrganisationRecord value1(Integer value) {
		setId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public OrganisationRecord value2(String value) {
		setName(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public OrganisationRecord value3(String value) {
		setDomain(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public OrganisationRecord value4(String value) {
		setDcName(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public OrganisationRecord value5(Integer value) {
		setParentTreeId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public OrganisationRecord value6(String value) {
		setUsername(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public OrganisationRecord value7(String value) {
		setPassword(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public OrganisationRecord value8(String value) {
		setMail(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public OrganisationRecord value9(String value) {
		setLdapServerUrl(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public OrganisationRecord values(Integer value1, String value2, String value3, String value4, Integer value5, String value6, String value7, String value8, String value9) {
		value1(value1);
		value2(value2);
		value3(value3);
		value4(value4);
		value5(value5);
		value6(value6);
		value7(value7);
		value8(value8);
		value9(value9);
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached OrganisationRecord
	 */
	public OrganisationRecord() {
		super(Organisation.ORGANISATION);
	}

	/**
	 * Create a detached, initialised OrganisationRecord
	 */
	public OrganisationRecord(Integer id, String name, String domain, String dcName, Integer parentTreeId, String username, String password, String mail, String ldapServerUrl) {
		super(Organisation.ORGANISATION);

		setValue(0, id);
		setValue(1, name);
		setValue(2, domain);
		setValue(3, dcName);
		setValue(4, parentTreeId);
		setValue(5, username);
		setValue(6, password);
		setValue(7, mail);
		setValue(8, ldapServerUrl);
	}
}