package model.blocks;

import java.awt.*;

public class Wall extends SpecializedBlock {

    public Wall() {
        backgroundColor = Color.BLACK;
        status = 1;
        text = "W";
    }

    @Override
    public String toString() {
        return text;
    }
}
