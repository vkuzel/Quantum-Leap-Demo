package cz.quantumleap.demo.example.domain;

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
    @NotNull
    private JsonField jsonField = new JsonField();

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

    public JsonField getJsonField() {
        return jsonField;
    }

    public void setJsonField(JsonField jsonField) {
        this.jsonField = jsonField;
    }

    public static class JsonField {

        private boolean boolean1;
        private boolean boolean2;

        public boolean isBoolean1() {
            return boolean1;
        }

        public void setBoolean1(boolean boolean1) {
            this.boolean1 = boolean1;
        }

        public boolean isBoolean2() {
            return boolean2;
        }

        public void setBoolean2(boolean boolean2) {
            this.boolean2 = boolean2;
        }
    }
}
