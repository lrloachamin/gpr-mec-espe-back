package ec.edu.espe.gpr.enums;

public enum EstadoTareaDocenteEnum {
    ASIGNADA("ASIGNADA", "ASIGNADA"),
    EN_REVISION("EN REVISIÓN", "EN REVISIÓN"),
    DENEGADO("DENEGADO", "DENEGADO"),
    ACEPTADO("ACEPTADO", "ACEPTADO");


    private final String value;
    private final String text;

    private EstadoTareaDocenteEnum(String value, String text) {
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
