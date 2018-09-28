package blocks;

public class Start implements Block, Display{

    String backgroundColor;
    String textColor;
    int status;

    public Start() {
        backgroundColor = "White";
        textColor = "Red";
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
        return "S";
    }
}

