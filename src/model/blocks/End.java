package model.blocks;

import java.awt.*;

public class End extends SpecializedBlock {

    public End() {
        super();
        backgroundColor = Color.PINK;
        textColor = Color.BLUE;
        text = "E";
        textDisplay = "End";
    }

    @Override
    public String toString() {
        return text;
    }
}
