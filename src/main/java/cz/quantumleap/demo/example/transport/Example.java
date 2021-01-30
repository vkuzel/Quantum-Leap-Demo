package cz.quantumleap.demo.example.transport;

import cz.quantumleap.core.data.transport.EnumValue;
import cz.quantumleap.core.data.transport.Lookup;
import cz.quantumleap.core.data.transport.SetValues;
import cz.quantumleap.core.tables.PersonTable;

import javax.validation.constraints.NotNull;

public class Example {

    private Long id;
    @NotNull
    private String textField;
    @NotNull
    private EnumValue enumField = new EnumValue();
    @NotNull
    private SetValues setField = new SetValues();
    @NotNull
    private Lookup<PersonTable> lookupField = new Lookup<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTextField() {
        return textField;
    }

    public void setTextField(String textField) {
        this.textField = textField;
    }

    public EnumValue getEnumField() {
        return enumField;
    }

    public void setEnumField(EnumValue enumField) {
        this.enumField = enumField;
    }

    public SetValues getSetField() {
        return setField;
    }

    public void setSetField(SetValues setField) {
        this.setField = setField;
    }

    public Lookup<PersonTable> getLookupField() {
        return lookupField;
    }

    public void setLookupField(Lookup<PersonTable> lookupField) {
        this.lookupField = lookupField;
    }
}
