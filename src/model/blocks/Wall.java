package model.blocks;

public class Wall extends SpecializedBlock {

    public Wall() {
        backgroundColor = "Black";
        status = 1;
    }

    @Override
    public String to_display() {
        return "W";
    }
}
