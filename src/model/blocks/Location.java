package model.blocks;

import java.awt.*;

public class Location extends SpecializedBlock {

    public Location() {
        super();
        backgroundColor = Color.GREEN;
        text = "F";
    }

    @Override
    public String toString() {
        return text;
    }
}
