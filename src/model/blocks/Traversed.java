package model.blocks;

import java.awt.*;

public class Traversed extends SpecializedBlock {

    public Traversed() {
        super();
        backgroundColor = Color.GRAY;
        status = 1;
        text = "V";
    }

    @Override
    public String toString() {
        return text;
    }
}
