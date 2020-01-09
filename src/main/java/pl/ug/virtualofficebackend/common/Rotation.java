package pl.ug.virtualofficebackend.common;

public enum Rotation {
    NORTH("NORTH"),
    SOUTH("SOUTH"),
    WEST("WEST"),
    EAST("EAST"),
    ;

    private final String text;

    Rotation(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
