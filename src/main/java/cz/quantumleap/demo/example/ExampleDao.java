package cz.quantumleap.demo.example;

import cz.quantumleap.core.database.DaoStub;
import cz.quantumleap.core.database.EntityRegistry;
import cz.quantumleap.core.database.entity.Entity;
import cz.quantumleap.core.database.entity.EntityIdentifier;
import cz.quantumleap.core.slicequery.SliceQueryDao;
import cz.quantumleap.quantum_leap_demo.tables.ExampleTable;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import static cz.quantumleap.core.database.query.QueryUtils.startsWithIgnoreCase;
import static cz.quantumleap.core.tables.PersonTable.PERSON;
import static cz.quantumleap.quantum_leap_demo.tables.ExampleTable.EXAMPLE;

@Repository
public class ExampleDao extends DaoStub<ExampleTable> {

    protected ExampleDao(DSLContext dslContext, EntityRegistry entityRegistry, SliceQueryDao sliceQueryDao) {
        super(createEntity(), dslContext, entityRegistry, sliceQueryDao);
    }

    private static Entity<ExampleTable> createEntity() {
        return Entity.builder(EXAMPLE)
                .setLookupLabelField(EXAMPLE.TEXT_FIELD)
                .addEnumMetaType(EXAMPLE.ENUM_FIELD, "EXAMPLE_ENUM")
                .addSetMetaType(EXAMPLE.SET_FIELD, "EXAMPLE_ENUM")
                .addLookupMetaType(EXAMPLE.LOOKUP_FIELD, EntityIdentifier.forTable(PERSON))
                .setWordConditionBuilder(ExampleDao::createWordCondition)
                .setDefaultSliceFieldNames("id", "text_field", "enum_field", "set_field", "lookup_field")
                .build();
    }

    private static Condition createWordCondition(String text) {
        return startsWithIgnoreCase(EXAMPLE.TEXT_FIELD, text);
    }
}
