package model.blocks;

public class End extends SpecializedBlock {

    public End() {
        super();
        textColor = "Blue";
    }

    @Override
    public String to_display() {
        return "E";
    }
}
