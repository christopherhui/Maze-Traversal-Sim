package blocks;

public class Traversed implements Block, Display {
    String backgroundColor;
    int status;

    public Traversed() {
        backgroundColor = "White";
        status = 1;
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
        return "V";
    }
}
