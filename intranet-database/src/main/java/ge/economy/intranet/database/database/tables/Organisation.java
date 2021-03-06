/**
 * This class is generated by jOOQ
 */
package ge.economy.intranet.database.database.tables;


import ge.economy.intranet.database.database.Keys;
import ge.economy.intranet.database.database.Public;
import ge.economy.intranet.database.database.tables.records.OrganisationRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Identity;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.TableImpl;


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
public class Organisation extends TableImpl<OrganisationRecord> {

	private static final long serialVersionUID = -1366878703;

	/**
	 * The reference instance of <code>public.organisation</code>
	 */
	public static final Organisation ORGANISATION = new Organisation();

	/**
	 * The class holding records for this type
	 */
	@Override
	public Class<OrganisationRecord> getRecordType() {
		return OrganisationRecord.class;
	}

	/**
	 * The column <code>public.organisation.id</code>.
	 */
	public final TableField<OrganisationRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>public.organisation.name</code>.
	 */
	public final TableField<OrganisationRecord, String> NAME = createField("name", org.jooq.impl.SQLDataType.VARCHAR, this, "");

	/**
	 * The column <code>public.organisation.domain</code>.
	 */
	public final TableField<OrganisationRecord, String> DOMAIN = createField("domain", org.jooq.impl.SQLDataType.VARCHAR, this, "");

	/**
	 * The column <code>public.organisation.dc_name</code>.
	 */
	public final TableField<OrganisationRecord, String> DC_NAME = createField("dc_name", org.jooq.impl.SQLDataType.VARCHAR, this, "");

	/**
	 * The column <code>public.organisation.parent_tree_id</code>.
	 */
	public final TableField<OrganisationRecord, Integer> PARENT_TREE_ID = createField("parent_tree_id", org.jooq.impl.SQLDataType.INTEGER, this, "");

	/**
	 * The column <code>public.organisation.username</code>.
	 */
	public final TableField<OrganisationRecord, String> USERNAME = createField("username", org.jooq.impl.SQLDataType.VARCHAR, this, "");

	/**
	 * The column <code>public.organisation.password</code>.
	 */
	public final TableField<OrganisationRecord, String> PASSWORD = createField("password", org.jooq.impl.SQLDataType.VARCHAR, this, "");

	/**
	 * The column <code>public.organisation.mail</code>.
	 */
	public final TableField<OrganisationRecord, String> MAIL = createField("mail", org.jooq.impl.SQLDataType.VARCHAR, this, "");

	/**
	 * The column <code>public.organisation.ldap_server_url</code>.
	 */
	public final TableField<OrganisationRecord, String> LDAP_SERVER_URL = createField("ldap_server_url", org.jooq.impl.SQLDataType.VARCHAR, this, "");

	/**
	 * Create a <code>public.organisation</code> table reference
	 */
	public Organisation() {
		this("organisation", null);
	}

	/**
	 * Create an aliased <code>public.organisation</code> table reference
	 */
	public Organisation(String alias) {
		this(alias, ORGANISATION);
	}

	private Organisation(String alias, Table<OrganisationRecord> aliased) {
		this(alias, aliased, null);
	}

	private Organisation(String alias, Table<OrganisationRecord> aliased, Field<?>[] parameters) {
		super(alias, Public.PUBLIC, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Identity<OrganisationRecord, Integer> getIdentity() {
		return Keys.IDENTITY_ORGANISATION;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UniqueKey<OrganisationRecord> getPrimaryKey() {
		return Keys.ORGANISATION_PKEY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<UniqueKey<OrganisationRecord>> getKeys() {
		return Arrays.<UniqueKey<OrganisationRecord>>asList(Keys.ORGANISATION_PKEY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Organisation as(String alias) {
		return new Organisation(alias, this);
	}

	/**
	 * Rename this table
	 */
	public Organisation rename(String name) {
		return new Organisation(name, null);
	}
}
