package blocks;

public class Location implements Block, Display {
    String backgroundColor;
    int status;

    public Location() {
        backgroundColor = "White";
        status = 0;
    }

    @Override
    public String get_background_color() {
        return backgroundColor;
    }

    @Override
    public int get_status() {
        return status;
    }

    @Override
    public String to_display() {
        return "F";
    }
}
