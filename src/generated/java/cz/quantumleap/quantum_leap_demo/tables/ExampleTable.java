/*
 * This file is generated by jOOQ.
 */
package cz.quantumleap.quantum_leap_demo.tables;


import cz.quantumleap.quantum_leap_demo.Keys;
import cz.quantumleap.quantum_leap_demo.QuantumLeapDemo;
import cz.quantumleap.quantum_leap_demo.tables.records.ExampleRecord;
import org.jooq.*;
import org.jooq.Record;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;

import java.util.Arrays;
import java.util.List;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ExampleTable extends TableImpl<ExampleRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>quantum_leap_demo.example</code>
     */
    public static final ExampleTable EXAMPLE = new ExampleTable();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ExampleRecord> getRecordType() {
        return ExampleRecord.class;
    }

    /**
     * The column <code>quantum_leap_demo.example.id</code>.
     */
    public final TableField<ExampleRecord, Long> ID = createField(DSL.name("id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>quantum_leap_demo.example.text_field</code>.
     */
    public final TableField<ExampleRecord, String> TEXT_FIELD = createField(DSL.name("text_field"), SQLDataType.VARCHAR.nullable(false), this, "");

    /**
     * The column <code>quantum_leap_demo.example.enum_field</code>.
     */
    public final TableField<ExampleRecord, String> ENUM_FIELD = createField(DSL.name("enum_field"), SQLDataType.VARCHAR.nullable(false), this, "");

    /**
     * The column <code>quantum_leap_demo.example.set_field</code>.
     */
    public final TableField<ExampleRecord, String[]> SET_FIELD = createField(DSL.name("set_field"), SQLDataType.VARCHAR.getArrayDataType(), this, "");

    /**
     * The column <code>quantum_leap_demo.example.lookup_field</code>.
     */
    public final TableField<ExampleRecord, Long> LOOKUP_FIELD = createField(DSL.name("lookup_field"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>quantum_leap_demo.example.json_field</code>.
     */
    public final TableField<ExampleRecord, JSON> JSON_FIELD = createField(DSL.name("json_field"), SQLDataType.JSON.nullable(false).defaultValue(DSL.field("'{}'::json", SQLDataType.JSON)), this, "");

    private ExampleTable(Name alias, Table<ExampleRecord> aliased) {
        this(alias, aliased, null);
    }

    private ExampleTable(Name alias, Table<ExampleRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>quantum_leap_demo.example</code> table reference
     */
    public ExampleTable(String alias) {
        this(DSL.name(alias), EXAMPLE);
    }

    /**
     * Create an aliased <code>quantum_leap_demo.example</code> table reference
     */
    public ExampleTable(Name alias) {
        this(alias, EXAMPLE);
    }

    /**
     * Create a <code>quantum_leap_demo.example</code> table reference
     */
    public ExampleTable() {
        this(DSL.name("example"), null);
    }

    public <O extends Record> ExampleTable(Table<O> child, ForeignKey<O, ExampleRecord> key) {
        super(child, key, EXAMPLE);
    }

    @Override
    public Schema getSchema() {
        return QuantumLeapDemo.QUANTUM_LEAP_DEMO;
    }

    @Override
    public Identity<ExampleRecord, Long> getIdentity() {
        return (Identity<ExampleRecord, Long>) super.getIdentity();
    }

    @Override
    public UniqueKey<ExampleRecord> getPrimaryKey() {
        return Keys.EXAMPLE_PKEY;
    }

    @Override
    public List<UniqueKey<ExampleRecord>> getKeys() {
        return Arrays.<UniqueKey<ExampleRecord>>asList(Keys.EXAMPLE_PKEY);
    }

    @Override
    public ExampleTable as(String alias) {
        return new ExampleTable(DSL.name(alias), this);
    }

    @Override
    public ExampleTable as(Name alias) {
        return new ExampleTable(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public ExampleTable rename(String name) {
        return new ExampleTable(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public ExampleTable rename(Name name) {
        return new ExampleTable(name, null);
    }

    // -------------------------------------------------------------------------
    // Row6 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row6<Long, String, String, String[], Long, JSON> fieldsRow() {
        return (Row6) super.fieldsRow();
    }
}
