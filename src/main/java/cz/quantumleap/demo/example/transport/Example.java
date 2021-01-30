package cz.quantumleap.demo.example.transport;

import cz.quantumleap.core.data.transport.Lookup;
import cz.quantumleap.core.tables.PersonTable;

import javax.validation.constraints.NotNull;
import java.util.Set;

public class Example {

    private Long id;
    @NotNull
    private String textField;
    @NotNull
    private String enumField;
    @NotNull
    private Set<String> setField;
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

    public String getEnumField() {
        return enumField;
    }

    public void setEnumField(String enumField) {
        this.enumField = enumField;
    }

    public Set<String> getSetField() {
        return setField;
    }

    public void setSetField(Set<String> setField) {
        this.setField = setField;
    }

    public Lookup<PersonTable> getLookupField() {
        return lookupField;
    }

    public void setLookupField(Lookup<PersonTable> lookupField) {
        this.lookupField = lookupField;
    }
}
