package model.blocks;

public class Traversed extends SpecializedBlock {

    public Traversed() {
        super();
        backgroundColor = "Grey";
        status = 1;
        text = "V";
    }

    @Override
    public String toString() {
        return text;
    }
}
