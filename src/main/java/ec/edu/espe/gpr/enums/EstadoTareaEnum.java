package ec.edu.espe.gpr.enums;

public enum EstadoTareaEnum {
    ACTIVE("A", "Active"),
    INACTIVE("I", "Inactive");

    private final String value;
    private final String text;

    private EstadoTareaEnum(String value, String text) {
        this.value = value;
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public String getValue() {
        return this.value;
    }
}
