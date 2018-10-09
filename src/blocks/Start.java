package blocks;

public class Start extends SpecializedBlock{
    private boolean found;

    public Start() {
        super();
        textColor = "Red";
    }

    @Override
    public String to_display() {
        return "S";
    }
}

