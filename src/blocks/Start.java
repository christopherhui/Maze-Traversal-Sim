package blocks;

public class Start extends SpecializedBlock{
    private boolean found;

    public Start() {
        super();
        textColor = "Red";
    }

    public String get_text_color() {
        return textColor;
    }

    @Override
    public String to_display() {
        return "S";
    }
}

