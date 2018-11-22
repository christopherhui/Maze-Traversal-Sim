package model.blocks;

import java.awt.*;

public class End extends SpecializedBlock {

    public End() {
        super();
        backgroundColor = new Color(211, 111, 242);
        textColor = Color.BLUE;
        text = "E";
        textDisplay = "End";
    }

    @Override
    public String toString() {
        return text;
    }
}
