package blocks;

public class EmptySpace implements Block, Display {
    String backgroundColor;
    int status;

    public EmptySpace() {
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
        return "O";
    }
}
