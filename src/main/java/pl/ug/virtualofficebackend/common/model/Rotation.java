package pl.ug.virtualofficebackend.common.model;

public enum Rotation {
    NORTH("NORTH"),
    SOUTH("SOUTH"),
    WEST("WEST"),
    EAST("EAST"),
    ;

    private final String value;

    Rotation(final String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
