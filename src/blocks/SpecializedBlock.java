package blocks;

public abstract class SpecializedBlock implements Block, Display {
    protected String backgroundColor;
    protected int status;
    protected String textColor;

    public SpecializedBlock() {
        backgroundColor = "White";
        status = 0;
    }

    public String get_background_color() {
        return backgroundColor;
    }

    public int get_status() {
        return status;
    }

    abstract public String to_display();
}
