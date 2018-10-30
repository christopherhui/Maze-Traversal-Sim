package model.blocks;

public class EmptySpace extends SpecializedBlock {

    public EmptySpace() {
        super();
    }

    @Override
    public String to_display() {
        return "O";
    }
}
