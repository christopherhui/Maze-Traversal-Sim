package blocks;

public class End implements Block, Display {
    String backgroundColor;
    String textColor;
    int status;

    public End() {
        backgroundColor = "White";
        textColor = "Blue";
        status = 0;
    }

    @Override
    public String get_background_color() {
        return backgroundColor;
    }

    public String get_text_color() {
        return textColor;
    }

    @Override
    public int get_status() {
        return status;
    }

    @Override
    public String to_display() {
        return "E";
    }
}
