package pl.ug.virtualofficebackend.common.model;

public enum Status {
    ONLINE("ONLINE"),
    BUSY("BUSY"),
    OFFLINE("OFFLINE"),
    ;

    private final String value;

    Status(final String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
