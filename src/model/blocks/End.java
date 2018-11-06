package model.blocks;

public class End extends SpecializedBlock {

    public End() {
        super();
        textColor = "Blue";
        text = "E";
    }

    @Override
    public String toString() {
        return text;
    }
}
