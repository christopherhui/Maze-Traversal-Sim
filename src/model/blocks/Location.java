package model.blocks;

public class Location extends SpecializedBlock {

    public Location() {
        super();
        backgroundColor = "Green";
        text = "F";
    }

    @Override
    public String toString() {
        return text;
    }
}
