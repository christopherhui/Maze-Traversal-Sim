package blocks;

public class End extends SpecializedBlock {
    private boolean found;

    public End() {
        super();
        textColor = "Blue";
    }

    public String get_text_color() {
        return textColor;
    }

    @Override
    public String to_display() {
        return "E";
    }
}
