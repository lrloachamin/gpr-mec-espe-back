package ec.edu.espe.gpr.enums;

public enum EstadoProyectoEnum {
    ACTIVE("ACT", "Active"),
    INACTIVE("INA", "Inactive");

    private final String value;
    private final String text;

    private EstadoProyectoEnum(String value, String text) {
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
