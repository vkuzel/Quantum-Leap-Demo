package cz.quantumleap.demo.example;

import cz.quantumleap.core.common.Utils;
import cz.quantumleap.core.data.DaoStub;
import cz.quantumleap.core.data.EnumManager;
import cz.quantumleap.core.data.LookupDaoManager;
import cz.quantumleap.core.data.RecordAuditor;
import cz.quantumleap.core.data.entity.Entity;
import cz.quantumleap.core.data.entity.EntityIdentifier;
import cz.quantumleap.quantum_leap_demo.tables.ExampleTable;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import static cz.quantumleap.core.tables.PersonTable.PERSON;
import static cz.quantumleap.quantum_leap_demo.tables.ExampleTable.EXAMPLE;

@Repository
public class ExampleDao extends DaoStub<ExampleTable> {

    protected ExampleDao(DSLContext dslContext, LookupDaoManager lookupDaoManager, EnumManager enumManager, RecordAuditor recordAuditor) {
        super(createEntity(), dslContext, lookupDaoManager, enumManager, recordAuditor);
    }

    private static Entity<ExampleTable> createEntity() {
        return Entity.createBuilder(EXAMPLE).setLookupLabelField(EXAMPLE.TEXT_FIELD)
                .addFieldLookupMapping(EXAMPLE.LOOKUP_FIELD, EntityIdentifier.forTable(PERSON))
                .setWordConditionBuilder(ExampleDao::createWordCondition)
                .build();
    }

    private static Condition createWordCondition(String text) {
        return Utils.startsWithIgnoreCase(EXAMPLE.TEXT_FIELD, text);
    }
}
