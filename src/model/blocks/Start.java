package model.blocks;

public class Start extends SpecializedBlock{
    private boolean found;

    public Start() {
        super();
        textColor = "Red";
        text = "S";
    }

    @Override
    public String toString() {
        return text;
    }
}

