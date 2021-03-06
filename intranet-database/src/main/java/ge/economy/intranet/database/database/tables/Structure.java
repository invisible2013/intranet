/**
 * This class is generated by jOOQ
 */
package ge.economy.intranet.database.database.tables;


import ge.economy.intranet.database.database.Keys;
import ge.economy.intranet.database.database.Public;
import ge.economy.intranet.database.database.tables.records.StructureRecord;

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
public class Structure extends TableImpl<StructureRecord> {

	private static final long serialVersionUID = 256257635;

	/**
	 * The reference instance of <code>public.structure</code>
	 */
	public static final Structure STRUCTURE = new Structure();

	/**
	 * The class holding records for this type
	 */
	@Override
	public Class<StructureRecord> getRecordType() {
		return StructureRecord.class;
	}

	/**
	 * The column <code>public.structure.id</code>.
	 */
	public final TableField<StructureRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>public.structure.parent_id</code>.
	 */
	public final TableField<StructureRecord, Integer> PARENT_ID = createField("parent_id", org.jooq.impl.SQLDataType.INTEGER, this, "");

	/**
	 * The column <code>public.structure.organisation_id</code>.
	 */
	public final TableField<StructureRecord, Integer> ORGANISATION_ID = createField("organisation_id", org.jooq.impl.SQLDataType.INTEGER, this, "");

	/**
	 * The column <code>public.structure.name</code>.
	 */
	public final TableField<StructureRecord, String> NAME = createField("name", org.jooq.impl.SQLDataType.VARCHAR, this, "");

	/**
	 * The column <code>public.structure.description</code>.
	 */
	public final TableField<StructureRecord, String> DESCRIPTION = createField("description", org.jooq.impl.SQLDataType.VARCHAR, this, "");

	/**
	 * The column <code>public.structure.ldap_key</code>.
	 */
	public final TableField<StructureRecord, String> LDAP_KEY = createField("ldap_key", org.jooq.impl.SQLDataType.VARCHAR, this, "");

	/**
	 * The column <code>public.structure.visible</code>.
	 */
	public final TableField<StructureRecord, Boolean> VISIBLE = createField("visible", org.jooq.impl.SQLDataType.BOOLEAN, this, "");

	/**
	 * Create a <code>public.structure</code> table reference
	 */
	public Structure() {
		this("structure", null);
	}

	/**
	 * Create an aliased <code>public.structure</code> table reference
	 */
	public Structure(String alias) {
		this(alias, STRUCTURE);
	}

	private Structure(String alias, Table<StructureRecord> aliased) {
		this(alias, aliased, null);
	}

	private Structure(String alias, Table<StructureRecord> aliased, Field<?>[] parameters) {
		super(alias, Public.PUBLIC, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Identity<StructureRecord, Integer> getIdentity() {
		return Keys.IDENTITY_STRUCTURE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UniqueKey<StructureRecord> getPrimaryKey() {
		return Keys.STRUCTURE_PKEY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<UniqueKey<StructureRecord>> getKeys() {
		return Arrays.<UniqueKey<StructureRecord>>asList(Keys.STRUCTURE_PKEY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Structure as(String alias) {
		return new Structure(alias, this);
	}

	/**
	 * Rename this table
	 */
	public Structure rename(String name) {
		return new Structure(name, null);
	}
}
