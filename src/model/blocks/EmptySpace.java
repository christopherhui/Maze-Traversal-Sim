package model.blocks;

public class EmptySpace extends SpecializedBlock {

    public EmptySpace() {
        super();
        text = "O";
    }

    @Override
    public String toString() {
        return text;
    }
}
