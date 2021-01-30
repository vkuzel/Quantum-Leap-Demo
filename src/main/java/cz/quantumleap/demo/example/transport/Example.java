package cz.quantumleap.demo.example.transport;

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
    private Long lookupField;

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

    public Long getLookupField() {
        return lookupField;
    }

    public void setLookupField(Long lookupField) {
        this.lookupField = lookupField;
    }
}
