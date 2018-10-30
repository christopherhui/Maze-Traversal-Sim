package model.blocks;

public class Location extends SpecializedBlock {

    public Location() {
        super();
        backgroundColor = "Green";
    }

    @Override
    public String to_display() {
        return "F";
    }
}
