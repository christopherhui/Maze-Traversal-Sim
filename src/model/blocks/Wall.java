package model.blocks;

public class Wall extends SpecializedBlock {

    public Wall() {
        backgroundColor = "Black";
        status = 1;
        text = "W";
    }

    @Override
    public String toString() {
        return text;
    }
}
